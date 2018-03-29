# ivy-test-webservices

Internal Test-WebServices

## Projects

## country-service

*   Sample Soap Services based on CXF.
*	Deployed with Pipeline-Built.
*	Provides its services also ws-security protected.

## IvyEchoService

*	Sample Soap Services based on AXIS2
*	No idea how this web service is built.
*	It is manually installed as webapp (axis2) on tomcat. 

## test-rest-service

* 	Jersey JAX-RS
* 	Sample Rest Services
*	Deployed with Pipeline-Built.

## SOAPUIMocks

*   SOAP UI based: runs as service on ZugTstWeb
*   contains public services that we fake for usage in our tests
*   Yet no automated deployment possible: It must be manually stored in \\zugtstweb\C:\SoapUiMocks
*   Soap UI Mock service (windows) must be restarted manually after a new deployment

## Deployment

For deployment have a look at the Jenkinsfile. If you want to deploy on your local machine, then you have to add the credentials in your local maven settings.

	<servers>
		<server>
			<id>zugtstweb.tomcat</id>
			<username>admin</username>
			<password>default admin password</password>
		</server>
	</servers>

