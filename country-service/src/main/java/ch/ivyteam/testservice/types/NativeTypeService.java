package ch.ivyteam.testservice.types;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Interacts with XSD native types.
 */
@WebService
public class NativeTypeService {

	@WebMethod
	public XsdNativeTypes eval(@WebParam(name = "natives") XsdNativeTypes natives)
	{
		return natives;
	}
}
