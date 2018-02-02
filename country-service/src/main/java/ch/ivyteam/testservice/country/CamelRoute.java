package ch.ivyteam.testservice.country;

import org.apache.camel.builder.RouteBuilder;

import ch.ivyteam.testservice.country.model.CountryService;

public class CamelRoute extends RouteBuilder {

    private String uri = "cxf:/incident?serviceClass=" + CountryService.class.getName();

    @Override
    public void configure() throws Exception {
        from(uri)
            .to("log:input")
            // send the request to the route to handle the operation
            // the name of the operation is in that header
            .recipientList(simple("direct:${header.operationName}"));
        
        from("direct:returnSoapFault")
            .process(exchange -> {
              throw new Exception("SOAP Fault Message - Business Message");
            })
            .to("log:output");
        
//       from("direct:reportIncident")
//            .process(new Processor() {
//                @Override
//                public void process(Exchange exchange) throws Exception {
//                    String id = exchange.getIn().getBody(InputReportIncident.class).getIncidentId();
//                    OutputReportIncident output = new OutputReportIncident();
//                    output.setCode("OK;" + id);
//                    exchange.getOut().setBody(output);
//                }
//            })
//            .to("log:output");

//        from("direct:statusIncident")
//            .process(new Processor() {
//                @Override
//                public void process(Exchange exchange) throws Exception {
//                    OutputStatusIncident output = new OutputStatusIncident();
//                    output.setStatus("IN PROGRESS");
//                    exchange.getOut().setBody(output);
//                }
//            })
//            .to("log:output");
    }
}
