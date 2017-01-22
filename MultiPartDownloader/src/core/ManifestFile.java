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
	public ManifestFile(String manifestFilePath) {
		this.manifestFilePath = manifestFilePath;
	}
	//Read File Stream
	public  void readFile() throws IOException,MalformedURLException { // Return the Value of the Segments
		final Logger logger = Logger.getLogger(ManifestFile.class);
			URL url = new URL(manifestFilePath);
				BufferedReader buffer = new BufferedReader(
					new InputStreamReader(url.openStream()));
						String inputLine;
						int count = 0;
								while ((inputLine = buffer.readLine()) != null){
									if(count%2 == 0){
											urlsOfSegments.add(inputLine);
											}
											count++;
									}
										buffer.close();
								}
	public void getSegmentsOfFile(){
		ManifestFileParser manParser = new ManifestFileParser(urlsOfSegments);
	}
}