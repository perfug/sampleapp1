README
------
This application is a POC that will be used during Paris Performance User Group

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
In case the following error is encountered, launch ./run again
[ERROR] Failed to execute goal on project gatling-charts-highcharts: Could not resolve dependencies for project io.gatling.highcharts:gatling-charts-highcharts:jar:2.0.0-SNAPSHOT: The following artifacts could not be resolved: io.gatling:gatling-app:jar:2.0.0-SNAPSHOT, io.gatling:gatling-charts:jar:2.0.0-SNAPSHOT, io.gatling:gatling-recorder:jar:2.0.0-SNAPSHOT: Could not find artifact io.gatling:gatling-app:jar:2.0.0-SNAPSHOT -> [Help 1]

