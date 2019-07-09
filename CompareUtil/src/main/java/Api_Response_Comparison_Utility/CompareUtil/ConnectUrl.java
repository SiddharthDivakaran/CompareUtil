package Api_Response_Comparison_Utility.CompareUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.UnknownHostException;

class ConnectUrl {
	/**
	 * gives response for the given url
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public StringBuilder getResponse(String url) throws IOException {
		if (isValidUrl(url) == false)
			return new StringBuilder("inValid url: \"" + url + "\"");

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
			InputStream inStream;
			int responseCode = connection.getResponseCode();

			if (200 <= responseCode && responseCode < 300) {
				inStream = connection.getInputStream();
			} else {
				inStream = connection.getErrorStream();
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(inStream));

			StringBuilder response = new StringBuilder();
			String currentLine;

			while ((currentLine = br.readLine()) != null)
				response.append(currentLine);
			br.close();

			return new StringBuilder(response.toString());
		} catch (UnknownHostException e) {
			return new StringBuilder("host is unkown for url: " + "\"" + url + "\"");
		} catch (Exception e) {
			return new StringBuilder("source not available");
		}

	}

	/**
	 * check if given url is valid
	 * 
	 * @param url
	 * @return
	 */
	public boolean isValidUrl(String url) {
		try {
			new URL(url).toURI();
			return true;
		} catch (URISyntaxException e) {
			return false;
		} catch (MalformedURLException e) {
			return false;
		}
	}

}
