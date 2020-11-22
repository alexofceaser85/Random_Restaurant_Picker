package src.test.restaurantViewModel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.stage.Stage;
import src.model.MainManager;
import src.model.Price;
import src.model.Restaurant;
import src.model.RestaurantManager;
import src.viewModel.RestaurantViewModel;



public class TestPickRestaurant {

	public class FakeRandom extends Random {
		private int expected;
		public FakeRandom(int expected) {
			this.expected = expected;
		}
		@Override
		public int nextInt(int max) {
			return expected;
		}
	}
	
	private RestaurantViewModel testViewModel;
	@BeforeEach
	void initializeTest() {
		this.testViewModel = new RestaurantViewModel();
	}
	
	@Test
	void testEmptyRestaurants() {
		MainManager testMainManager = new MainManager(new FakeRandom(1));
		this.testViewModel.setMainManager(testMainManager);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testViewModel.pickARestaurant();
		});
	}
	
	@Test
	void testOneRestaurants() {
		MainManager testMainManager = new MainManager(new FakeRandom(0));
		RestaurantManager testRestaurantManager = testMainManager.getRestaurantManager();
		this.testViewModel.setMainManager(testMainManager);
		
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");

		testRestaurantManager.addRestaurant(theFirstRestaurant);
		
		this.testViewModel.pickARestaurant();
		assertEquals("First Restaurant",testViewModel.nameProperty().get());
		assertEquals("First Image URL",testViewModel.imageProperty().get());
		assertEquals("Atlanta, GA, USA",testViewModel.locationProperty().get());
		assertEquals("$",testViewModel.priceRangeProperty().get());
		assertEquals("20",testViewModel.distanceProperty().get());
		assertEquals("1.8",testViewModel.reviewScoreProperty().get());
		assertEquals("First Menu URL",testViewModel.getMenuURL());
		assertEquals("5416",testViewModel.getRestaurantID());
		
	}
	
	@Test
	void testManyRestaurants() {
		MainManager testMainManager = new MainManager(new FakeRandom(1));
		RestaurantManager testRestaurantManager = testMainManager.getRestaurantManager();
		this.testViewModel.setMainManager(testMainManager);
		
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", Price.$$, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", Price.$$$, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", "Third Image URL", "4561");
		
		testRestaurantManager.addRestaurant(theFirstRestaurant);
		testRestaurantManager.addRestaurant(theSecondRestaurant);
		testRestaurantManager.addRestaurant(theThirdRestaurant);
		
		this.testViewModel.pickARestaurant();
		assertEquals("Second Restaurant",testViewModel.nameProperty().get());
		assertEquals("Second Image URL",testViewModel.imageProperty().get());
		assertEquals("Atlanta, GA, USA",testViewModel.locationProperty().get());
		assertEquals("$$",testViewModel.priceRangeProperty().get());
		assertEquals("15",testViewModel.distanceProperty().get());
		assertEquals("3.9",testViewModel.reviewScoreProperty().get());
		assertEquals("Second Menu URL",testViewModel.getMenuURL());
		assertEquals("41987",testViewModel.getRestaurantID());
	
	}

}
