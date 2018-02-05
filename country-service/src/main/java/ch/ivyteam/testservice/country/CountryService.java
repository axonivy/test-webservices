package ch.ivyteam.testservice.country;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

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
}
