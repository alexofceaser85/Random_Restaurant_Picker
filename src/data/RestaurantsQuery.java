package src.data;

import java.util.List;
import java.util.stream.Collectors;

import src.error_messages.ErrorMessages;
import src.model.Price;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public class RestaurantsQuery extends Query {
	public static final int METER_CONVERSION = 1609;

	/**
	 * Constructor method for RestaurantsQuery
	 * 
	 * @param location           location of search
	 * @param radius             radius of search
	 * @param categories         categories of search
	 * @param reviewScore        minimum reviewScore of search
	 * @param prices             prices of search
	 * @param currentlyOpen      currently open requirement of search
	 * @param handicapAccessible handicap accessible requirement of search
	 * @param reservations       reservations requirement of search
	 * @param hotAndNew          hot and new requirement of search
	 * @param neutralBathroom    gender neutral bathrooms requirement of search
	 * 
	 * @precondition location != null && !location.isBlanK()
	 * @postcondition super.getQuery() != null
	 */
	public RestaurantsQuery(String location, int radius, String categories, double reviewScore, List<Price> prices,
			boolean currentlyOpen, boolean handicapAccessible, boolean reservations, boolean hotAndNew,
			boolean neutralBathroom) {
		if (location == null) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_SHOULD_NOT_BE_NULL);
		}
		if (location.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.LOCATION_SHOULD_NOT_BE_BLANK);
		}

		URLBuilder urlBuilder = this.buildURL();

		urlBuilder.addParameter("term", "restaurants");
		urlBuilder.addParameter("location", location);
		urlBuilder.addParameter("radius", Integer.toString(radius));

		if (categories != null && !categories.isBlank()) {
			urlBuilder.addParameter("categories", categories);
		}
		if (prices != null && !prices.isEmpty()) {
			String pricesCommaSeperated = prices.stream().map(price -> price.getValue())
					.collect(Collectors.joining(","));
			urlBuilder.addParameter("price", pricesCommaSeperated);
		}
		if (currentlyOpen) {
			urlBuilder.addParameter("open_now", Boolean.toString(currentlyOpen));
		}

		this.appendAttributes(handicapAccessible, reservations, hotAndNew, neutralBathroom, urlBuilder);
		super.setQueryURL(urlBuilder.getURL());
	}

	private void appendAttributes(boolean handicapAccessible, boolean reservations, boolean hotAndNew,
			boolean neutralBathroom, URLBuilder urlBuilder) {
		StringBuilder attributes = new StringBuilder();
		if (handicapAccessible) {
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
			attributes.deleteCharAt(attributes.length() - 1);
			urlBuilder.addParameter("attributes", attributes.toString());
		}
	}

	private URLBuilder buildURL() {
		URLBuilder urlBuilder = new URLBuilder(Query.QUERY_HOST, Query.QUERY_PROTOCOL);
		urlBuilder.addFolder("v3");
		urlBuilder.addFolder("businesses");
		urlBuilder.addFolder("search");
		return urlBuilder;
	}
}
