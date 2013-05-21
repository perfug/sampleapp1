setlocal
set MAVEN_OPTS=-server -Xmx512M
mvn jetty:run
endlocal