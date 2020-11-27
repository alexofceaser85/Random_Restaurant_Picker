package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.viewmodel.ReviewsManagerViewModel;

class TestSize {

	@Test
	public void shouldGetSizeOfEmptyReviewManagerViewModel() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		
		assertEquals(0, theReviewsManagerViewModel.size());
	}
	
	@Test
	public void shouldGetSizeOfReviewManagerViewModelWithOneReview() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		
		assertEquals(1, theReviewsManagerViewModel.size());
	}
	
	@Test
	public void shouldGetSizeOfReviewManagerViewModelWithManyReviews() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "It was not tremendous", 3);
		theReviewsManagerViewModel.addReview("Furichous Jones", "It was terrible", 1);
		
		assertEquals(3, theReviewsManagerViewModel.size());
	}

}
