/**
 * 
 */
package src.test.restaurantviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.model.Price;
import src.model.Restaurant;
import src.viewmodel.RestaurantViewModel;

/**
 *
 * @author Alex DeCaesar
 * @version Fall 2020
 */
class TestRemovePickedRestaurant {

	public class FakeRandom extends Random {
		private static final long serialVersionUID = 1L;
		private int expected;

		public FakeRandom(int expected) {
			this.expected = expected;
		}

		@Override
		public int nextInt(int max) {
			return expected;
		}
	}
	
	@Test
	public void TestNullPickedRestaurant() {
		MainManager theMainManager = new MainManager(new FakeRandom(0));
		RestaurantViewModel testViewModel = new RestaurantViewModel(theMainManager);
		
		testViewModel.pickARestaurant();
		testViewModel.removePickedRestaurant();

		assertEquals("", theMainManager.getRestaurantManager().toString());
	}
	
	@Test
	public void shouldRemoveRestaurantFromManagerWithOneItem() {
		MainManager theMainManager = new MainManager(new FakeRandom(0));
		RestaurantViewModel testViewModel = new RestaurantViewModel(theMainManager);
		Restaurant theRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");

		theMainManager.getRestaurantManager().addRestaurant(theRestaurant);
		
		testViewModel.pickARestaurant();
		testViewModel.removePickedRestaurant();

		assertEquals("", theMainManager.getRestaurantManager().toString());
	}

	@Test
	public void shouldRemoveFirstRestaurantFromManagerWithOneItem() {
		MainManager theMainManager = new MainManager(new FakeRandom(0));
		RestaurantViewModel testViewModel = new RestaurantViewModel(theMainManager);
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");

		theMainManager.getRestaurantManager().addRestaurant(theFirstRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theSecondRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theThirdRestaurant);
		
		testViewModel.pickARestaurant();
		testViewModel.removePickedRestaurant();

		assertEquals(
				"Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
						+ System.lineSeparator()
						+ "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
						+ System.lineSeparator(),
				theMainManager.getRestaurantManager().toString());
	}

	@Test
	public void shouldRemoveMiddleRestaurantFromManagerWithOneItem() {
		MainManager theMainManager = new MainManager(new FakeRandom(1));
		RestaurantViewModel testViewModel = new RestaurantViewModel(theMainManager);
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");

		theMainManager.getRestaurantManager().addRestaurant(theFirstRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theSecondRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theThirdRestaurant);
		
		testViewModel.pickARestaurant();
		testViewModel.removePickedRestaurant();

		assertEquals(
				"Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
						+ System.lineSeparator()
						+ "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
						+ System.lineSeparator(),
				theMainManager.getRestaurantManager().toString());
	}

	@Test
	public void shouldRemoveLastRestaurantFromManagerWithOneItem() {
		MainManager theMainManager = new MainManager(new FakeRandom(2));
		RestaurantViewModel testViewModel = new RestaurantViewModel(theMainManager);
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", Price.$, "Atlanta, GA, USA", 20, 1.8,
				"First Menu URL", "First Image URL", "5416");

		theMainManager.getRestaurantManager().addRestaurant(theFirstRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theSecondRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theThirdRestaurant);
		
		testViewModel.pickARestaurant();
		testViewModel.removePickedRestaurant();

		assertEquals(
				"Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
						+ System.lineSeparator()
						+ "Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
						+ System.lineSeparator(),
						theMainManager.getRestaurantManager().toString());
	}
}
