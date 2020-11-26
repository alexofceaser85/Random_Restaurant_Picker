package src.data;

import java.net.URL;

import src.error_messages.ErrorMessages;

public abstract class Query {
	public final static String QUERY_PROTOCOL = "https";
	public final static String QUERY_HOST = "api.yelp.com";
	private URL queryURL;
	
	public void setQueryURL(URL queryURL) {
		this.queryURL = queryURL;
	}
	
	public URL getQueryURL() {
		return this.queryURL;
	}
}
