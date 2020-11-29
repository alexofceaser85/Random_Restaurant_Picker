package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.ReviewsManagerViewModel;

class TestAddReview {

	@Test
	public void shouldAddOneReview() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		
		assertEquals("Reviewer: Alex DeCesare Content: It was tremendous Score: 5.0"
				+ System.lineSeparator(), theReviewsManagerViewModel.toString());
	}
	
	@Test
	public void shouldAddManyReviews() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		theReviewsManagerViewModel.addReview("Alex DeCesare", "It was tremendous", 5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "It was not tremendous", 3);
		theReviewsManagerViewModel.addReview("Furichous Jones", "It was terrible", 1);
		
		assertEquals("Reviewer: Alex DeCesare Content: It was tremendous Score: 5.0"
				+ System.lineSeparator() + "Reviewer: Alexander Ayers Content: It was not tremendous Score: 3.0"
				+ System.lineSeparator() + "Reviewer: Furichous Jones Content: It was terrible Score: 1.0"
				+ System.lineSeparator(), theReviewsManagerViewModel.toString());	
	}

}
