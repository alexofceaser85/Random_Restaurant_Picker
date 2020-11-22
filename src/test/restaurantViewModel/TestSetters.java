package src.test.restaurantViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewModel.RestaurantViewModel;

public class TestSetters {
	private RestaurantViewModel testViewModel;
	@BeforeEach
	void initializeTest() {
		this.testViewModel = new RestaurantViewModel();
	}
	
	@Test
	void testNullSetMainManager() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testViewModel.setMainManager(null);
		});
	}
	
	@Test
	void testValidSetMainManager() {
		MainManager testMainManager = new MainManager(null);
		this.testViewModel.setMainManager(testMainManager);
		assertEquals(testMainManager,this.testViewModel.getMainManager());
	}

}
