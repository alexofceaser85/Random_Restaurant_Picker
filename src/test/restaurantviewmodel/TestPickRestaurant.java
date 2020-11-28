package src.test.restaurantviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.application.Application;
import javafx.stage.Stage;
import src.data.JSONLoader;
import src.model.MainManager;
import src.model.Price;
import src.model.Restaurant;
import src.model.RestaurantManager;
import src.viewmodel.RestaurantViewModel;



public class TestPickRestaurant {

	private final String testImageURL = "https://s3-media2.fl.yelpcdn.com/bphoto/MmgtASP3l_t4tPCL1iAsCg/o.jpg";
	
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
	public static class MockApplication extends Application {
	    @Override
	    public void start(Stage primaryStage) throws Exception {
	        // do nothing due to mock
	    }
	}
	
	@BeforeAll
	public static void setupClass() throws InterruptedException {
		Thread t = new Thread("JavaFX Init Thread") {
		    public void run() {
		        Application.launch(MockApplication.class, new String[0]);
		    }
		};
		t.setDaemon(true);
		t.start();
		Thread.sleep(500);
	}
	
	@Test
	void testEmptyRestaurants() {
		MainManager testMainManager = new MainManager(new FakeRandom(1));
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		assertFalse(testViewModel.pickARestaurant());
	}
	
	@Test
	void testOneRestaurants() {
		MainManager testMainManager = new MainManager(new FakeRandom(0));
		RestaurantManager testRestaurantManager = testMainManager.getRestaurantManager();
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", this.testImageURL, "5416");

		testRestaurantManager.addRestaurant(theFirstRestaurant);
		
		assertTrue(testViewModel.pickARestaurant());
		assertEquals("First Restaurant",testViewModel.nameProperty().get());
		assertEquals(this.testImageURL,testViewModel.imageProperty().get().getUrl().toString());
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
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", this.testImageURL, "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", Price.$$, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", this.testImageURL, "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", Price.$$$, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", this.testImageURL, "4561");
		
		testRestaurantManager.addRestaurant(theFirstRestaurant);
		testRestaurantManager.addRestaurant(theSecondRestaurant);
		testRestaurantManager.addRestaurant(theThirdRestaurant);
		
		assertTrue(testViewModel.pickARestaurant());
		assertEquals("Second Restaurant",testViewModel.nameProperty().get());
		assertEquals(this.testImageURL,testViewModel.imageProperty().get().getUrl().toString());
		assertEquals("Atlanta, GA, USA",testViewModel.locationProperty().get());
		assertEquals("$$",testViewModel.priceRangeProperty().get());
		assertEquals("15",testViewModel.distanceProperty().get());
		assertEquals("3.9",testViewModel.reviewScoreProperty().get());
		assertEquals("Second Menu URL",testViewModel.getMenuURL());
		assertEquals("41987",testViewModel.getRestaurantID());
	}

	@Test
	void testMissingImage() {
		MainManager testMainManager = new MainManager(new FakeRandom(0));
		RestaurantManager testRestaurantManager = testMainManager.getRestaurantManager();
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "unknown", "5416");

		testRestaurantManager.addRestaurant(theFirstRestaurant);
		
		assertTrue(testViewModel.pickARestaurant());
		assertEquals("First Restaurant",testViewModel.nameProperty().get());
		assertEquals(JSONLoader.DEFAULT_IMAGE,testViewModel.imageProperty().get().getUrl().toString());
		assertEquals("Atlanta, GA, USA",testViewModel.locationProperty().get());
		assertEquals("$",testViewModel.priceRangeProperty().get());
		assertEquals("20",testViewModel.distanceProperty().get());
		assertEquals("1.8",testViewModel.reviewScoreProperty().get());
		assertEquals("First Menu URL",testViewModel.getMenuURL());
		assertEquals("5416",testViewModel.getRestaurantID());
		
	}
	
}
