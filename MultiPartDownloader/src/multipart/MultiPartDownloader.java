package multipart;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import core.Segment;

public class MultiPartDownloader {
	private LinkedList<Segment> fileSegments = new LinkedList<Segment>();  
		private LinkedList<InputStream> downloadedSegment = new LinkedList<InputStream>();
			private DownloadManger downloadManager = new DownloadManger();
	
	public MultiPartDownloader(){
	}
    //Setting the Values of the List Of Segments
	public void setFileSegments(LinkedList<Segment> fileSegments) {
		this.fileSegments = fileSegments;
	}
	//Download Segments List Files
	public void downloadSegmentsFromPath()    
	{
		//get Number OF Segments Associated With the File
		int numberOfSegments = this.fileSegments.size();
			for( int i = 0 ; i <= numberOfSegments ; i++ )
			{
//				this.downloadedSegment.add(downloadManager.
//						downloadURL(
//								fileSegments.get(i).
//									readStream(fileSegments.get(i).getUrl()))); 
							}
								}
	//Get The Downloaded Stream
	public LinkedList<InputStream> getDownloadedSegment() {
		return downloadedSegment;
	}

	
}
