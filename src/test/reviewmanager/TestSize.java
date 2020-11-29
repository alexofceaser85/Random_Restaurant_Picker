package src.test.reviewmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.Review;
import src.model.ReviewManager;

class TestSize {

	@Test
	public void ShouldGetSizeOfEmptyReviewManager() {
		
		ReviewManager theReviewManager = new ReviewManager();
		
		assertEquals(0, theReviewManager.size());
	}
	
	@Test
	public void ShouldGetSizeOfReviewManagerWithOneReview() {
		
		ReviewManager theReviewManager = new ReviewManager();
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		theReviewManager.addReview(theReview);
		
		assertEquals(1, theReviewManager.size());
		
	}

	@Test
	public void ShouldGetSizeOfReviewManagerWithManyReviews() {
		
		ReviewManager theReviewManager = new ReviewManager();
		
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		Review theFourthReview = new Review("Ana Stanescu", "The food here is as terrible as VIM", 1.0);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		theReviewManager.addReview(theFourthReview);
		
		assertEquals(4, theReviewManager.size());
		
	}
}
