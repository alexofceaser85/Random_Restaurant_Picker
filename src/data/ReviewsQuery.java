package src.data;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import src.error_messages.ErrorMessages;

public class ReviewsQuery extends Query  {

	public ReviewsQuery(String restaurantID) throws MalformedURLException, URISyntaxException {
		if(restaurantID == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANTID_SHOULD_NOT_BE_NULL);
		}
		if(restaurantID.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANTID_SHOULD_NOT_BE_BLANK);
		}
		URLBuilder  urlBuilder = new URLBuilder(Query.queryHost, Query.queryProtocol);
		urlBuilder.addFolder("v3");
		urlBuilder.addFolder("businesses");
		urlBuilder.addFolder(restaurantID);
		urlBuilder.addFolder("reviews");
		super.setQueryURL(urlBuilder.getURL());
	}
}
