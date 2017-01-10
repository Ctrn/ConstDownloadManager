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

	/*
	 * Function To convert inputStreamfile String ArrayList file
	 */

	public ArrayList<String> getArreyListFromInputStreamFile(
			InputStream manifestFile) {

		ArrayList<String> manifestArreyString = new ArrayList<String>();
		String line;

		BufferedReader r = new BufferedReader(new InputStreamReader(
				manifestFile));
		try {
			while ((line = r.readLine()) != null) {

				manifestArreyString.add(line);

				// line = "";

			}
		} catch (IOException e) {

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

	public ArrayList<ArrayList<String>> geMDtArreyListFromArrayList(
			ArrayList<String> manifestFile) {

		ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
		ArrayList<String> inner = new ArrayList<String>();
		;
		int j = 0;
		for (int i = 0; i < manifestFile.size(); i++) {

			while (i < manifestFile.size()
					&& !(manifestFile.get(i).equals("**"))) {

				inner.add(manifestFile.get(i));

				i++;
			}

			outer.add(j, inner);

			j++;
			inner = null;
			inner = new ArrayList<String>();

		}
		printArraylist(outer);
		return outer;
	}

	public static void printArraylist(ArrayList<ArrayList<String>> manifestFile) {

		for (ArrayList<String> i : manifestFile) {
			// System.out.println(i);

			for (String str : i) {
				System.out.println(str);
				System.out.println(",");
			}

			
		}
	}

	/*
	 * Function To parse String Array list
	 */
	public static void parseArreylist(ArrayList<ArrayList<String>> manifest)
			throws IOException {

		
		/**
		 * main manifest empty
		 */
		if (manifest.isEmpty() || manifest == null) {
			// nothing to do

		}

		
		
		/**
		 * get the first array segment urls 
		 */
		for (ArrayList<String> i : manifest) {

			
			/**
			 * array segment urls EMPTY 
			 */
			
			if (i.isEmpty()) {
				// bye bye

			}
			int success = 0;
			int j = 0;
			
			/**
			 * take every URL in this array and get the real path
			 * then try to download it
			 * if ok,then make success =1
			 * 
			 */
			
			Segment: while (!i.isEmpty() && success != 1) {

				String str = i.get(j);
				if (str.contains("-segment")) {
					str = str.substring(0, str.length() - 9);
					//System.out.println(str);
					

					// TODO download this path
					// TODO if success download ,set success=1
					j++;
					break Segment;
				}

				if (str.contains(".segments")) {
					str = str.substring(0, str.length() - 9);
					//System.out.println(str);
					

					// TODO create manifestInputStream
					// TODO getArreyListFromInputStreamFile
					// TODO geMDtArreyListFromArrayList
					// TODO parseArreylist
					j++;
					break Segment;

				}

			}// while
		}// for
	}// arraylsit of arry list

}