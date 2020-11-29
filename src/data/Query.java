package src.data;

import java.net.URL;

public abstract class Query {
	public static final String QUERY_PROTOCOL = "https";
	public static final String QUERY_HOST = "api.yelp.com";
	private URL queryURL;

	public void setQueryURL(URL queryURL) {
		this.queryURL = queryURL;
	}

	public URL getQueryURL() {
		return this.queryURL;
	}
}
