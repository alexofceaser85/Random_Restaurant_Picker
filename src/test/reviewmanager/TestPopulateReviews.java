package src.test.reviewmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.Review;
import src.model.ReviewManager;

class TestPopulateReviews {

	@Test
	public void shouldPopulateSampleSetOfReviews() {
		
		ReviewManager theReviewManager = new ReviewManager("Garaje", "tnhfDv5Il8EaGSXZGiuQGg");
		theReviewManager.populateReviews();
		
		assertEquals("Rich M.", theReviewManager.getReview(0).getReviewerName());
		assertEquals("Evan H.", theReviewManager.getReview(1).getReviewerName());
		assertEquals("Darren A.", theReviewManager.getReview(2).getReviewerName());
		
		assertEquals(5.0, theReviewManager.getReview(0).getReviewScore());
		assertEquals(5.0, theReviewManager.getReview(1).getReviewScore());
		assertEquals(5.0, theReviewManager.getReview(2).getReviewScore());
		
		assertEquals(3, theReviewManager.size());
	}

}
