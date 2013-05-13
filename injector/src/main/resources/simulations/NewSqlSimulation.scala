import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import bootstrap._

class NewSqlSimulation extends Simulation {
	val urlBase = "http://localhost"

	val httpConf = httpConfig.baseURL(urlBase).proxy("localhost", 8080).httpsPort(8084)


	val headers_home = Map(
		"Accept" -> """text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8""",
		"Accept-Charset" -> """ISO-8859-1,utf-8;q=0.7,*;q=0.3""",
		"Accept-Encoding" -> """gzip,deflate,sdch""",
		"Accept-Language" -> """fr-FR,fr;q=0.8,en-US;q=0.6,en;q=0.4""",
		"Connection" -> """keep-alive""",
		"Host" -> """localhost:8081""",
		"User-Agent" -> """Mozilla/5.0 (Windows NT 6.1) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11"""
	)

	val headers_requests = headers_home ++ Map(
		"Referer" -> """http://localhost:8081/"""
		)
		
	//In seconds
	//For stress test use 250 s.
	val rampUp = 10;
	//In seconds, be carefull to never had a duration smaller than the pause time... scenario will never end
	//For stress test use rampUp + 100
	val duration = rampUp * 4
	
	//It seems that only queue and random feeder are available today
	//random is required as feeder requires as many lines in CSV as hit...
	val groups = csv("newsql_groups.csv").random
	//newsql_products file contains both countryCode, productId, storeId
	val products = csv("newsql_products.csv").random
	
	val txScn = scenario("Transaction scenario")
			.feed(products)
		.during(duration) {
		exec(
			http("transaction_new")
			.get("/transaction")
			.queryParam("countryCode", "${countryCode}")
			.queryParam("productId", "${productId}")
			.queryParam("storeId", "${storeId}")
			.headers(headers_requests)
			.check(regex(""".*\{"txId":([0-9]*),.*""").exists.saveAs("transactionId"))
		)
		.pause(1, 2)
		.doIf((s: Session) => {
			val txS = s.getAttribute("transactionId"); 
			txS match {  
					case n:Long => n > 0;
					case s:String => s.forall(_.isDigit) && s.toLong > 0;
					case _ => false;
				}
			}) {
			exec(
				http("transaction_with_txId")
				.get("/transaction")
				.queryParam("countryCode", "${countryCode}")
				.queryParam("productId", "${productId}")
				.queryParam("storeId", "${storeId}")
				.queryParam("txId", "${transactionId}")
				.headers(headers_requests)
			)
		}
		.pause(2, 3)
		.exec(
			http("total")
			.get("/total")
			.queryParam("txId", "${transactionId}")
			.headers(headers_requests)
		)
		.pause(2, 3)
	}
	
	val ivtScn = scenario("Inventory scenario")
			.feed(products)
		.during(duration){
		exec(
			http("Inventory")
			.get("/inventory")
			.queryParam("storeId", "${storeId}")
			.headers(headers_requests)
		)
		.pause(5, 10)
	}
	
	val toScn = scenario("Turnover scenario")
			.feed(groups)
		.during(duration){
		exec(
			http("turnover")
			.get("/turnover")
			.queryParam("groupId", "${groupId}")
			.headers(headers_requests)
		)
		.pause(5, 10)
	}

	setUp(
		txScn.users(80).ramp(rampUp).protocolConfig(httpConf),
		ivtScn.users(10).ramp(rampUp).protocolConfig(httpConf),
		toScn.users(10).ramp(rampUp).protocolConfig(httpConf)
	)
}