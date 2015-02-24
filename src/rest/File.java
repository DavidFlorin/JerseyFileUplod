package rest;
import java.io.DataInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;


/**
 * Uplod File
 *
 * @author florindavid
 * @date Feb 24, 2015
 * */
@Path("file")
public class File {
	
	/** Servlet Request							*/
	@Context private HttpServletRequest servletRequest;

	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void upload() throws Exception
	{
		int formDataLength = servletRequest.getContentLength();
		
		DataInputStream in = new DataInputStream (servletRequest.getInputStream()); 
		byte[] data = new byte[formDataLength];
		int bytesRead = 0;
		int totalBytesRead = 0;
		while (totalBytesRead < formDataLength)
		{
			bytesRead = in.read(data, totalBytesRead, formDataLength);
			totalBytesRead += bytesRead;
		}
		in.close();
		
		///....
	}

}
