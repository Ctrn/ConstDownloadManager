package multipart;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
 
public class DownloadManger { 
	
	public DownloadManger()
	{
		
		}
	//Open the URL of the Designated and Return its Input Data -Bytes- 
	public static byte[] downloadURL(InputStream openedURL)
	 		throws IOException, EOFException {
	 		int sizeOfRead;
	 		try {
	 			sizeOfRead = new DataInputStream(openedURL).readInt();
	 		} catch(EOFException e) { // no more sub-files
	 			return null;
	 		}
	 
	 		byte[] dataInURL = new byte[sizeOfRead];
	 		int readedCovrage = 0;
	 		while(readedCovrage < sizeOfRead) {
	 			int readLine = openedURL.read(dataInURL, readedCovrage, sizeOfRead-readedCovrage);
	 			if(readLine==-1)
	 				throw new EOFException("Stream Reached Line: "
	 									+readedCovrage+" With a Bytes of "
	 											+sizeOfRead);
	 			readedCovrage += readLine;
	 		}
	 		return dataInURL;
	 	}
	 }

