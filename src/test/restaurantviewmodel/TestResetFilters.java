package src.test.restaurantviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.RestaurantViewModel;

public class TestResetFilters {

	@Test
	void testResetFiltersWithValidMainManager() {
		MainManager testMainManager = new MainManager(null);
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		testViewModel.resetFilters();
		assertTrue(testMainManager.getResetFilters());
	}
	
	@Test
	void testNullMainManager() {
		RestaurantViewModel testViewModel = new RestaurantViewModel(null);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testViewModel.resetFilters();
		});
	}

}
