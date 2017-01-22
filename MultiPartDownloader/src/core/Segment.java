package core;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
public interface Segment {

	public  String readContntFromURL() throws IOException,MalformedURLException;
	public  boolean checkFileType(String url);
}
