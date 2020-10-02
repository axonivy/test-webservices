package com.axonivy.test.rest.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * Initially copied from jax-rs jersey examples: 
 * https://github.com/jesperfj/jax-rs-upload-file/blob/master/src/main/java/org/example/resources/BlobResource.java
 */
@Path("/blob")
public class BlobResource {

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces("text/plain")
    public String handleUpload(
            @FormDataParam("file") InputStream fileUploadStream, 
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {

        if(fileDetail==null || fileDetail.getFileName()==null) {
            return "No filename";
        }
        System.out.println("Receiving file "+fileDetail.getFileName());
        File f = new File(fileDetail.getFileName());
        long ts = System.currentTimeMillis();
        try(InputStream is = fileUploadStream)
        {
        }
        System.out.println("Received file "+f.getName()+" in "+(System.currentTimeMillis()-ts)/1000+"s");
        return "File "+f.getName()+" received\n";
        
    }

    @GET
    @Path("/{file}")
    @Produces("application/octet-stream")
    public StreamingOutput handleDownload(@PathParam("file") final String file) throws Exception {
        return new StreamingOutput() {
            @Override
            public void write(OutputStream output) throws IOException {
                System.out.println("File "+file+" requested");
                long ts = System.currentTimeMillis();
                byte[] buf = new byte[16384];
                try(FileInputStream in = new FileInputStream(new File(file)))
                {
                	int len = in.read(buf); 
                	while(len!=-1) {
                		output.write(buf,0,len);
                		len = in.read(buf);
                	}
                }
                System.out.println("File "+file+" successfully downloaded in "+(System.currentTimeMillis()-ts)/1000+"s");
            }
        };
    }
    
}
	
