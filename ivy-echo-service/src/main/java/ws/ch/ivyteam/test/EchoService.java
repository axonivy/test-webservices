package ch.ivyteam.test.ws;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.axis2.context.MessageContext;
import org.apache.axis2.transport.http.HTTPConstants;

public class EchoService
{
  public String getHelloMessage()
  {
    return "Hello, here you see a message from me!";
  }

  public void returnVoid()
  {
  }

  public Object returnNullObject()
  {
    return null;
  }

  public void logMessageToStdOut(String message)
  {
    System.out.println("logMessage( " + message + " ) ");
  }

  public String echoString(String message)
  {
    return message;
  }

  public Object echoObject(Object obj)
  {
    return obj;
  }

  public Date echoDate(Date date)
  {
    return date;
  }

  public String getSessionId()
  {
    Object property = MessageContext.getCurrentMessageContext().getProperty(HTTPConstants.MC_HTTP_SERVLETREQUEST);
    return ((HttpServletRequest)property).getSession().getId();
  }
  
  public void waitFor(long waitTimeInMs)
  {
    try
    {
      Thread.sleep(waitTimeInMs);
    }
    catch (InterruptedException ex)
    {
    }
  }
}
