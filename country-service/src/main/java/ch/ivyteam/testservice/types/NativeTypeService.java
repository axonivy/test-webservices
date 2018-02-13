package ch.ivyteam.testservice.types;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

@WSDLDocumentationCollection({
  @WSDLDocumentation(value="Interact with XSD native types", placement = WSDLDocumentation.Placement.TOP),
})
@WebService
public class NativeTypeService {

	@WebMethod
	public XsdNativeTypes eval(@WebParam(name = "natives") XsdNativeTypes natives)
	{
		return natives;
	}
}
