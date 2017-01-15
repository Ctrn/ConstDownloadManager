package multipart;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.apache.log4j.Logger;

public class Multipart {
	//Open the Stream by the Assigned url and return the Input Stream of the File
	public static InputStream openStream(String url) throws IOException,MalformedURLException {
	final Logger logger = Logger.getLogger(Multipart.class);
		InputStream input = null ; //intalization of input stream 
		if (validateURL(url)) {//Vaild URL to be opened
			logger.trace("Success Opening Stream for: "+url);
 				input = new URL(url).openStream();//open the stream based on the url	
					}
 				return input;		
	}

	public static boolean validateURL(String url) {
		try {
		    URL myURL = new URL(url);
		    URLConnection myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		    return true;
		} 
		catch (MalformedURLException e) { 
			return false;
		} 
		catch (IOException e) {   
			return false;
		}
	}
}
