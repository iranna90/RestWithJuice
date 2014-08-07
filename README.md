# Jersey 2 with Guice
This PoC demonstrates how to wire Jersey (which uses its own dependency injection framework, HK2) and Guice together.

## Build
Run `mvn clean package` and deploy the war-File in the `target` directory to the application server of your choice.

## Test
After deploying the application to an application server, the REST service answers `GET` requests to `/`.

For example: If you deployed `jersey2-guice-1.0.0-SNAPSHOT.war` to a Tomcat running on `localhost` port `8080`, open
`http://localhost:8080/jersey2-guice-1.0.0-SNAPSHOT/` in your browser.