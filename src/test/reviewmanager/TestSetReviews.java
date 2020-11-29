package src.test.reviewmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.Review;
import src.model.ReviewManager;

class TestSetReviews {

	@Test
	public void shouldNotSetNullReviews() {
		ReviewManager theReviewManager = new ReviewManager();
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			theReviewManager.setReviews(null);
		});
	}
	
	@Test
	public void shouldSetOneReview() {
		ReviewManager theReviewManager = new ReviewManager();
		
		Review theReview = new Review("Alan Alexander", "I had it with this place", 1);
		ArrayList<Review> reviewsList = new ArrayList<Review>();
		
		reviewsList.add(theReview);
		
		theReviewManager.setReviews(reviewsList);
		
		assertEquals("Reviewer: Alan Alexander Content: I had it with this place Score: 1.0"
				+ System.lineSeparator(), theReviewManager.toString());
	}
	
	@Test
	public void shouldSetManyReviews() {
		ReviewManager theReviewManager = new ReviewManager();
		
		Review theFirstReview = new Review("Alan Alexander", "I had it with this place", 1);
		Review theSecondReview = new Review("Jessie Mejia", "I like that one", 5);
		Review theThirdReview = new Review("John McBoomer", "All mechanics are scam artists!", 1);
		ArrayList<Review> reviewsList = new ArrayList<Review>();
		
		reviewsList.add(theFirstReview);
		reviewsList.add(theSecondReview);
		reviewsList.add(theThirdReview);
		
		theReviewManager.setReviews(reviewsList);
		
		assertEquals("Reviewer: Alan Alexander Content: I had it with this place Score: 1.0"
				+ System.lineSeparator() + "Reviewer: Jessie Mejia Content: I like that one Score: 5.0"
				+ System.lineSeparator() + "Reviewer: John McBoomer Content: All mechanics are scam artists! Score: 1.0"
				+ System.lineSeparator(), theReviewManager.toString());
	}

}
