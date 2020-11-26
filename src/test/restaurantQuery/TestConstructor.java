package src.test.restaurantQuery;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.data.RestaurantQuery;
import src.model.Price;

class TestConstructor {
	private List<Price> testPrices;
	@BeforeEach
	void initialize() {
		this.testPrices = Arrays.asList(Price.$,Price.$$$);
	}
	
	@Test
	void testValidInputs() {
		RestaurantQuery testQuery = new RestaurantQuery("30117", 10, "chinese,mexican", 4, this.testPrices, true, true, true, true, true);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=10&categories=chinese,mexican&price=1,3&open_now=true&attributes=wheelchair_accessible,reservation,hot_and_new,gender_neutral_restrooms",testQuery.getQueryURL().toString());
	}
	@Test
	void testNullLocation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new RestaurantQuery(null, 10, "chinese,mexican", 4, this.testPrices, true, true, true, true, true);
		});
	}
	@Test
	void testBlankLocation() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new RestaurantQuery("", 10, "chinese,mexican", 4, this.testPrices, true, true, true, true, true);
		});
	}
	@Test
	void testNullCategories() {
		RestaurantQuery testQuery = new RestaurantQuery("30117", 10, null, 4, this.testPrices, false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=10&price=1,3",testQuery.getQueryURL().toString());
	}
	@Test
	void testBlankCategories() {
		RestaurantQuery testQuery = new RestaurantQuery("30117", 10, "", 4, this.testPrices, false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=10&price=1,3",testQuery.getQueryURL().toString());
	}
	
	@Test
	void testNullPrices() {
		RestaurantQuery testQuery = new RestaurantQuery("30117", 10, "chinese,mexican", 4, null, false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=10&categories=chinese,mexican",testQuery.getQueryURL().toString());
	}
	@Test
	void testEmptyPrices() {
		RestaurantQuery testQuery = new RestaurantQuery("30117", 10, "chinese,mexican", 4, new ArrayList<Price>(), false, false, false, false, false);
		assertEquals("https://api.yelp.com/v3/businesses/search?term=restaurants&location=30117&radius=10&categories=chinese,mexican",testQuery.getQueryURL().toString());
	}
}
