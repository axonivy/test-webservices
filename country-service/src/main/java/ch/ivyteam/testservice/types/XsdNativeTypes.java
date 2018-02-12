package ch.ivyteam.testservice.types;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;

public class XsdNativeTypes {

	public String string;

	@XmlElement(name = "date", required = false)
	public Date date;
	
	@XmlElement(name = "dateTime", required = false) 
	public Date dateTime;
	
	@XmlElement(name = "time", required = false)
	public Date time;
	
}
