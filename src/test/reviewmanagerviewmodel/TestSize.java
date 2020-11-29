package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.ReviewsManagerViewModel;

class TestSize {

	@Test
	public void shouldGetSizeOfEmptyReviewManagerViewModel() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		
		assertEquals(0, theReviewsManagerViewModel.size());
	}
	
	@Test
	public void shouldGetSizeOfReviewManagerViewModelWithOneReview() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		
		assertEquals(1, theReviewsManagerViewModel.size());
	}
	
	@Test
	public void shouldGetSizeOfReviewManagerViewModelWithManyReviews() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "It was not tremendous", 3);
		theReviewsManagerViewModel.addReview("Furichous Jones", "It was terrible", 1);
		
		assertEquals(3, theReviewsManagerViewModel.size());
	}

}
