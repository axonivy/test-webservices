# SoapUIMocks

## Add new WSDL to the SoapUI project
1. Copy the original wsdl to a sub-folder of the `wsdl` subfolder.
1. Copy the whole `wsdl` subfolder into `C:\inetpub\wwwroot\test-wsdls\` so that the WSDLs become available under the URL `http://zugtstweb/test-wsdls/wsdl/[yourmockservice].wsdl`.
1. Open SoapUI project inside `C:\SoapUiMocks\` folder. NOTE: SoapUI needs to be run as Administrator.
1. Check the next available port number that is not used yet by existing mock services (7077 and later).
1. Right-click on the Project and select `Add WSDL`.
1. Select WSDL to import from the local directory, select `Create MockService`.
1. Fill in the free port number on the next screen, continue with ok.
1. Add response test data into `Response 1`.
1. Save the project.
1. Close SoapUI.
1. Open the project XML in an editor and replace occurences of <your hostname> with zugtstweb, if necessary.
1. Restart the `Soap UI Mock Services` Windows service.
1. Add the Generated WSDL URL to the list on this page: https://jira.axonivy.com/confluence/display/IVYTEAM/ZugTstWeb.
1. Check-in the new WSDL file and the updated SoapUI mock services project file into this repository.

(For some reasons some of the original WSDLs need to be available when starting the Mock service)

## Add an new operation of an existing WSDL to the SoapUI project
1. Update the WSDL file under `C:\inetpub\wwwroot\test-wsdls\`.
1. Open SoapUI project inside `C:\SoapUiMocks\` folder. NOTE: SoapUI needs to be run as Administrator.
1. Go to the service definition that needs to be updated.
1. Right-click on the service and select `Update definition`.
1. Un-select all flags and press OK.
1. Right-click the mock service and select `New MockOperation`.
1. Choose the newly added operation(s) and click OK.
1. Add response test data into `Response 1`.
1. Save the project.
1. Close SoapUI.
1. Restart the `Soap UI Mock Services` Windows service.
1. Check-in the updated WSDL file and the updated SoapUI mock services project file into this repository.