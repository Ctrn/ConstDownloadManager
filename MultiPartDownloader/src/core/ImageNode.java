package core;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;

import sequnce.FileSequenceReader;

public class ImageNode implements Segment{
	
	private String imageURL = ""; 
	private Image imageContent = null; 
	
	private final static String[] fileTypeToRead = {"jpeg","png","gif"};
	private final static String sequnceType = "-seq";
	
	public ImageNode(String imageURL){
		this.imageURL = imageURL;
	}

	final Logger logger = Logger.getLogger(ImageNode.class);
	
	public byte[] readContntFromURL() throws  IOException,MalformedURLException{
		// Get Image Path
		URL imagePath = openURL();
		InputStream imageData = imagePath.openStream();
		ByteArrayOutputStream buffer = new ByteArrayOutputStream();

		int nRead;
		byte[] data = new byte[163804];
		while ((nRead = imageData.read(data, 0, data.length)) != -1) {
		  buffer.write(data, 0, nRead);
		}
		buffer.flush();
		return buffer.toByteArray();
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
