package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class ImageNode implements Segment{
	
	private String imageURL = ""; 
	private String imageContent = ""; 
	
	private final static String[] fileTypeToRead = {"jpeg","png","gif"};
	private final static String sequnceType = "-seq";
	
	public ImageNode(String imageURL){
		this.imageURL = imageURL;
	}
	
	final Logger logger = Logger.getLogger(ImageNode.class);
	
	public String readContntFromURL() throws  IOException,MalformedURLException{
		return "";
	}
	
	@Override
	public URL openURL() throws IOException, MalformedURLException {
		URL  segmentPath = new URL(imageURL);
			logger.trace("URL of: "+imageURL+" IS Successfuly Opened");
				return segmentPath;
	}
	@Override
	public boolean isFileToRead() {
		boolean checkRes = false;
			String fileType = imageURL.substring(imageURL.lastIndexOf(".")+1);
				for(int i = 0 ; i < 3 ; i++ ){
					if(fileTypeToRead[i].equalsIgnoreCase(fileType)){
						logger.trace("The Image is With the Extnetion of: "+fileType);
							checkRes = true;
					}
				}
		return checkRes;
	}
	@Override
	public boolean isASequnce() {
		String fileType = imageURL.substring(imageURL.lastIndexOf("-"));
		logger.trace("Nested Sequnce..");
			return sequnceType.equalsIgnoreCase(fileType);
	}
}
