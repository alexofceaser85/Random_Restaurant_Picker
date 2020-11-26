package src.test.reviewmanager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.Review;
import src.model.ReviewManager;

class TestRemoveReview {

	@Test
	public void ShouldNotRemoveNullReview() {
		
		ReviewManager theReviewManager = new ReviewManager("American Pie");
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			theReviewManager.removeReview(null);
		});
		
	}
	
	@Test
	public void ShouldNotRemoveReviewFromEmptyReviewManager() {
		
		ReviewManager theReviewManager = new ReviewManager("La Hacienda San Antonio");
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		
		theReviewManager.removeReview(theReview);
		
	}
	
	@Test
	public void ShouldNotRemoveReviewThatIsNotInReviewManagerWithOneReview() {
		
		ReviewManager theReviewManager = new ReviewManager("La Salsa Carrolton");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.removeReview(theSecondReview);
		
		assertEquals("Reviewer: Lewis Baumstark Content: This lamb is so undercooked, it’s following Mary to school! Score: 1.1" 
				+ System.lineSeparator(), theReviewManager.toString());
	}
	
	@Test
	public void ShouldNotRemoveReviewThatIsNotInReviewManagerWithManyReviews() {
		
		ReviewManager theReviewManager = new ReviewManager("La Salsa Carrolton");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		Review theFourthReview = new Review("Ana Stanescu", "The food here is as terrible as VIM", 1.0);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		theReviewManager.removeReview(theFourthReview);
		
		assertEquals("Reviewer: Lewis Baumstark Content: This lamb is so undercooked, it’s following Mary to school! Score: 1.1" 
				+ System.lineSeparator() + "Reviewer: Duane Yoder Content: This pizza is so disgusting, if you take it to Italy you’ll get arrested. Score: 4.5"
				+ System.lineSeparator() + "Reviewer: Alexander Ayers Content: Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2 Score: 3.1"
				+ System.lineSeparator(), theReviewManager.toString());
	}
	
	@Test
	public void ShouldRemoveReviewThatIsInReviewManagerWithOneReview() {
		
		ReviewManager theReviewManager = new ReviewManager("La Salsa Carrolton");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.removeReview(theFirstReview);
		
		assertEquals("", theReviewManager.toString());
	}
	
	@Test
	public void ShouldRemoveLastReviewThatIsInReviewManagerWithManyReviews() {
		
		ReviewManager theReviewManager = new ReviewManager("La Salsa Carrolton");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		theReviewManager.removeReview(theThirdReview);
		
		assertEquals("Reviewer: Lewis Baumstark Content: This lamb is so undercooked, it’s following Mary to school! Score: 1.1" 
				+ System.lineSeparator() + "Reviewer: Duane Yoder Content: This pizza is so disgusting, if you take it to Italy you’ll get arrested. Score: 4.5"
				+ System.lineSeparator(), theReviewManager.toString());
	}

	@Test
	public void ShouldRemoveMiddleReviewThatIsInReviewManagerWithManyReviews() {
		
		ReviewManager theReviewManager = new ReviewManager("La Salsa Carrolton");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		theReviewManager.removeReview(theSecondReview);
		
		assertEquals("Reviewer: Lewis Baumstark Content: This lamb is so undercooked, it’s following Mary to school! Score: 1.1" 
				+ System.lineSeparator() + "Reviewer: Alexander Ayers Content: Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2 Score: 3.1"
				+ System.lineSeparator(), theReviewManager.toString());
	}
	
	@Test
	public void ShouldRemoveFirstReviewThatIsInReviewManagerWithManyReviews() {
		
		ReviewManager theReviewManager = new ReviewManager("La Salsa Carrolton");
		Review theFirstReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		Review theSecondReview = new Review("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		Review theThirdReview = new Review("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		theReviewManager.addReview(theFirstReview);
		theReviewManager.addReview(theSecondReview);
		theReviewManager.addReview(theThirdReview);
		theReviewManager.removeReview(theFirstReview);
		
		assertEquals("Reviewer: Duane Yoder Content: This pizza is so disgusting, if you take it to Italy you’ll get arrested. Score: 4.5"
				+ System.lineSeparator() + "Reviewer: Alexander Ayers Content: Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2 Score: 3.1"
				+ System.lineSeparator(), theReviewManager.toString());
	}
}
