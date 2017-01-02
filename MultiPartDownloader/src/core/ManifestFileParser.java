/*
 * Class to parse a Manifest file 
 * Date Created: 1/1/2017
 * Author: Hanan Namrouti 
 */
package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class ManifestFileParser {

	Logger logger = Logger.getLogger(Segment.class);

	/*
	 * Function To convert inputStreamfile String ArrayList 
	 * file
	 */

	public ArrayList<String> getArreyListFromInputStreamFile(InputStream manifestFile) {

		logger.debug("You are in getArreyListFromInputStreamFile Method ");

		ArrayList<String> manifestArreyString = new ArrayList<String>();
		String line;

		BufferedReader r = new BufferedReader(new InputStreamReader(manifestFile));
		try {
			while ((line = r.readLine()) != null ) {
				logger.debug("File Line is" + line);
				manifestArreyString.add(line);
				line = "";

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return manifestArreyString;

	}
 
	/*
	 * Function To parse String Array list
	 */
	public void parseArreylist(ArrayList<String> manifest) throws IOException {

		logger.debug("You are in parseArreylist Method ");

		for (String str : manifest) {

			logger.debug("String is  " + str);
			String path = new URL(str).getPath();
			logger.debug("String path  is " + str);
			
			if (str.contains("-segment")) {
				path = path.substring(0, path.length() - 9);
				logger.debug("String path after deleteing Suffixes is " + str);

				// TODO download this path
			}
			if (str.contains(".segments")) {
				path = path.substring(0, path.length() - 9);
				logger.debug("String path after deleteing Suffixes is " + str);

				// TODO create manifestInputStream
				// TODO getArreyListFromInputStreamFile
				// TODO parseArreylist

			}
		}

	}

}
