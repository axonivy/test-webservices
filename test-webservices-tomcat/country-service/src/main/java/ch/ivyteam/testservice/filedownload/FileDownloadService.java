package ch.ivyteam.testservice.filedownload;

import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.mail.util.ByteArrayDataSource;
import javax.xml.bind.annotation.XmlMimeType;

@WebService
public class FileDownloadService {
	@WebMethod
	@XmlMimeType("application/octet-stream")
	public DataHandler getFileAsDataHandler() throws IOException {
		InputStream inputStream = FileDownloadService.class.getResourceAsStream("testfile.txt");
		
		DataHandler dataHandler = new DataHandler(new ByteArrayDataSource(inputStream, "application/octet-stream"));
		return dataHandler;
	}
	
	@WebMethod
	public DataHandler getFileAsByteArray() throws IOException {
		InputStream inputStream = FileDownloadService.class.getResourceAsStream("testfile.txt");
		
		DataHandler dataHandler = new DataHandler(new ByteArrayDataSource(inputStream, "application/octet-stream"));
		return dataHandler;
	}
}
