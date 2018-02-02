package ch.ivyteam.testservice.country.model;

import java.util.List;

public interface CountryService {
    
  
    List<Country> getCountries();
    Country getCountry(String shortName);
    void returnSoapFault();
    
    
    
    OutputReportIncident reportIncident(InputReportIncident input);
    OutputStatusIncident statusIncident(InputStatusIncident input);
}
