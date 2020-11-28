package src.test.reviewmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.Review;
import src.model.ReviewManager;

class TestGetReview {

	@Test
	public void ShouldNotGetReviewWithIndexOneLessThanZero() {
		
		ReviewManager theReviewManager = new ReviewManager("American Pie", "111");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			theReviewManager.getReview(-1);
		});
		
	}
	
	@Test
	public void ShouldNotGetReviewWithIndexWellLessThanZero() {
		
		ReviewManager theReviewManager = new ReviewManager("American Pie", "111");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			theReviewManager.getReview(-5);
		});
		
	}

	@Test
	public void ShouldGetOneReview() {
		
		ReviewManager theReviewManager = new ReviewManager("American Pie", "111");
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		
		theReviewManager.addReview(theReview);
		
		assertEquals(theReview, theReviewManager.getReview(0));
		
	}
	
	@Test
	public void ShouldGetFirstReview() {
		
		ReviewManager theReviewManager = new ReviewManager("American Pie", "111");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		
		assertEquals(theFirstReview, theReviewManager.getReview(0));	
	}
	
	@Test
	public void ShouldGetMiddleReview() {
		
		ReviewManager theReviewManager = new ReviewManager("American Pie", "111");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		
		assertEquals(theSecondReview, theReviewManager.getReview(1));	
	}
	
	@Test
	public void ShouldGetLastReview() {
		
		ReviewManager theReviewManager = new ReviewManager("American Pie", "111");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		
		assertEquals(theThirdReview, theReviewManager.getReview(2));	
	}

}
