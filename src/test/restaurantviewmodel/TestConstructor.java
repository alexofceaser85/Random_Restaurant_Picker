package src.test.restaurantviewmodel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.RestaurantViewModel;

public class TestConstructor {

	@Test
	void testValidConstructor() {
		RestaurantViewModel testViewModel = new RestaurantViewModel(new MainManager(null));
		assertNotNull(testViewModel.nameProperty());
		assertNotNull(testViewModel.imageURLProperty());
		assertNotNull(testViewModel.locationProperty());
		assertNotNull(testViewModel.priceRangeProperty());
		assertNotNull(testViewModel.distanceProperty());
		assertNotNull(testViewModel.reviewScoreProperty());
		assertNotNull(testViewModel.menuURLProperty());
		assertEquals("", testViewModel.getRestaurantID());
	}
	@Test
	void testNullMainManager() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new RestaurantViewModel(null);
		});
	}

}
