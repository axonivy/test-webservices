package ch.ivyteam.testservice.fileupload;

import static org.apache.cxf.annotations.WSDLDocumentation.Placement.TOP;

import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;
import org.apache.cxf.annotations.WSDLDocumentation;
import org.apache.cxf.annotations.WSDLDocumentationCollection;

@WSDLDocumentationCollection({ @WSDLDocumentation(placement = TOP, value = "Hashes the uploaded file with SHA2"), })
@WebService
public class FileUploadHasherService {

	@WebMethod
	public String getSha2HashForDataHandler(@WebParam(name="file")@XmlMimeType("application/octet-stream")DataHandler file) throws IOException {
		final InputStream in = file.getInputStream();
		byte[] byteArray = IOUtils.toByteArray(in);

		return DigestUtils.sha256Hex(byteArray);
	}
	
	@WebMethod
	public String getSha2HashForByteArray(@WebParam(name="file")DataHandler file) throws IOException {
		final InputStream in = file.getInputStream();
		byte[] byteArray = IOUtils.toByteArray(in);

		return DigestUtils.sha256Hex(byteArray);
	}

}
