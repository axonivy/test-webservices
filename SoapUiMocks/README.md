# SoapUIMocks

## Add new WSDL to SoapUI project
1. Open SoapUI project inside `SoapUiMocks/` folder
2. Right-click on the Project and select `Add WSDL`
3. Select WSDL to import,select `Create MockService`
4. Select a free Port on the next screen, continue with ok
6. Add response test data into `Response 1`
7. Save the project
8. Also copy the original wsdl to a sub-folder of `wsdl` subfolder
9. Copy the whole `wsdl` subfolder into `C:\inetpub\wwwroot\soapui\` so that the WSDLs become available under the URL `http://zugtstweb/test-wsdls/wsdl/`
(For some reasons the original wsdls need to be available when starting the Mock service)