package ch.ivyteam.testservice.country.incident;

public interface IncidentService {
    OutputReportIncident reportIncident(InputReportIncident input);
    OutputStatusIncident statusIncident(InputStatusIncident input);
}
