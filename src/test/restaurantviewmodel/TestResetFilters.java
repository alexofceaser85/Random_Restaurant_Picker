package src.test.restaurantviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.RestaurantViewModel;

public class TestResetFilters {

	@Test
	void testResetFiltersWithValidMainManager() {
		RestaurantViewModel testViewModel = new RestaurantViewModel();
		MainManager testMainManager = new MainManager(null);
		testViewModel.setMainManager(testMainManager);
		testViewModel.resetFilters();
		assertTrue(testMainManager.getResetFilters());
	}
	
	@Test
	void testNullSetMainManager() {
		RestaurantViewModel testViewModel = new RestaurantViewModel();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			testViewModel.resetFilters();
		});
	}

}
