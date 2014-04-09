package rss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UsdanRssReadr {

	private URL url;
	
	
/**
 * This turns a string into a URL object
 * @param webAddress
 * @return url
 */
	public URL setUrl(String webAddress) {
		try {
			this.url = new URL(webAddress);
			return url;
		} catch (MalformedURLException e) {
			System.out.println("failed to accept url");
			return url;
		}
	}
/**
 * this is a specialized reader for the Bon-appetite, auto generated RSS feed.
 *  invokes the cleanr class to scrub the feed of mistakes and unnecessary tagging.
 * @param inputURL
 * @return menuItems (the weekly menu in string format)
 * @throws Exception
 */
	public String readFromFeed(URL inputURL) throws Exception {
		int count = 0;
		String menuItems = "";
		RssCleanr cleanr = new RssCleanr();
		BufferedReader in = new BufferedReader(new InputStreamReader(
				inputURL.openStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {

			if (cleanr.asciiToText(inputLine).length() > 5) {
				if ((cleanr.asciiToText(inputLine)).substring(0, 6)
						.equals("<title")) {
					count++;
				}
				if (count > 1)
					menuItems = menuItems + "\n" + cleanr.asciiToText(inputLine);

			}
		}
		in.close();
		return cleanr.removeTags(menuItems);
	}

	
	/**http://legacy.cafebonappetit.com/rss/menu/332
	 * prints the menu for the week according to bon appetite 
	 * @param args
	 */
	public static void main(String[] args) {
		UsdanRssReadr readr = new UsdanRssReadr();
		try {

			System.out.println(readr.readFromFeed(readr
					.setUrl("http://legacy.cafebonappetit.com/rss/menu/332")));
		} catch (Exception e) {
			System.out.println("wrong URL system crash");
		}
	}

}