package tests;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import multipart.Multipart;

/**
 * JUnit tests for the multipart downloader.
 */
public class MultipartTest {

	/**
	 * If the downloader is asked to download a normal, empty file, then a valid
	 * InputStream should be returned, but should report end-of-file for every
	 * read.
	 */
	@Test
	public void emptyFile() throws IOException {
		InputStream in = Multipart.openStream(
				"http://ec2-54-186-190-13.us-west-2.compute.amazonaws.com:8080/MultiDownDATA/BadSeperator/md.segments");

		Assert.assertNotNull("null stream", in);

		// (would have gotten a NullPointerException soon anyway, but doesn't
		// hurt to be explicit.)

		Assert.assertEquals("file should be empty", in.read(), -1);

		// note that InputStream.read(byte[] buf) will return 0 if and only if
		// buf.length==0:
		Assert.assertEquals("file should still be empty", in.read(new byte[1024]), -1);

		Assert.assertEquals("file should still be empty", in.read(), -1);

		in.close();
	}

	/**
	 * If the downloader is asked to download a multi-part, empty file, then a
	 * valid InputStream should be returned, but should report end-of-file for
	 * every read.
	 */
	@Test
	public void emptyPartsFile() throws IOException {
		// the complexities of the parts file actually do most of the testing:
		InputStream in = Multipart.openStream(
				"http://ec2-54-186-190-13.us-west-2.compute.amazonaws.com:8080/MultiDownDATA/BadSeperator/md.segments");

		Assert.assertNotNull("null stream", in);
		// (would have gotten a NullPointerException soon anyway, but doesn't
		// hurt to be explicit.)

		Assert.assertEquals("file should be empty", in.read(), -1);

		// note that InputStream.read(byte[] buf) will return 0 if and only if
		// buf.length==0:
		Assert.assertEquals("file should still be empty", in.read(new byte[1024]), -1);

		Assert.assertEquals("file should still be empty", in.read(), -1);

		in.close();
	}

}