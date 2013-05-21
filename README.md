README
------
This application is a POC that will be used during Paris Performance User Group (PerfUG)

Steps 1 & 2 should be executed beforehand in order to fetch all required maven dependencies.

HOW-TO
------

1) Running on H2
----------------
cd <root dir>
mvn install 
cd front
mvn jetty:run

URL: http://localhost:8080/

2) Running gatling
------------------
In another console
cd <root dir>/injector
./run.sh
