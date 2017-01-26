package core;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
public interface Segment {

	public  URL openURL() throws IOException,MalformedURLException;
	public  boolean  isFileToRead();
	public boolean isASequnce();
}
