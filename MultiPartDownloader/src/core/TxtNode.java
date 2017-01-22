package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class TxtNode implements Segment{

	private String segmentURL = "";
	private String segmentContent = "";
	public TxtNode(String segmentURL){
		this.segmentURL = segmentURL;
	}
	@Override
	public String readContntFromURL() throws  IOException,MalformedURLException{
		URL segmentPath = new URL(segmentURL);
		BufferedReader buffer = new BufferedReader(
			new InputStreamReader(segmentPath.openStream()));
				String inputLine;
				while ((inputLine = buffer.readLine()) != null){
								segmentContent += inputLine;
									}				
				return segmentContent;
	}

	@Override
	public boolean checkFileType(String url) {
		// TODO Auto-generated method stub
		return false;
	}

}
