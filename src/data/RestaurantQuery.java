package src.data;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import src.error_messages.ErrorMessages;
import src.model.Price;

public class RestaurantQuery extends Query {
	public RestaurantQuery(String location, 
			int radius, 
			String categories, 
			double reviewScore, 
			List<Price> prices, 
			boolean currentlyOpen, 
			boolean handicap, 
			boolean reservations, 
			boolean hotAndNew, 
			boolean neutralBathroom) throws MalformedURLException, URISyntaxException{
		if(location == null) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_SHOULD_NOT_BE_NULL);
		}
		if(location.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_SHOULD_NOT_BE_BLANK);
		}
		if(categories == null) {
			throw new IllegalArgumentException(ErrorMessages.CATEGORIES_SHOULD_NOT_BE_NULL);
		}
		if(prices == null) {
			throw new IllegalArgumentException(ErrorMessages.PRICES_SHOULD_NOT_BE_NULL);
		}
		URLBuilder  urlBuilder = new URLBuilder(Query.queryHost, Query.queryProtocol);
		urlBuilder.addFolder("v3");
		urlBuilder.addFolder("businesses");
		urlBuilder.addFolder("search");
		urlBuilder.addParameter("term", "restaurants");
		urlBuilder.addParameter("location", location);
		urlBuilder.addParameter("radius", Integer.toString(radius));
		urlBuilder.addParameter("open_now", Boolean.toString(currentlyOpen));
		if (!prices.isEmpty()) {
			String pricesCommaSeperated = prices.stream()
	                .map(price -> price.value)
	                .collect(Collectors.joining(","));
			urlBuilder.addParameter("price", pricesCommaSeperated);
		}
		StringBuilder attributes = new StringBuilder();
		attributes.append(handicap);
		attributes.append(",");
		attributes.append(reservations);
		attributes.append(",");
		attributes.append(hotAndNew);
		attributes.append(",");
		attributes.append(neutralBathroom);
		urlBuilder.addParameter("attributes", attributes.toString());
		super.setQueryURL(urlBuilder.getURL());
	}
}
