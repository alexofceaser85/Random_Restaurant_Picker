package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.viewmodel.ReviewsManagerViewModel;

class TestGetRestaurantName {

	@Test
	public void shouldGetRestaurantName() {
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel("Mcdonalds");
		assertEquals("StringProperty [value: Mcdonalds]", theReviewsManagerViewModel.getRestaurantName().toString());
	}

}
