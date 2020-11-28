package src.test.restaurantviewmodel;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.RestaurantViewModel;

public class TestConstructor {

	@Test
	void testConstructor() {
		RestaurantViewModel testViewModel = new RestaurantViewModel(new MainManager(null));
		assertNotNull(testViewModel.nameProperty());
		assertNotNull(testViewModel.imageProperty());
		assertNotNull(testViewModel.locationProperty());
		assertNotNull(testViewModel.priceRangeProperty());
		assertNotNull(testViewModel.distanceProperty());
		assertNotNull(testViewModel.reviewScoreProperty());
		assertEquals("",testViewModel.getRestaurantID());
		assertEquals("",testViewModel.getMenuURL());
	}

}
