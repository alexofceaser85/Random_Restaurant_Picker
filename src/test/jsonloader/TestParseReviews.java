package src.test.jsonloader;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import src.data.JSONLoader;
import src.model.Review;

class TestParseReviews {

	@Test
	void testZeroReviews() {
		String testJSON = "{\"total\": 0,\"reviews\": []}";
		List<Review> testReviews = JSONLoader.parseReviews(testJSON);
		
		assertEquals(0, testReviews.size());
	}
	@Test
	void testOneReviews() {
		String testJSON = "{\"total\": 1,\"reviews\": ["+
				"{\"text\": \"text1\","+
				"\"rating\": 4,"+
				"\"user\": {\"name\": \"name1\"}}"+
				"]}";
		List<Review> testReviews = JSONLoader.parseReviews(testJSON);
		Review review0 = testReviews.get(0);
		
		assertEquals(1, testReviews.size());
		
		assertEquals("name1", review0.getReviewerName());
		assertEquals("text1", review0.getReviewContent());
		assertEquals(4, review0.getReviewScore(), 0.01);
	}
	@Test
	void testMultipleReviews() {
		String testJSON = "{\"total\": 1,\"reviews\": ["+
				"{\"text\": \"text1\","+
				"\"rating\": 4,"+
				"\"user\": {\"name\": \"name1\"}},"+
				
				"{\"text\": \"text2\","+
				"\"rating\": 2.5,"+
				"\"user\": {\"name\": \"name2\"}},"+
				
				"{\"text\": \"text3\","+
				"\"rating\": 5.0,"+
				"\"user\": {\"name\": \"name3\"}}"+
				"]}";
		List<Review> testReviews = JSONLoader.parseReviews(testJSON);
		Review review0 = testReviews.get(0);
		Review review1 = testReviews.get(1);
		Review review2 = testReviews.get(2);
		
		assertEquals(3, testReviews.size());
		
		assertEquals("name1", review0.getReviewerName());
		assertEquals("text1", review0.getReviewContent());
		assertEquals(4, review0.getReviewScore(), 0.01);
		
		assertEquals("name2", review1.getReviewerName());
		assertEquals("text2", review1.getReviewContent());
		assertEquals(2.5, review1.getReviewScore(), 0.01);
		
		assertEquals("name3", review2.getReviewerName());
		assertEquals("text3", review2.getReviewContent());
		assertEquals(5.0, review2.getReviewScore(), 0.01);
	}
	
	@Test
	void testNullJSON() {
		assertThrows(IllegalArgumentException.class, () -> {
			JSONLoader.parseReviews(null);
		});
	}
	@Test
	void testBlankJSON() {
		assertThrows(IllegalArgumentException.class, () -> {
			JSONLoader.parseReviews("");
		});
	}
	@Test
	void testMissingText() {
		String testJSON = "{\"total\": 1,\"reviews\": ["+
				"{\"rating\": 4,"+
				"\"user\": {\"name\": \"name1\"}}"+
				"]}";
		List<Review> testReviews = JSONLoader.parseReviews(testJSON);
		assertEquals(0, testReviews.size());
	}
	@Test
	void testMissingRating() {
		String testJSON = "{\"total\": 1,\"reviews\": ["+
				"{\"text\": \"text1\","+
				"\"user\": {\"name\": \"name1\"}}"+
				"]}";
		List<Review> testReviews = JSONLoader.parseReviews(testJSON);
		assertEquals(0, testReviews.size());
	}
	@Test
	void testMissingUser() {
		String testJSON = "{\"total\": 1,\"reviews\": ["+
				"{\"text\": \"text1\","+
				"\"rating\": 4}"+
				"]}";
		List<Review> testReviews = JSONLoader.parseReviews(testJSON);
		assertEquals(0, testReviews.size());
	}
	@Test
	void testMissingName() {
		String testJSON = "{\"total\": 1,\"reviews\": ["+
				"{\"text\": \"text1\","+
				"\"rating\": 4,"+
				"\"user\": {}}"+
				"]}";
		List<Review> testReviews = JSONLoader.parseReviews(testJSON);
		assertEquals(0, testReviews.size());
	}

}
