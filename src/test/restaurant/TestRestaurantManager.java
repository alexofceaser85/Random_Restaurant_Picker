package src.test.restaurant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.Price;
import src.model.Restaurant;
import src.model.RestaurantManager;

class TestRestaurantManager {

	@Test
	public void shouldNotAddANullRestaurant() {

		RestaurantManager theManager = new RestaurantManager(null);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			theManager.addRestaurant(null);
		});
		
	}
	
	@Test
	public void shouldNotRemoveANullRestaurant() {
		
		RestaurantManager theManager = new RestaurantManager(null);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			theManager.removeRestaurant(null);
		});
		
	}
	
	@Test
	public void shouldAddOneRestaurant() {
		
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theRestaurant = new Restaurant("Name", thePrice, "Atlanta, GA, USA", 20, 5, "Menu URL", "Image URL", "5416");
		
		theManager.addRestaurant(theRestaurant);
		
		assertEquals("Name: Name Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 5.0 Menu URL: Menu URL Image URL: Image URL Id: 5416"
				+ System.lineSeparator(), theManager.toString());
		
	}
	
	@Test
	public void shouldAddMultipleRestaurants() {
		
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", "Third Image URL", "4561");
		
		theManager.addRestaurant(theFirstRestaurant);
		theManager.addRestaurant(theSecondRestaurant);
		theManager.addRestaurant(theThirdRestaurant);
		
		assertEquals("Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator() + "Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 15 Review Score: 3.9 Menu URL: Second Menu URL Image URL: Second Image URL Id: 41987"
				+ System.lineSeparator() + "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 10 Review Score: 4.5 Menu URL: Third Menu URL Image URL: Third Image URL Id: 4561"
				+ System.lineSeparator(), theManager.toString());
	}
	
	@Test
	public void shouldNotRemoveFromEmptyManager() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theRestaurant = new Restaurant("Name", thePrice, "Atlanta, GA, USA", 20, 5, "Menu URL", "Image URL", "5416");
		theManager.removeRestaurant(theRestaurant);
		
		assertEquals("", theManager.toString());
		
	}
	
	@Test
	public void shouldNotRemoveRestaurantNotInAManagerWithOneRestaurant() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		
		theManager.addRestaurant(theFirstRestaurant);
		theManager.removeRestaurant(theSecondRestaurant);
		
		assertEquals("Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator(), theManager.toString());
		
	}
	
	@Test
	public void shouldNotRemoveRestaurantNotInAManagerWithManyRestaurants() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", "Third Image URL", "4561");
		Restaurant theFourthRestaurant = new Restaurant("Fourth Restaurant", thePrice, "Atlanta, GA, USA", 12, 4.2, "Fourth Menu URL", "Third Image URL", "7848");
		
		theManager.addRestaurant(theFirstRestaurant);
		theManager.addRestaurant(theSecondRestaurant);
		theManager.addRestaurant(theThirdRestaurant);
		theManager.removeRestaurant(theFourthRestaurant);
		
		assertEquals("Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator() + "Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 15 Review Score: 3.9 Menu URL: Second Menu URL Image URL: Second Image URL Id: 41987"
				+ System.lineSeparator() + "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 10 Review Score: 4.5 Menu URL: Third Menu URL Image URL: Third Image URL Id: 4561"
				+ System.lineSeparator(), theManager.toString());
		
	}
	
	@Test
	public void shouldRemoveRestaurantInAManagerWithOneRestaurant() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		
		theManager.addRestaurant(theRestaurant);
		theManager.removeRestaurant(theRestaurant);
		
		assertEquals("", theManager.toString());
		
	}
	
	@Test
	public void shouldRemoveFirstRestaurantInAManagerWithManyRestaurants() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", "Third Image URL", "4561");
		
		theManager.addRestaurant(theFirstRestaurant);
		theManager.addRestaurant(theSecondRestaurant);
		theManager.addRestaurant(theThirdRestaurant);
		theManager.removeRestaurant(theFirstRestaurant);
		
		assertEquals("Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 15 Review Score: 3.9 Menu URL: Second Menu URL Image URL: Second Image URL Id: 41987"
				+ System.lineSeparator() + "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 10 Review Score: 4.5 Menu URL: Third Menu URL Image URL: Third Image URL Id: 4561"
				+ System.lineSeparator(), theManager.toString());
		
	}

	@Test
	public void shouldRemoveMiddleRestaurantInAManagerWithManyRestaurants() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", "Third Image URL", "4561");
		
		theManager.addRestaurant(theFirstRestaurant);
		theManager.addRestaurant(theSecondRestaurant);
		theManager.addRestaurant(theThirdRestaurant);
		theManager.removeRestaurant(theSecondRestaurant);
		
		assertEquals("Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator() + "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 10 Review Score: 4.5 Menu URL: Third Menu URL Image URL: Third Image URL Id: 4561"
				+ System.lineSeparator(), theManager.toString());
		
	}
	
	@Test
	public void shouldRemoveLastRestaurantInAManagerWithManyRestaurants() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", "Third Image URL", "4561");
		
		theManager.addRestaurant(theFirstRestaurant);
		theManager.addRestaurant(theSecondRestaurant);
		theManager.addRestaurant(theThirdRestaurant);
		theManager.removeRestaurant(theThirdRestaurant);
		
		assertEquals("Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator() + "Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 15 Review Score: 3.9 Menu URL: Second Menu URL Image URL: Second Image URL Id: 41987"
				+ System.lineSeparator(), theManager.toString());
		
	}
	
	@Test
	public void shouldGetSizeOfEmptyManager() {
		RestaurantManager theManager = new RestaurantManager(null);
		assertEquals(0, theManager.size());
	}
	
	@Test
	public void shouldGetSizeOfManagerWithOneRestaurant() {
		Price thePrice = Price.$;
		RestaurantManager theManager = new RestaurantManager(null);
		Restaurant theRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		
		theManager.addRestaurant(theRestaurant);
		
		assertEquals(1, theManager.size());
	}
	
	@Test
	public void shouldGetSizeOfManagerWithManyRestaurants() {
		RestaurantManager theManager = new RestaurantManager(null);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 15, 3.9, "Second Menu URL", "Second Image URL", "41987");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 10, 4.5, "Third Menu URL", "Third Image URL", "4561");
		Restaurant theFourthRestaurant = new Restaurant("Fourth Restaurant", thePrice, "Atlanta, GA, USA", 12, 4.2, "Fourth Menu URL", "Third Image URL", "7848");
		
		theManager.addRestaurant(theFirstRestaurant);
		theManager.addRestaurant(theSecondRestaurant);
		theManager.addRestaurant(theThirdRestaurant);
		theManager.addRestaurant(theFourthRestaurant);
		
		assertEquals(4, theManager.size());
	}
}
