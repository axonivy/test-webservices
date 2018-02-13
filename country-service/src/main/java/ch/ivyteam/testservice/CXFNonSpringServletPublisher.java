package ch.ivyteam.testservice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

import org.apache.cxf.BusFactory;
import org.apache.cxf.interceptor.InterceptorProvider;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.common.WSS4JConstants;
import org.apache.wss4j.common.ext.WSPasswordCallback;

import ch.ivyteam.testservice.country.CountryService;
import ch.ivyteam.testservice.types.NativeTypeService;

@WebServlet("/webservices/*")
public class CXFNonSpringServletPublisher extends CXFNonSpringServlet
{
  private static final long serialVersionUID = 2L;

  @Override
  public void loadBus(ServletConfig servletConfig)
  {
    super.loadBus(servletConfig);
    BusFactory.setDefaultBus(getBus());
    
    Endpoint.publish("/country", new CountryService());
    Endpoint endpoint = Endpoint.publish("/country-wssecurity", new CountryService());
    protectEndpointByWSSecurity(endpoint);
  
    Endpoint.publish("/native", new NativeTypeService());
  }
  
  private static void protectEndpointByWSSecurity(Endpoint endpoint)
  {
    InterceptorProvider interceptorProvider = (InterceptorProvider) endpoint;
    Map<String, Object> inProps = new HashMap<>();
    WSS4JInInterceptor wssIn = new WSS4JInInterceptor(inProps);
    inProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
    inProps.put(ConfigurationConstants.MUST_UNDERSTAND, false);
    inProps.put(ConfigurationConstants.PASSWORD_TYPE, WSS4JConstants.PW_TEXT);
    inProps.put(ConfigurationConstants.PW_CALLBACK_CLASS, PasswordCallback.class.getName());
    interceptorProvider.getInInterceptors().add(wssIn);
  }
  
  public static class PasswordCallback implements CallbackHandler
  {
    private static Map<String, String> passwordStore = new HashMap<>();
    {
      passwordStore.put("hans", "4321");
    }
    
    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException
    {
      WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
      String password = passwordStore.get(pc.getIdentifier());
      if (password != null)
      {
        pc.setPassword(password);
      }
    }
  }
}