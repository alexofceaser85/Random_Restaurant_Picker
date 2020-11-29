package src.data;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import src.error_messages.ErrorMessages;

public class QueryManager {
	private final static String API_KEY = "9B_u4A_JIL2TMNprBShU-c1xqVg-BBPECjzq6TfwUaQ3gYE84nxJAfuSp5GDHoq3AMlRxG6v-9hla4y4P2RrqLX0btJYb5amXmTfxSVdQGG4O5M-NXBYXjHlXF2_X3Yx";
	
	public static String sendQuery(Query currentQuery) {
		if(currentQuery == null) {
			throw new IllegalArgumentException(ErrorMessages.QUERY_SHOULD_NOT_BE_NULL);
		}
		URL queryURL = currentQuery.getQueryURL();
		try {
			URLConnection urlConn = queryURL.openConnection();
			urlConn.setRequestProperty("Authorization", "Bearer " + QueryManager.API_KEY);
			urlConn.connect();
			try (InputStream inputStream = urlConn.getInputStream()) {
				return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
			}
		} catch (Exception e) {
			return null;
		}
	}	
}
