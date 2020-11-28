package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.ReviewManager;
import src.viewmodel.ReviewsManagerViewModel;

class TestReviewManagerViewModelConstructor {

	@Test
	public void shouldAllowReviewManagerViewModelWithValidRestaurantName() {
		
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds", "111");
		assertNotNull(theReviewsManagerViewModel);
		assertNotNull(theReviewsManagerViewModel.getRestaurantName());
	}

}
