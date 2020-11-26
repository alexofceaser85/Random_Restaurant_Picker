package src.data;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ReviewsQuery extends Query  {

	public ReviewsQuery(String restaurantID) throws MalformedURLException, URISyntaxException {
		URLBuilder  urlBuilder = new URLBuilder(Query.queryHost, Query.queryProtocol);
		urlBuilder.addFolder("v3");
		urlBuilder.addFolder("businesses");
		urlBuilder.addFolder(restaurantID);
		urlBuilder.addFolder("reviews");
		super.setQueryURL(urlBuilder.getURL());
	}
}
