package core;
/*
 * Purpose is to convert a string url that represents a downloadable link into an object 
 * Created: 1/1/2017
 * Author: Citreen Shihadeh
 *  
 */
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.Logger;

public class Segment {

	final static Logger logger = Logger.getLogger(Segment.class);
	private List<Segment> mirrors_list;
	private URL url; //maybe protected??
	
	public Segment (String myUrl) throws MalformedURLException{
		logger.debug("Entering Segment constructor function");
		logger.debug("URL is " + myUrl);
		
		url = new URL(myUrl);
		mirrors_list = new ArrayList<Segment>();
	}

	/*
	 * Function to write the content of URL in a given segment into an output stream
	 */
	public void writeSegmentToStream(OutputStream output_stream) throws IOException{
	// TODO	
	}
	
	private InputStream readStream(URLConnection url_conn){
		try{
			logger.debug("Success: Connecting and reading URL " + url_conn);
			return url_conn.getInputStream();
			
		} catch (IOException e) {
			
			logger.error("FAIL: Invalid URL" + url_conn + "is detected.");
			logger.error("Exception was thrown: " + e);
			return null; 
		}
	}
	
	public void insertMirror(Segment segment){
		this.mirrors_list.add(segment);
	}
	/*
	 * Getters and setters
	 */ 
	public List<Segment> getMirrors() {
		return mirrors_list;
	}
	
}
