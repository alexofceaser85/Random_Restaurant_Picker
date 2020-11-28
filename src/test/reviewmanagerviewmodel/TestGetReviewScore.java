package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.viewmodel.ReviewsManagerViewModel;

class TestGetReviewScore {

	@Test
	public void shouldNotGetReviewerFromEmptyReviewManager() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			theReviewsManagerViewModel.getReviewContent(1);
		});
		
	}
	
	@Test
	public void shouldGetFirstReviewer() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("DoubleProperty [value: 1.1]", theReviewsManagerViewModel.getReviewScore(0).toString());
	}
	
	@Test
	public void shouldGetSecondReviewer() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("DoubleProperty [value: 4.5]", theReviewsManagerViewModel.getReviewScore(1).toString());
	}
	
	@Test
	public void shouldGetThirdReviewer() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("DoubleProperty [value: 3.1]", theReviewsManagerViewModel.getReviewScore(2).toString());
	}


}
