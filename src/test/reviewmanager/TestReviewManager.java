package src.test.reviewmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import src.model.Review;
import src.model.ReviewManager;

class TestReviewManager {

	@Test
	public void shouldGetEmptyReviewManager() {
		
		ArrayList<Review> testAgainstArrayList = new ArrayList<Review>();
		ReviewManager theReviewManager = new ReviewManager();
		
		assertEquals(testAgainstArrayList, theReviewManager.getReviews());
	}
	
	@Test
	public void shouldGetReviewManagerWithOneReview() {
		
		ArrayList<Review> testAgainstArrayList = new ArrayList<Review>();
		ReviewManager theReviewManager = new ReviewManager();
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		
		testAgainstArrayList.add(theReview);
		theReviewManager.add(theReview);
		
		assertEquals(testAgainstArrayList, theReviewManager.getReviews());
	}
	
	@Test
	public void shouldGetReviewManagerWithManyReviews() {
		
		ArrayList<Review> testAgainstArrayList = new ArrayList<Review>();
		ReviewManager theReviewManager = new ReviewManager();
		
		Review theFirstReview = new Review("Lewis Baumstark", "There’s enough garlic in here to kill every vampire in Europe.", 4);
		Review theSecondReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		Review theThirdReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 2);
		
		testAgainstArrayList.add(theFirstReview);
		testAgainstArrayList.add(theSecondReview);
		testAgainstArrayList.add(theThirdReview);

		theReviewManager.add(theFirstReview);
		theReviewManager.add(theSecondReview);
		theReviewManager.add(theThirdReview);
		
		assertEquals(testAgainstArrayList, theReviewManager.getReviews());
	}

}
