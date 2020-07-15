package ch.ivyteam.testservice.types;

import java.util.Date;

import javax.xml.bind.annotation.XmlSchemaType;

public class XsdNativeTypes {

	public String string;

	@XmlSchemaType(name = "date")
	public Date date;
	
	@XmlSchemaType(name = "dateTime") 
	public Date dateTime;
	
	@XmlSchemaType(name="time")
	public Date time;
	
}
