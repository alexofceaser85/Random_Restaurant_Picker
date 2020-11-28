package src.test.reviewmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.Review;
import src.model.ReviewManager;

class TestReviewManager {

	@Test
	public void shouldNotAllowReviewManagerWithNullRestaurantName() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ReviewManager(null, "111");
		});
	}
	
	@Test
	public void shouldNotAllowReviewManagerWithEmptyRestaurantName() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ReviewManager("", "111");
		});
	}
	
	@Test
	public void shouldAllowReviewManagerWithValidRestaurantName() {
		
		ReviewManager theReviewManager = new ReviewManager("East Commons", "111");
		
		assertEquals("East Commons", theReviewManager.getRestaurantName());
	}
	
	@Test
	public void shouldGetEmptyReviewManager() {
		
		ArrayList<Review> testAgainstArrayList = new ArrayList<Review>();
		ReviewManager theReviewManager = new ReviewManager("Z6", "111");
		
		assertEquals(testAgainstArrayList, theReviewManager.getReviews());
	}
	
	@Test
	public void shouldGetReviewManagerWithOneReview() {
		
		ArrayList<Review> testAgainstArrayList = new ArrayList<Review>();
		ReviewManager theReviewManager = new ReviewManager("Z6", "111");
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		
		testAgainstArrayList.add(theReview);
		theReviewManager.addReview(theReview);
		
		assertEquals(testAgainstArrayList, theReviewManager.getReviews());
	}
	
	@Test
	public void shouldGetReviewManagerWithManyReviews() {
		
		ArrayList<Review> testAgainstArrayList = new ArrayList<Review>();
		ReviewManager theReviewManager = new ReviewManager("Z6", "111");
		
		Review theFirstReview = new Review("Lewis Baumstark", "There’s enough garlic in here to kill every vampire in Europe.", 4);
		Review theSecondReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		Review theThirdReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 2);
		
		testAgainstArrayList.add(theFirstReview);
		testAgainstArrayList.add(theSecondReview);
		testAgainstArrayList.add(theThirdReview);

		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		
		assertEquals(testAgainstArrayList, theReviewManager.getReviews());
	}

}
