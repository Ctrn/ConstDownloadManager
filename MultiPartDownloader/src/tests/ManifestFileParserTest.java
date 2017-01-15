package core;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ManifestFileParserTest extends ManifestFileParser {
	@Test
	public void testFileInputStream() throws FileNotFoundException {
		FileInputStream data = new FileInputStream("c:/data/data.txt");
		// return data;// FIXED
	}

	@Test
	public void testGetArreyListFromInputStreamFile()
			throws FileNotFoundException {
		FileInputStream data = new FileInputStream("c:/data/data.txt");
		ArrayList<String> manifestArreyString = new ArrayList<String>();
		manifestArreyString
				.add("http://machine1.birzeit.edu/picture.jpg-segment1");
		manifestArreyString.add("**");
		manifestArreyString
				.add("http://machine1.birzeit.edu/picture.jpg-segment2");
		manifestArreyString.add("**");
		manifestArreyString
				.add("http://machine1.birzeit.edu/picture.jpg-segment3");

		ArrayList<String> manifestArreyString1 = new ArrayList<String>();
		manifestArreyString1.add("text,text");
		manifestArreyString1.add("hananhanan");
		assertEquals(manifestArreyString, getArreyListFromInputStreamFile(data));
		assertNotSame(manifestArreyString1,
				getArreyListFromInputStreamFile(data));

	}

	@Test
	public void testGeMDtArreyListFromArrayList() throws FileNotFoundException {

		ArrayList<String> manifestArreyString = new ArrayList<String>();
		manifestArreyString
				.add("http://machine1.birzeit.edu/picture.jpg-segment1");
		manifestArreyString
				.add("http://machine2.birzeit.edu/picture.jpg-segment1");
		manifestArreyString.add("**");

		manifestArreyString
				.add("http://machine1.birzeit.edu/picture.jpg-segment2");
		manifestArreyString
				.add("http://machine2.birzeit.edu/picture.jpg-segment2");
		manifestArreyString.add("**");

		manifestArreyString
				.add("http://machine1.birzeit.edu/picture.jpg-segment3");
		manifestArreyString
				.add("http://machine2.birzeit.edu/picture.jpg-segment3");

		ArrayList<String> array1 = new ArrayList<String>();
		array1.add("http://machine1.birzeit.edu/picture.jpg-segment1");
		array1.add("http://machine2.birzeit.edu/picture.jpg-segment1");
		ArrayList<String> array2 = new ArrayList<String>();
		array2.add("http://machine1.birzeit.edu/picture.jpg-segment2");
		array2.add("http://machine2.birzeit.edu/picture.jpg-segment2");
		ArrayList<String> array3 = new ArrayList<String>();
		array3.add("http://machine1.birzeit.edu/picture.jpg-segment3");
		array3.add("http://machine2.birzeit.edu/picture.jpg-segment3");

		ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
		outer.add(0,array1);
		outer.add(1,array2);
		outer.add(2,array3);
		
		//printArraylist(outer);
		//printArraylist(geMDtArreyListFromArrayList(manifestArreyString));
		assertEquals(outer, geMDtArreyListFromArrayList(manifestArreyString));

	}

	

}