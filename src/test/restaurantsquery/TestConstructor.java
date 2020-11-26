package src.test.restaurantsquery;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.data.RestaurantsQuery;
import src.model.Price;

class TestConstructor {
	private List<Price> testPrices;
	@BeforeEach
	void initialize() {
		this.testPrices = Arrays.asList(Price.$,Price.$$$);
	}
	
	@Test
	void testValidInputs() {
		RestaurantsQuery testQuery = new RestaurantsQuery("30117", 10, "chinese,mexican", 4, this.testPrices, true, true, true, true, true);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=16090&categories=chinese,mexican&price=1,3&open_now=true&attributes=wheelchair_accessible,reservation,hot_and_new,gender_neutral_restrooms",testQuery.getQueryURL().toString());
	}
	@Test
	void testNullLocation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new RestaurantsQuery(null, 10, "chinese,mexican", 4, this.testPrices, true, true, true, true, true);
		});
	}
	@Test
	void testBlankLocation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new RestaurantsQuery("", 10, "chinese,mexican", 4, this.testPrices, true, true, true, true, true);
		});
	}
	@Test
	void testNullCategories() {
		RestaurantsQuery testQuery = new RestaurantsQuery("30117", 10, null, 4, this.testPrices, false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=16090&price=1,3",testQuery.getQueryURL().toString());
	}
	@Test
	void testBlankCategories() {
		RestaurantsQuery testQuery = new RestaurantsQuery("30117", 10, "", 4, this.testPrices, false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=16090&price=1,3",testQuery.getQueryURL().toString());
	}
	
	@Test
	void testNullPrices() {
		RestaurantsQuery testQuery = new RestaurantsQuery("30117", 10, "chinese,mexican", 4, null, false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=16090&categories=chinese,mexican",testQuery.getQueryURL().toString());
	}
	@Test
	void testEmptyPrices() {
		RestaurantsQuery testQuery = new RestaurantsQuery("30117", 10, "chinese,mexican", 4, new ArrayList<Price>(), false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=16090&categories=chinese,mexican",testQuery.getQueryURL().toString());
	}
}
