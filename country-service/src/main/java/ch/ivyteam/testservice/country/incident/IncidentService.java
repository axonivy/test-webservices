package ch.ivyteam.testservice.country.incident;

public interface IncidentService {
    void returnSoapFault();
    OutputReportIncident reportIncident(InputReportIncident input);
    OutputStatusIncident statusIncident(InputStatusIncident input);
}
