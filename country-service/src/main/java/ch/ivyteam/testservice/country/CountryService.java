package ch.ivyteam.testservice.country;

import javax.jws.WebMethod;

public class CountryService
{
  @WebMethod
  public void returnSoapFault()
  {
    throw new RuntimeException("SOAP Fault Message - Business Message");
  }
}
