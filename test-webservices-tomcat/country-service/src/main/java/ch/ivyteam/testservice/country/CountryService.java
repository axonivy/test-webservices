package ch.ivyteam.testservice.country;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

@WSDLDocumentationCollection({
  @WSDLDocumentation(value="Here to serve countries", placement = WSDLDocumentation.Placement.TOP),
})
@WebService
public class CountryService
{
  @WebMethod
  public Country getCountryByShortName(@WebParam(name = "shortName") String shortName)
  {
    return Country.countries.stream()
            .filter(c -> shortName.equals(c.getShortName()))
            .findAny()
            .orElse(null);
  }

  @WebMethod
  public void returnSoapFault()
  {
    throw new RuntimeException("SOAP Fault Message - Business Message");
  }
  
  @WebMethod
  public String longRunningOperation(@WebParam(name = "timeoutInMillis") int timeoutInMillis)
  {
    try
    {
      Thread.sleep(timeoutInMillis);
    }
    catch (InterruptedException ex)
    {
      ex.printStackTrace();
    }
    return "This operation took " + timeoutInMillis + " millis.";
  }
}
