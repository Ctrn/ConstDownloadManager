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
	private final static int dalimater = 2;
	public ManifestFile(String manifestFilePath) {
		this.manifestFilePath = manifestFilePath;
	}
	//Read File Stream
	public  LinkedList<TxtNode> readFile() throws IOException,MalformedURLException { // Return the Value of the Segments
		final Logger logger = Logger.getLogger(ManifestFile.class);
			URL url = new URL(manifestFilePath);
				BufferedReader buffer = new BufferedReader(
					new InputStreamReader(url.openStream()));
						String inputLine;
								while ((inputLine = buffer.readLine()) != null){
									if (inputLine.length() != dalimater){
											urlsOfSegments.add(inputLine);
									}
								}
										buffer.close();//close Buffer
										//Get Segments URLS
											ManifestFileParser manParser = new ManifestFileParser(urlsOfSegments);
												LinkedList<String> pasredSegemntURLs = manParser.parseURL();//get the parsed segments Segments URL and there index
													return getSegmentsContants(pasredSegemntURLs);
									}
	//get List to TxtNode
	public LinkedList<TxtNode> getSegmentsContants(LinkedList<String> pasredSegemntURLs)
			throws IOException,MalformedURLException
	{
		LinkedList<TxtNode> txtNodes = new LinkedList<TxtNode>();
		for (int i = 0 ; i < pasredSegemntURLs.size() ; i++){
			txtNodes.add(new TxtNode(pasredSegemntURLs.get(i)));
		}
		
		return txtNodes;
	}
}