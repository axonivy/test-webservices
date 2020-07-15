package ch.ivyteam.testservice.policy;

import static org.apache.cxf.annotations.Policy.Placement.BINDING;
import static org.apache.cxf.annotations.WSDLDocumentation.Placement.TOP;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.Policy;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

@WSDLDocumentationCollection({
    @WSDLDocumentation(placement = TOP, value = 
            "Policies declare that this service will not run without ws-security UsernameToken headers")
})
@WebService
@Policy(uri = "SecurityPolicy.xml", placement = BINDING)
public class SecureGreetPolicyService
{
  @WebMethod
  public String greet(@WebParam(name = "greet") String message)
  {
    return message;
  }
}
