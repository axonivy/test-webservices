package ch.ivyteam.testservice.country;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

@WebServlet("/webservices/*")
public class CXFNonSpringServletPublisher extends CXFNonSpringServlet
{
  private static final long serialVersionUID = 1L;

  @Override
  public void loadBus(ServletConfig servletConfig)
  {
    super.loadBus(servletConfig);
    BusFactory.setDefaultBus(getBus());
    Endpoint.publish("/country", new CountryService());
  }
}
