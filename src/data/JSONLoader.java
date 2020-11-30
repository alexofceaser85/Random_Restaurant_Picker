package src.data;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import src.error_messages.ErrorMessages;
import src.model.Price;
import src.model.Restaurant;
import src.model.Review;

/**
 * Data utility class for converting JSON formatted responses to corresponding
 * Reviews or Restaurant Lists.
 * 
 * @author Furichous Jones IV
 * @version Fall 2020
 **/
public class JSONLoader {

	public static final String DEFAULT_IMAGE = JSONLoader.class.getClassLoader().getResource("assets/default_image.png")
			.toString();

	/**
	 * Converts rawJSON to reviews list.
	 * 
	 * @param rawJSON JSON string to be parsed
	 * 
	 * @precondition rawJSON != null && !rawJSON.isBlank()
	 * @postcondition none
	 * 
	 * @return parsed reviews list
	 **/
	public static List<Review> parseReviews(String rawJSON) {
		if (rawJSON == null) {
			throw new IllegalArgumentException(ErrorMessages.JSON_SHOULD_NOT_BE_NULL);
		}
		if (rawJSON.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.JSON_SHOULD_NOT_BE_BLANK);
		}
		JSONObject json = new JSONObject(rawJSON);
		JSONArray responses = json.getJSONArray("reviews");
		List<Review> reviews = new ArrayList<Review>();
		for (int i = 0; i < responses.length(); ++i) {
			JSONObject response = responses.getJSONObject(i);
			Review newReview = JSONLoader.parseReview(response);
			if (newReview != null) {
				reviews.add(newReview);
			}
		}
		return reviews;
	}

	private static Review parseReview(JSONObject response) {
		try {
			String textContent = response.getString("text");
			double rating = response.getDouble("rating");
			JSONObject user = response.getJSONObject("user");
			String name = user.getString("name");
			Review newReview = new Review(name, textContent, rating);
			return newReview;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Converts a raw JSON string to a restaurant list.
	 * 
	 * @precondition rawJSON != null && !rawJSON.isBlank()
	 * @postcondition none
	 * 
	 * @param rawJSON JSON string to be parsed
	 * 
	 * @return parsed list of restaurants
	 **/
	public static List<Restaurant> parseRestaurants(String rawJSON) {
		if (rawJSON == null) {
			throw new IllegalArgumentException(ErrorMessages.JSON_SHOULD_NOT_BE_NULL);
		}
		if (rawJSON.isBlank()) {
			throw new IllegalArgumentException(ErrorMessages.JSON_SHOULD_NOT_BE_BLANK);
		}
		JSONObject json = new JSONObject(rawJSON);
		JSONArray businesses = json.getJSONArray("businesses");
		List<Restaurant> restaurants = new ArrayList<Restaurant>();
		for (int i = 0; i < businesses.length(); ++i) {
			JSONObject business = businesses.getJSONObject(i);
			Restaurant newRestaurant = JSONLoader.parseRestaurant(business);
			if (newRestaurant != null) {
				restaurants.add(newRestaurant);
			}
		}
		return restaurants;
	}

	private static Restaurant parseRestaurant(JSONObject business) {
		try {
			String id = business.getString("id");
			String name = business.getString("name");
			String menuURL = business.getString("url");
			JSONObject location = business.getJSONObject("location");

			StringBuilder address = new StringBuilder();
			JSONLoader.extractAddressData(location, address);
			address.setLength(address.length() - 2);

			String price = business.has("price") ? business.getString("price") : "Any";
			double reviewScore = business.has("rating") ? business.getDouble("rating") : 5;
			int distance = JSONLoader.extractDistance(business);
			String imageURL = business.has("image_url") ? business.getString("image_url") : "";

			if (imageURL.isBlank()) {
				imageURL = JSONLoader.DEFAULT_IMAGE;
			}
			Restaurant newRestaurant = new Restaurant(name, Price.valueOf(price), address.toString(), distance,
					reviewScore, menuURL, imageURL, id);
			return newRestaurant;

		} catch (Exception e) {
			return null;
		}
	}

	private static int extractDistance(JSONObject business) {
		int distance = business.has("distance")
				? (business.getInt("distance") + RestaurantsQuery.METER_CONVERSION - 1)
						/ RestaurantsQuery.METER_CONVERSION
				: Integer.MAX_VALUE;
		return distance;
	}

	private static void extractAddressData(JSONObject location, StringBuilder address) {
		JSONArray addressData = location.getJSONArray("display_address");
		for (int j = 0; j < addressData.length(); ++j) {
			address.append(addressData.getString(j));
			address.append(", ");
		}
	}

}