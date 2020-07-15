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
            "Policies declare that this service will not run without ws-addressing headers.\n"
            + "The policy will install Addressing interceptors on client and server side!"),
})
@WebService
@Policy(uri = "AddressingPolicy.xml", placement = BINDING)
public class GreetPolicyService
{
  @WebMethod
  public String greet(@WebParam(name = "greet") String message)
  {
    return message;
  }
}
