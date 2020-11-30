package src.data;

import src.error_messages.ErrorMessages;

/**
 * Models a Review Query for the Yelp API.
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public class ReviewsQuery extends Query {

	/**
	 * One-parameter constructor
	 * 
	 * @precondition restaurantID != null && !restaurantID.isEmpty()
	 * @postcondition none
	 * 
	 * @param restaurantID ID of the restaurant whose reviews are being retrieved.
	 */
	public ReviewsQuery(String restaurantID) {
		if (restaurantID == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANTID_SHOULD_NOT_BE_NULL);
		}
		if (restaurantID.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANTID_SHOULD_NOT_BE_BLANK);
		}
		URLBuilder urlBuilder = new URLBuilder(Query.QUERY_HOST, Query.QUERY_PROTOCOL);
		urlBuilder.addFolder("v3");
		urlBuilder.addFolder("businesses");
		urlBuilder.addFolder(restaurantID);
		urlBuilder.addFolder("reviews");
		super.setQueryURL(urlBuilder.getURL());
	}
}
