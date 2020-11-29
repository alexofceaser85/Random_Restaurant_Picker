package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.ReviewsManagerViewModel;

class TestReviewManagerViewModelConstructor {

	@Test
	public void shouldAllowReviewManagerViewModelWithValidRestaurantName() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		assertNotNull(theReviewsManagerViewModel);
		assertNotNull(theReviewsManagerViewModel.getRestaurantName());
	}

}
