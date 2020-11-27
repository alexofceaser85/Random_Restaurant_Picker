package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import src.viewmodel.ReviewsManagerViewModel;

class TestGetReviews {

	@Test
	public void shouldGetReviewsFromAnEmptyReviewsManager() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		
		assertEquals("[]", theReviewsManagerViewModel.getReviews().toString());
	}
	
	@Test
	public void shouldGetSizeOfReviewManagerViewModelWithOneReview() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		
		assertEquals("[Reviewer: Alex DeCesare Content: It was tremendous Score: 5.0]", theReviewsManagerViewModel.getReviews().toString());
	}
	
	@Test
	public void shouldGetSizeOfReviewManagerViewModelWithManyReviews() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "It was not tremendous", 3);
		theReviewsManagerViewModel.addReview("Furichous Jones", "It was terrible", 1);
		
		assertEquals("[Reviewer: Alex DeCesare Content: It was tremendous Score: 5.0, Reviewer: Alexander Ayers Content: It was not tremendous Score: 3.0, Reviewer: Furichous Jones Content: It was terrible Score: 1.0]", theReviewsManagerViewModel.getReviews().toString());
	}

}
