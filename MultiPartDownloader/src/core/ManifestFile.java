package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

import org.apache.log4j.Logger;
import multipart.Multipart;
public class ManifestFile 
{  
	private String manifestFilePath = "";
	private LinkedList<String> urlsOfSegments = new LinkedList<String>();
	private final static String dalimater = "**";
	private final static String dalimaterExtention = ".";
	private String fileType = "";
	
	public ManifestFile(String manifestFilePath, String fileType) {
		this.manifestFilePath = manifestFilePath;
			this.fileType = fileType;
	}
	final Logger logger = Logger.getLogger(ManifestFile.class);
	//Read File Stream Text
	public  LinkedList readFile() throws IOException,MalformedURLException { 
		// Return the Value of the Segments
			URL url = new URL(manifestFilePath);
				BufferedReader buffer = new BufferedReader(
					new InputStreamReader(url.openStream()));
						String inputLine;
								while ((inputLine = buffer.readLine()) != null){
									if (!inputLine.toString().equalsIgnoreCase(dalimater)){
												urlsOfSegments.add(inputLine);
												}
													}
										buffer.close();
										//Get Segments URLS
											ManifestFileParser manParser = new ManifestFileParser(urlsOfSegments);
												LinkedList<String> pasredSegemntURLs = manParser.parseURL();//get the parsed segments Segments URL and there index
													logger.trace("Read Of file "+manifestFilePath+"Continte Provided");	
														return getSegmentsContants(pasredSegemntURLs);
															}
	//get List to TxtNode
	public LinkedList getSegmentsContants(LinkedList<String> pasredSegemntURLs)
	{
		LinkedList segmentToreturn = null;
		if(fileType.equalsIgnoreCase("txt")){
			segmentToreturn =  getTextSegemnts(pasredSegemntURLs);
		}else if(fileType.equalsIgnoreCase("png") || fileType.equalsIgnoreCase("jpeg") || fileType.equalsIgnoreCase("jpg") 
				|| fileType.equalsIgnoreCase("gif")){
			segmentToreturn =  getImageSegemnts(pasredSegemntURLs);
		}
		return segmentToreturn;
	}
	//get List OF TextFile
	public LinkedList getTextSegemnts(LinkedList<String> pasredSegemntURLs){
		LinkedList<TxtNode> txtNodes = new LinkedList<TxtNode>();
		for (int i = 0 ; i < pasredSegemntURLs.size() ; i++){
				txtNodes.add(new TxtNode(pasredSegemntURLs.get(i)));
			}
		return txtNodes;
	}
	//get part of An image
		public LinkedList getImageSegemnts(LinkedList<String> pasredSegemntURLs){
			LinkedList<ImageNode> imageNodes = new LinkedList<ImageNode>();
			for (int i = 0 ; i < pasredSegemntURLs.size() ; i++){
					imageNodes.add(new ImageNode(pasredSegemntURLs.get(i)));
				}
			return imageNodes;
		}
	//Get the next segments
	
}