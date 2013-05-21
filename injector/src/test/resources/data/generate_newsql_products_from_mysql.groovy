import groovy.sql.Sql
println "countryCode,productId,storeId"
this.getClass().classLoader.rootLoader.addURL(new File("/home/ubuntu/.m2/repository/mysql/mysql-connector-java/5.1.18/mysql-connector-java-5.1.18.jar").toURL());
sql = Sql.newInstance( 'jdbc:mysql://10.32.31.82:3306/newsql', 'newsql',
                      'newsqlpass', 'com.mysql.jdbc.Driver' )
sql.eachRow( 'select c.alpha3Code as countryCode, p.id as productId, sr.id as storeId from Product p inner join Stock st on st.product_id=p.id inner join Store sr on sr.id=st.store_id inner join CategoryFamily cf on p.categoryFamily_id=cf.id inner join CategoryFamily_VAT cfv on cf.id=cfv.categoryFamily_id inner join VAT vat on cfv.vats_id=vat.id inner join Country c on c.alpha3Code=vat.country_alpha3Code;' ) { println "$it.countryCode,$it.productId,$it.storeId" }

