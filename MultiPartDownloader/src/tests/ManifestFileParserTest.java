package tests;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import core.ManifestFileParser;;

public class ManifestFileParserTest {
	
	protected LinkedList<String>linkedlist =null;

	@Before
	public void setUp() throws Exception {
		
		 linkedlist = new LinkedList<String>();
		
	}

	@Test
	public void parseURL() {

		
		linkedlist.add("http://ec2-54-186-190-13.us-west-2.compute.amazonaws.com:8080:8080/MultiDownDATA/segments/md.seg1.seg");

		ManifestFileParser parser =new ManifestFileParser(linkedlist);
		
		assertSame("http://ec2-54-186-190-13.us-west-2.compute.amazonaws.com:8080:8080/MultiDownDATA/segments/md.seg1.seg", parser);
		
	
	}

}
