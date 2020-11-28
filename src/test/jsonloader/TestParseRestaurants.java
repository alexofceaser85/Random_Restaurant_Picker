package src.test.jsonloader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import src.data.JSONLoader;
import src.model.Price;
import src.model.Restaurant;

class TestParseRestaurants {

	@Test
	void testZeroRestaurants() {
		String testJSON = "{\"total\": 0,\"businesses\": []}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		assertEquals(0, testRestaurants.size());
	}
	@Test
	void testOneRestaurants() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		Restaurant restaurant0 = testRestaurants.get(0);
		
		assertEquals(1, testRestaurants.size());
		assertEquals("1", restaurant0.getId());
		assertEquals("imageURL1", restaurant0.getImageURL());
		assertEquals("address1, address2, 00001", restaurant0.getLocation());
		assertEquals("menuURL1", restaurant0.getMenuURL());
		assertEquals(4.0, restaurant0.getReviewScore(),0.01);
		assertEquals("Restaurant 1", restaurant0.getName());
		assertEquals(Price.$, restaurant0.getPrice());
		assertEquals(1, restaurant0.getDistance());
	}
	@Test
	void testMultipleRestaurants() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				
				"{\"rating\": 2.5,\"price\": \"$$\",\"id\": \"2\",\"name\": \"Restaurant 2\","+
				"\"url\": \"menuURL2\","+
				"\"image_url\": \"imageURL2\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 3200},"+
								
				"{\"rating\": 4.9,\"price\": \"$$$\",\"id\": \"3\",\"name\": \"Restaurant 3\","+
				"\"url\": \"menuURL3\","+
				"\"image_url\": \"imageURL3\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 4800},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		Restaurant restaurant0 = testRestaurants.get(0);
		Restaurant restaurant1 = testRestaurants.get(1);
		Restaurant restaurant2 = testRestaurants.get(2);
		
		assertEquals(3, testRestaurants.size());
		
		assertEquals("1", restaurant0.getId());
		assertEquals("imageURL1", restaurant0.getImageURL());
		assertEquals("address1, address2, 00001", restaurant0.getLocation());
		assertEquals("menuURL1", restaurant0.getMenuURL());
		assertEquals(4.0, restaurant0.getReviewScore(),0.01);
		assertEquals("Restaurant 1", restaurant0.getName());
		assertEquals(Price.$, restaurant0.getPrice());
		assertEquals(1, restaurant0.getDistance());
		
		assertEquals("2", restaurant1.getId());
		assertEquals("imageURL2", restaurant1.getImageURL());
		assertEquals("address1, address2, 00001", restaurant1.getLocation());
		assertEquals("menuURL2", restaurant1.getMenuURL());
		assertEquals(2.5, restaurant1.getReviewScore(),0.01);
		assertEquals("Restaurant 2", restaurant1.getName());
		assertEquals(Price.$$, restaurant1.getPrice());
		assertEquals(2, restaurant1.getDistance());
		
		assertEquals("3", restaurant2.getId());
		assertEquals("imageURL3", restaurant2.getImageURL());
		assertEquals("address1, address2, 00001", restaurant2.getLocation());
		assertEquals("menuURL3", restaurant2.getMenuURL());
		assertEquals(4.9, restaurant2.getReviewScore(),0.01);
		assertEquals("Restaurant 3", restaurant2.getName());
		assertEquals(Price.$$$, restaurant2.getPrice());
		assertEquals(3, restaurant2.getDistance());
	}
	
	@Test
	void testNullJSON() {
		assertThrows(IllegalArgumentException.class, () -> {
			JSONLoader.parseRestaurants(null);
		});
	}
	@Test
	void testBlankJSON() {
		assertThrows(IllegalArgumentException.class, () -> {
			JSONLoader.parseRestaurants("");
		});
	}
	@Test
	void testMissingID() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		assertEquals(0, testRestaurants.size());
	}
	
	@Test
	void testMissingName() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"id\": \"1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		assertEquals(0, testRestaurants.size());
	}
	
	@Test
	void testMissingLocation() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		assertEquals(0, testRestaurants.size());
	}
	
	@Test
	void testMissingURL() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		assertEquals(0, testRestaurants.size());
	}
	
	@Test
	void testMissingPrice() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		Restaurant restaurant0 = testRestaurants.get(0);
		
		assertEquals(1, testRestaurants.size());
		assertEquals("1", restaurant0.getId());
		assertEquals("imageURL1", restaurant0.getImageURL());
		assertEquals("address1, address2, 00001", restaurant0.getLocation());
		assertEquals("menuURL1", restaurant0.getMenuURL());
		assertEquals(4.0, restaurant0.getReviewScore(),0.01);
		assertEquals("Restaurant 1", restaurant0.getName());
		assertEquals(Price.Any, restaurant0.getPrice());
		assertEquals(1, restaurant0.getDistance());
	}
	@Test
	void testMissingRating() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"price\": \"$\",\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		Restaurant restaurant0 = testRestaurants.get(0);
		
		assertEquals(1, testRestaurants.size());
		assertEquals("1", restaurant0.getId());
		assertEquals("imageURL1", restaurant0.getImageURL());
		assertEquals("address1, address2, 00001", restaurant0.getLocation());
		assertEquals("menuURL1", restaurant0.getMenuURL());
		assertEquals(5.0, restaurant0.getReviewScore(),0.01);
		assertEquals("Restaurant 1", restaurant0.getName());
		assertEquals(Price.$, restaurant0.getPrice());
		assertEquals(1, restaurant0.getDistance());
	}
	@Test
	void testMissingDistance() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"image_url\": \"imageURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]}},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		Restaurant restaurant0 = testRestaurants.get(0);
		
		assertEquals(1, testRestaurants.size());
		assertEquals("1", restaurant0.getId());
		assertEquals("imageURL1", restaurant0.getImageURL());
		assertEquals("address1, address2, 00001", restaurant0.getLocation());
		assertEquals("menuURL1", restaurant0.getMenuURL());
		assertEquals(4.0, restaurant0.getReviewScore(),0.01);
		assertEquals("Restaurant 1", restaurant0.getName());
		assertEquals(Price.$, restaurant0.getPrice());
		assertEquals(Integer.MAX_VALUE, restaurant0.getDistance());
	}
	@Test
	void testMissingImageURL() {
		String testJSON = "{\"total\": 1,\"businesses\": ["+
				"{\"rating\": 4,\"price\": \"$\",\"id\": \"1\",\"name\": \"Restaurant 1\","+
				"\"url\": \"menuURL1\","+
				"\"location\": {\"display_address\": [\"address1\",\"address2, 00001\"]},\"distance\": 1609},"+
				"]}";
		List<Restaurant> testRestaurants = JSONLoader.parseRestaurants(testJSON);
		Restaurant restaurant0 = testRestaurants.get(0);
		
		assertEquals(1, testRestaurants.size());
		assertEquals("1", restaurant0.getId());
		assertEquals(JSONLoader.DEFAULT_IMAGE, restaurant0.getImageURL());
		assertEquals("address1, address2, 00001", restaurant0.getLocation());
		assertEquals("menuURL1", restaurant0.getMenuURL());
		assertEquals(4.0, restaurant0.getReviewScore(),0.01);
		assertEquals("Restaurant 1", restaurant0.getName());
		assertEquals(Price.$, restaurant0.getPrice());
		assertEquals(1, restaurant0.getDistance());
	}
}
