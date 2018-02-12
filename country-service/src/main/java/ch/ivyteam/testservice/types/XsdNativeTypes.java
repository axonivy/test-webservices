package ch.ivyteam.testservice.types;

import java.time.ZonedDateTime;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import ch.ivyteam.testservice.types.adapter.ZoneDateTimeAdapter;

public class XsdNativeTypes {

	public String string;
	public Date date;
	
	@XmlJavaTypeAdapter(ZoneDateTimeAdapter.class) // make xsd:dateType compatible
	public ZonedDateTime dateTime;
	
}
