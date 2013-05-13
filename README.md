README
------
NewSQL is a POC designed to evaluate the ability to migrate a standard Spring MVC application from a relational database to a NewSQL database.

HOW-TO
------

1) Running on H2
----------------
cd <Checkout dir>/newsql
mvn install 
cd front
mvn jetty:run

firefox http://localhost:8080/


2) Running gatling
------------------
In another console
cd <Checkout dir>/newsql/injector
./run

3) Running on MySQL
-------------------
Create a newsql schema in MySQL
Execute <Checkout dir>/newsql/data/src/main/resources/db/mysql/schema.sql
Execute <Checkout dir>/newsql/data/src/main/resources/db/mysql/test-data.sql
Put a /etc/newsql/override.properties file containing

dataSource.driverClassName=com.mysql.jdbc.Driver
dataSource.url=jdbc:mysql://localhost:3306/newsql
dataSource.username=newsql
dataSource.password=newsqlpass
initialize-database.enabled=false
dataSource.pool.maxIdle=100
dataSource.pool.maxActive=799
dataSource.pool.maxWait=-1

And goto 1) and 2)

