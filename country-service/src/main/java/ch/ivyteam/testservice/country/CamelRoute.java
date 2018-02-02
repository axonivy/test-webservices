package ch.ivyteam.testservice.country;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import ch.ivyteam.testservice.country.model.Country;
import ch.ivyteam.testservice.country.model.CountryService;
import ch.ivyteam.testservice.country.model.InputReportIncident;
import ch.ivyteam.testservice.country.model.OutputReportIncident;
import ch.ivyteam.testservice.country.model.OutputStatusIncident;

public class CamelRoute extends RouteBuilder {

    // CXF webservice using code first approach
    private String uri = "cxf:/incident?serviceClass=" + CountryService.class.getName();

    @Override
    public void configure() throws Exception {
        from(uri)
            .to("log:input")
            // send the request to the route to handle the operation
            // the name of the operation is in that header
            .recipientList(simple("direct:${header.operationName}"));

        from("direct:getCountries")
          .process(new Processor() {
              @Override
              public void process(Exchange exchange) throws Exception {
                  exchange.getOut().setBody(Country.countries);
              }
          })
        .to("log:output");
        
        
        from("direct:getCountry")
          .process(new Processor() {
              @Override
              public void process(Exchange exchange) throws Exception {
                  String shortname = exchange.getIn().getBody(String.class);
                  Country country = Country.countries.stream()
                    .filter(c -> c.getShortName().equals(shortname))
                    .findAny()
                    .orElse(null);
                  exchange.getOut().setBody(country);
              }
          })
        .to("log:output");
        
        
        from("direct:returnSoapFault")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                  throw new Exception("SOAP Fault Message - Business Message");
                }
            })
            .to("log:output");
        
        
        
        
        
        
        
        
        
        
        
        // report incident
        from("direct:reportIncident")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    String id = exchange.getIn().getBody(InputReportIncident.class).getIncidentId();
                    OutputReportIncident output = new OutputReportIncident();
                    output.setCode("OK;" + id);
                    exchange.getOut().setBody(output);
                }
            })
            .to("log:output");

        // status incident
        from("direct:statusIncident")
            .process(new Processor() {
                @Override
                public void process(Exchange exchange) throws Exception {
                    OutputStatusIncident output = new OutputStatusIncident();
                    output.setStatus("IN PROGRESS");
                    exchange.getOut().setBody(output);
                }
            })
            .to("log:output");
    }
}
