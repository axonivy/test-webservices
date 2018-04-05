# SoapUIMocks

## Add new WSDL to SoapUI project
1. Copy the original wsdl to a sub-folder of the `wsdl` subfolder
1. Copy the whole `wsdl` subfolder into `C:\inetpub\wwwroot\soapui\` so that the WSDLs become available under the URL `http://zugtstweb/test-wsdls/wsdl/`
1. Open SoapUI project inside `SoapUiMocks/` folder
1. Right-click on the Project and select `Add WSDL`
1. Select WSDL to import from the `zugtstweb` server, select `Create MockService`
1. Select a free Port on the next screen, continue with ok
1. Add response test data into `Response 1`
1. Save the project

(For some reasons some of the original WSDLs need to be available when starting the Mock service)