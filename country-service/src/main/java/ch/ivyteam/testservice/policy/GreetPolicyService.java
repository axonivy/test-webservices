package ch.ivyteam.testservice.policy;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.Policy;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

@WSDLDocumentationCollection({
  @WSDLDocumentation(value="Enforces policies", placement = WSDLDocumentation.Placement.TOP),
})
@WebService
@Policy(placement = Policy.Placement.BINDING, uri = "SecurityPolicy.xml")
public class GreetPolicyService {

	
	@WebMethod
	public String greet(@WebParam(name = "greet") String message)
	{
		return message;
	}
}
