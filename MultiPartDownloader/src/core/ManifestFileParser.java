package core;

import java.util.LinkedList;

public class ManifestFileParser {
	private LinkedList<String> segmentsURL = new LinkedList<String>();
	private LinkedList<String> segmentsParsedURLs = new LinkedList<String>();
	private final static String dalimter = ".part";
		public ManifestFileParser(LinkedList<String> segmentsURL) {
			this.segmentsURL = segmentsURL;
				}
		public LinkedList<String> parseURL() 
		{
			int i;
				int numberOfSegments = segmentsURL.size();
					if (numberOfSegments != 0) { 
						for( i = 0 ; i < numberOfSegments ; i++  ){
						segmentsParsedURLs.add(
								segmentsURL.get(i).substring(0,segmentsURL.get(i).lastIndexOf('.'))
												);		
							}
					}
					return segmentsParsedURLs;
		}
		 
}