import groovy.sql.Sql
println "groupId"
this.getClass().classLoader.rootLoader.addURL(new File("/home/ubuntu/.m2/repository/mysql/mysql-connector-java/5.1.18/mysql-connector-java-5.1.18.jar").toURL());
sql = Sql.newInstance( 'jdbc:mysql://10.229.42.176:3306/newsql', 'newsql',
                      'newsqlpass', 'com.mysql.jdbc.Driver' )
sql.eachRow( 'select distinct groupId from SaleTransaction' ) { println "$it.groupId" }
