package core;

import java.io.FileInputStream;
import java.io.FileNotFoundException; 
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ManifestFile 
{  
	private String manifestFilePath = "";
	public ManifestFile(String manifestFilePath) {
		this.manifestFilePath = manifestFilePath;
	}
	//File Streaming   
	public InputStream fetchFileFromPath() 
	{
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
	}
}