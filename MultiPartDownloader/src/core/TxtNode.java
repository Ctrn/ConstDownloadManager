package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class TxtNode implements Segment{
	
	private String segmentURL = "";
	private String segmentContent = "";
	private final static String fileTypeToRead = "txt";
	private final static String sequnceType = "-seq";
	
	public TxtNode(String segmentURL){
		this.segmentURL = segmentURL;
	}
	
	final Logger logger = Logger.getLogger(TxtNode.class);
	
	public String readContntFromURL() throws  IOException,MalformedURLException{
		if(isFileToRead()){
		URL segmentPath = openURL();
			BufferedReader buffer = new BufferedReader(
					new InputStreamReader(segmentPath.openStream()));
						String inputLine;
							while ((inputLine = buffer.readLine()) != null){
								segmentContent += inputLine;
									}	
			}
		else if(isASequnce()){
			//TO DO
		}
			return segmentContent;
	}
	@Override
	public URL openURL() throws  IOException,MalformedURLException{
		URL  segmentPath = new URL(segmentURL);
			logger.trace("URL of: "+segmentURL+" IS Successfuly Opened");
				return segmentPath;
	}
	@Override
	public boolean isFileToRead() {
		String fileType = segmentURL.substring(segmentURL.lastIndexOf(".")+1);
			logger.trace("File To Be Read is A TXT File..");
				return fileTypeToRead.equalsIgnoreCase(fileType);
	}
	@Override
	public boolean isASequnce() {
		String fileType = segmentURL.substring(segmentURL.lastIndexOf(".")+1);
			logger.trace("Nested Sequnce..");
				return sequnceType.equalsIgnoreCase(fileType);
	}

}
