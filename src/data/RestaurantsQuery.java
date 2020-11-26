package src.data;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import src.error_messages.ErrorMessages;
import src.model.Price;

public class RestaurantsQuery extends Query {
	public RestaurantsQuery(String location, 
			int radius, 
			String categories, 
			double reviewScore, 
			List<Price> prices, 
			boolean currentlyOpen, 
			boolean handicap, 
			boolean reservations, 
			boolean hotAndNew, 
			boolean neutralBathroom) {
		if(location == null) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_SHOULD_NOT_BE_NULL);
		}
		if(location.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_SHOULD_NOT_BE_BLANK);
		}
		URLBuilder  urlBuilder = new URLBuilder(Query.QUERY_HOST, Query.QUERY_PROTOCOL);
		urlBuilder.addFolder("v3");
		urlBuilder.addFolder("businesses");
		urlBuilder.addFolder("search");
		urlBuilder.addParameter("term", "restaurants");
		urlBuilder.addParameter("location", location);
		urlBuilder.addParameter("radius", Integer.toString(radius));
		if (categories != null && !categories.isBlank()) {
			urlBuilder.addParameter("categories", categories);
		}
		if (prices != null && !prices.isEmpty()) {
			String pricesCommaSeperated = prices.stream()
	                .map(price -> price.value)
	                .collect(Collectors.joining(","));
			urlBuilder.addParameter("price", pricesCommaSeperated);
		}
		if (currentlyOpen) {
			urlBuilder.addParameter("open_now", Boolean.toString(currentlyOpen));
		}
		StringBuilder attributes = new StringBuilder();
		if (handicap) {
			attributes.append("wheelchair_accessible");
			attributes.append(",");
		}
		if (reservations) {
			attributes.append("reservation");
			attributes.append(",");
		}
		if (hotAndNew) {
			attributes.append("hot_and_new");
			attributes.append(",");
		}
		if (neutralBathroom) {
			attributes.append("gender_neutral_restrooms");
			attributes.append(",");
		}
		if (attributes.length() > 0) {
			attributes.deleteCharAt(attributes.length()-1);
			urlBuilder.addParameter("attributes", attributes.toString());
		}
		super.setQueryURL(urlBuilder.getURL());
	}
}
