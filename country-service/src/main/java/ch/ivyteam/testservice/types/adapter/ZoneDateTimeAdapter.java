package ch.ivyteam.testservice.types.adapter;

import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ZoneDateTimeAdapter extends XmlAdapter<Calendar, ZonedDateTime>{

	@Override
	public Calendar marshal(ZonedDateTime zonedDateTime) throws Exception {
		return GregorianCalendar.from(zonedDateTime);
	}

	@Override
	public ZonedDateTime unmarshal(Calendar calendar) throws Exception {
		if (calendar instanceof GregorianCalendar)
		{
			return ((GregorianCalendar)calendar).toZonedDateTime();
		}
		GregorianCalendar gregorian = new GregorianCalendar();
		gregorian.setTime(calendar.getTime());
		return gregorian.toZonedDateTime();
	}

}
