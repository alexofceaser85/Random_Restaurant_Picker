package src.test.reviewsquery;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.data.ReviewsQuery;

class TestConstructor {

	@Test
	void testValidInputs() {
		ReviewsQuery testQuery = new ReviewsQuery("test");
		assertEquals("https://api.yelp.com/v3/businesses/test/reviews",testQuery.getQueryURL().toString());
	}
	@Test
	void testNullRestaurantID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ReviewsQuery(null);
		});
	}
	@Test
	void testBlankRestaurantID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ReviewsQuery("");
		});
	}

}
