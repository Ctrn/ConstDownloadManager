package core;

<<<<<<< HEAD
import java.io.FileInputStream;
import java.io.FileNotFoundException;
=======
import java.io.BufferedReader;
>>>>>>> branch 'master' of https://github.com/Ctrn/ConstDownloadManager.git
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

<<<<<<< HEAD
public class ManifestFile {
=======
import org.apache.log4j.Logger;
import multipart.Multipart;
public class ManifestFile 
{  
>>>>>>> branch 'master' of https://github.com/Ctrn/ConstDownloadManager.git
	private String manifestFilePath = "";
<<<<<<< HEAD

=======
	private LinkedList<String> urlsOfSegments = new LinkedList<String>();
	private final static int dalimater = 2;
>>>>>>> branch 'master' of https://github.com/Ctrn/ConstDownloadManager.git
	public ManifestFile(String manifestFilePath) {
		this.manifestFilePath = manifestFilePath;
	}
<<<<<<< HEAD

	// File Streaming
	public InputStream fetchFileFromPath() {
		InputStream fileFields = null;
		try {
			fileFields = new FileInputStream(manifestFilePath);
			fileFields.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileFields;
=======
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
>>>>>>> branch 'master' of https://github.com/Ctrn/ConstDownloadManager.git
	}
}