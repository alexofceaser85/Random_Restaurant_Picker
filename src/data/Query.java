package src.data;

import java.net.URL;

public abstract class Query {
	public static String queryProtocol = "https";
	public static String queryHost = "api.yelp.com";
	private URL queryURL;
	
	
	public void setQueryURL(URL queryURL) {
		this.queryURL = queryURL;
	}
	
	public URL getQueryURL() {
		return this.queryURL;
	}
}
