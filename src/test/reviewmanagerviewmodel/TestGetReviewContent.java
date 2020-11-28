package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.viewmodel.ReviewsManagerViewModel;

class TestGetReviewContent {

	@Test
	public void shouldNotGetReviewerFromEmptyReviewManager() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds", "111");
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			theReviewsManagerViewModel.getReviewContent(1);
		});
		
	}
	
	@Test
	public void shouldGetFirstReview() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds", "111");
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("This lamb is so undercooked, it’s following Mary to school!", theReviewsManagerViewModel.getReviewContent(0));
	}
	
	@Test
	public void shouldGetSecondReview() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds", "111");
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("This pizza is so disgusting, if you take it to Italy you’ll get arrested.", theReviewsManagerViewModel.getReviewContent(1));
	}
	
	@Test
	public void shouldGetThirdReviewer() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds", "111");
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", theReviewsManagerViewModel.getReviewContent(2));
	}

}
