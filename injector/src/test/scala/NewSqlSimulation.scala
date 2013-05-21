import com.excilys.ebi.gatling.core.Predef._
import com.excilys.ebi.gatling.http.Predef._
import bootstrap._

class NewSqlSimulation extends Simulation {
	// Target server
  val server = "localhost"
  val port = "8080"
  val url = "http://" + server + ":" + port
  // Test params (in seconds)
  val rampUp = 10;
  val duration = rampUp * 4
  val thinkRatio = 1
  // Users per scenario
  val txUsers = 80
  val ivtUsers = 10
  val toUsers = 10

	val httpConf = httpConfig
    .baseURL(url)
    .acceptHeader("application/json, text/plain, */*")
    .acceptCharsetHeader("ISO-8859-1,utf-8;q=0.7,*;q=0.3")
    .acceptEncodingHeader("gzip,deflate,sdch")
    .acceptLanguageHeader("en-US,en;q=0.8,fr;q=0.6")
    .connection("keep-alive")
    .userAgentHeader("Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31")
    .warmUp(url)

	val headers = Map(
		"Accept" -> """text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"""
	)
	
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
			.headers(headers)
			.check(regex(""".*\{"txId":([0-9]*),.*""").exists.saveAs("transactionId"))
		)
		.pause(1 * thinkRatio, 2 * thinkRatio)
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
				.headers(headers)
			)
		}
		.pause(2 * thinkRatio, 3 * thinkRatio)
		.exec(
			http("total")
			.get("/total")
			.queryParam("txId", "${transactionId}")
			.headers(headers)
		)
		.pause(2 * thinkRatio, 3 * thinkRatio)
	}
	
	val ivtScn = scenario("Inventory scenario")
			.feed(products)
		.during(duration){
		exec(
			http("Inventory")
			.get("/inventory")
			.queryParam("storeId", "${storeId}")
			.headers(headers)
		)
		.pause(5 * thinkRatio, 10 * thinkRatio)
	}
	
	val toScn = scenario("Turnover scenario")
			.feed(groups)
		.during(duration){
		exec(
			http("turnover")
			.get("/turnover")
			.queryParam("groupId", "${groupId}")
			.headers(headers)
		)
		.pause(5 * thinkRatio, 10 * thinkRatio)
	}

	setUp(
		txScn.users(txUsers).ramp(rampUp).protocolConfig(httpConf),
		ivtScn.users(ivtUsers).ramp(rampUp).protocolConfig(httpConf),
		toScn.users(toUsers).ramp(rampUp).protocolConfig(httpConf)
	)
}