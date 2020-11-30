package src.data;

import src.error_messages.ErrorMessages;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public class ReviewsQuery extends Query {

	/**
	 * @precondition none
	 * @postcondition none
	 * @param restaurantID
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
