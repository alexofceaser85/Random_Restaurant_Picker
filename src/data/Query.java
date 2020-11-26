package src.data;

import java.net.URL;

import src.error_messages.ErrorMessages;

public abstract class Query {
	public static String queryProtocol = "https";
	public static String queryHost = "api.yelp.com";
	private URL queryURL;
	
	
	public void setQueryURL(URL queryURL) {
		if(queryURL == null) {
			throw new IllegalArgumentException(ErrorMessages.QUERYURL_SHOULD_NOT_BE_NULL);
		}
		this.queryURL = queryURL;
	}
	
	public URL getQueryURL() {
		return this.queryURL;
	}
}
