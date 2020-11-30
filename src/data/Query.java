package src.data;

import java.net.URL;

/**
 * Models a Review Query to be sent to the Yelp API.
 * 
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public abstract class Query {
	public static final String QUERY_PROTOCOL = "https";
	public static final String QUERY_HOST = "api.yelp.com";
	private URL queryURL;

	/**
	 * Sets the query URL to a specified value.
	 * 
	 * @precondition none
	 * @postconditon getQueryURL == queryURL
	 *
	 * @param queryURL the specfied queryURL.
	 */
	public void setQueryURL(URL queryURL) {
		this.queryURL = queryURL;
	}

	/**
	 * Gets the query URL.
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return the query URL.
	 */
	public URL getQueryURL() {
		return this.queryURL;
	}
}
