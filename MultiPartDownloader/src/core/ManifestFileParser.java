package core;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

public class ManifestFileParser {
	private LinkedList<String> segmentsURL = new LinkedList<String>();
	private LinkedList<String> segmentsParsedURLs = new LinkedList<String>();
	private final static String dalimter = ".part";
	private final static String Sequnce = "-seq";
		public ManifestFileParser(LinkedList<String> segmentsURL) {
			this.segmentsURL = segmentsURL;
				}
		final Logger logger = Logger.getLogger(ManifestFileParser.class);
		public LinkedList<String> parseURL() throws MalformedURLException, IOException
		{
			int i;
				int numberOfSegments = segmentsURL.size();
					if (numberOfSegments != 0) { 
						for( i = 0 ; i < numberOfSegments ; i++  ){
							if(check404ForURL(segmentsURL.get(i))){
								segmentsParsedURLs.add(segmentsURL.get(i));
									System.out.println("In Parser: "+segmentsURL.get(i));
									}
								
							}
					}
					return removeRedundantURL();
		}
		//Check URL for 404 
				public boolean check404ForURL(String urlOfSeg) throws MalformedURLException, IOException
				{
					boolean checkres = false; 
					final URL url = new URL(urlOfSeg);
						HttpURLConnection huc = (HttpURLConnection) url.openConnection();
							int responseCode = huc.getResponseCode();
								if (responseCode != 404) {
									checkres = true;
									logger.trace("Valid URL:"+urlOfSeg);
								} 
									return checkres;
					}
		//Remove Redundant Links
			public LinkedList<String> removeRedundantURL(){
				int size = segmentsParsedURLs.size();
				LinkedList<String> nonRedundantURL = new LinkedList<String>(); 
				for(int i = 0 ; i < size;i++)
				{
					if(i+1 < size){
						if(!segmentsParsedURLs.get(i).equalsIgnoreCase(segmentsParsedURLs.get(i+1))){
							nonRedundantURL.add(segmentsParsedURLs.get(i));
								logger.trace("Adding A None Duplictaed URL:"+segmentsParsedURLs.get(i));
						}
					}
				}
				return nonRedundantURL;
			}
	}
