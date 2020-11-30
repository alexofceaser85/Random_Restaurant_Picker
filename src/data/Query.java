package src.data;

import java.net.URL;


/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public abstract class Query {
	public static final String QUERY_PROTOCOL = "https";
	public static final String QUERY_HOST = "api.yelp.com";
	private URL queryURL;

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param queryURL
	 */
	public void setQueryURL(URL queryURL) {
		this.queryURL = queryURL;
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @return
	 */
	public URL getQueryURL() {
		return this.queryURL;
	}
}
