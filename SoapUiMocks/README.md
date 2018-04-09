# SoapUIMocks

## Add new WSDL to SoapUI project
1. Copy the original wsdl to a sub-folder of the `wsdl` subfolder
1. Copy the whole `wsdl` subfolder into `C:\inetpub\wwwroot\soapui\` so that the WSDLs become available under the URL `http://zugtstweb/test-wsdls/wsdl/`
1. Open SoapUI project inside `SoapUiMocks/` folder
1. Check which next Port is not yet used by checking the different existing mock services (7077 and later)
1. Right-click on the Project and select `Add WSDL`
1. Select WSDL to import from the `zugtstweb` server, select `Create MockService`
1. Select a free Port on the next screen, continue with ok
1. Add response test data into `Response 1`
1. Save the project
1. Close SoapUI
1. Open the project XML in an editor and replace occurences of <your hostname> with zugtstweb
1. Add the Generated WSDL URL to the list in this file


(For some reasons some of the original WSDLs need to be available when starting the Mock service)


Existing services:

SAP WS with Policy:
http://zugtstweb:7078/mockZHR_WF_READ_PERS_DATA_soap12?WSDL


SAP WS without Policy:
http://zugtstweb:7079/mockZHR_WF_READ_PERS_DATA_WithoutPolicy_soap12?WSDL


SAP WS with lists (getItem):
http://zugtstweb:7081/mockZEBC_COP_PUG_GET_ES_DATA_soap12?WSDL


SAP WS with embedded Binary:
http://zugtstweb:7082/mockZHR_WSIF_AXONIVY_MSS_soap12?WSDL


SAP WS with MTOM Binary Attachment:
http://zugtstweb:7084/mockZHR_WSIF_AXONIVY_MSS_MTOM_soap12?WSDL


Docservice WS (Lists as parameter, causes generation problems):
http://zugtstweb:7080/mockacme2_eakte?WSDL
