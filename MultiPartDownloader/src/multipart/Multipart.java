package multipart;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Multipart {

	public Multipart(){
		
	}
	//Open the Stream by the Assigned url and return the Input Stream of the File
	public static InputStream openStream(String url) throws IOException,MalformedURLException {
		InputStream input = null; //intalization of input stream 
			input = new URL(url).openStream();//open the stream based on the url
					return input;
	}
}
