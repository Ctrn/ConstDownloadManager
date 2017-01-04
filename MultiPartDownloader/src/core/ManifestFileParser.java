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
	 * Function To convert inputStreamfile String ArrayList file
	 */

	public ArrayList<String> getArreyListFromInputStreamFile(InputStream manifestFile) {

		logger.debug("You are in getArreyListFromInputStreamFile Method ");

		ArrayList<String> manifestArreyString = new ArrayList<String>();
		String line;

		BufferedReader r = new BufferedReader(new InputStreamReader(manifestFile));
		try {
			while ((line = r.readLine()) != null) {
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

	/**
	 * This Method with create arraylist of arraylist without ** the main
	 * purpose Mirror
	 * 
	 * @param manifestFile
	 * @return ArrayList<ArrayList<String>>
	 */

	 public static  ArrayList<ArrayList<String>> geMDtArreyListFromArrayList(ArrayList<String> manifestFile) {

		ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
		ArrayList<String> inner = new ArrayList<String>();

		for (int i = 0; i < manifestFile.size(); i++) {

			while (i < manifestFile.size() && !(manifestFile.get(i).equals("**"))) {

				inner.add(manifestFile.get(i));
				System.out.println(manifestFile.get(i));
				i++;
			}

			outer.add(inner);
			inner.clear();
			;

		}
		
		return outer;
	}

	public void printArraylist(ArrayList<ArrayList<String>> manifestFile) {

		// ArrayList<ArrayList<String>> arrayList = new ArrayList<>();

		for (ArrayList<String> i : manifestFile) { // iterate -list by list
			System.out.println(i);
			/*
			 * for (String str : i) {// iterate element by element in a list
			 * System.out.println(str); System.out.println(","); }
			 */

		}
	}

	/*
	 * Function To parse String Array list
	 * 
	 */
	public  void parseArreylist(ArrayList<ArrayList<String>> manifest) throws IOException {

		//.debug("You are in parseArreylist Method ");

		if (manifest.isEmpty() || manifest == null) {
			// nothing to do

		}

		for (ArrayList<String> i : manifest) {

			if (i.isEmpty()) {
				// bye bye

			}
			int success = 0;
			while (!i.isEmpty() && success != 1) {
				String str = null;
				String path = new URL(str).getPath();

				if (str.contains("-segment")) {
					path = path.substring(0, path.length() - 9);
					System.out.println(path);
				//	logger.debug("String path after deleteing Suffixes is " + str);

					// TODO download this path
					// if download is success success=1
				}
				if (str.contains(".segments")) {
					path = path.substring(0, path.length() - 9);
					System.out.println(path);
					//logger.debug("String path after deleteing Suffixes is " + str);

					// TODO create manifestInputStream
					// TODO getArreyListFromInputStreamFile
					// TODO geMDtArreyListFromArrayList
					// TODO parseArreylist

				}

			} // while

		}

	}//

	
}
