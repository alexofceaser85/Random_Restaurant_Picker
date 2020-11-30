/**
 * 
 */
package src.test.mainmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.model.Price;
import src.model.Restaurant;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class RemoveRestaurant {

	@Test
	public void shouldRemoveRestaurantFromManagerWithOneItem() {
		
		Random theRandomGenerator = new Random();
		MainManager theMainManager = new MainManager(theRandomGenerator);
		Price thePrice = Price.$;
		Restaurant theRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		
		theMainManager.getRestaurantManager().addRestaurant(theRestaurant);
		
		theMainManager.removeRestaurant(theRestaurant);
		
		assertEquals("", theMainManager.getRestaurantManager().toString());
	}
	
	@Test
	public void shouldRemoveFirstRestaurantFromManagerWithOneItem() {
		
		Random theRandomGenerator = new Random();
		MainManager theMainManager = new MainManager(theRandomGenerator);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		
		theMainManager.getRestaurantManager().addRestaurant(theFirstRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theSecondRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theThirdRestaurant);
		
		theMainManager.removeRestaurant(theFirstRestaurant);
		
		assertEquals("Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator() + "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator(), theMainManager.getRestaurantManager().toString());
	}
	
	@Test
	public void shouldRemoveMiddleRestaurantFromManagerWithOneItem() {
		
		Random theRandomGenerator = new Random();
		MainManager theMainManager = new MainManager(theRandomGenerator);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		
		theMainManager.getRestaurantManager().addRestaurant(theFirstRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theSecondRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theThirdRestaurant);
		
		theMainManager.removeRestaurant(theSecondRestaurant);
		
		assertEquals("Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator() + "Name: Third Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator(), theMainManager.getRestaurantManager().toString());
	}
	
	
	@Test
	public void shouldRemoveLastRestaurantFromManagerWithOneItem() {
		
		Random theRandomGenerator = new Random();
		MainManager theMainManager = new MainManager(theRandomGenerator);
		Price thePrice = Price.$;
		Restaurant theFirstRestaurant = new Restaurant("First Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theSecondRestaurant = new Restaurant("Second Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		Restaurant theThirdRestaurant = new Restaurant("Third Restaurant", thePrice, "Atlanta, GA, USA", 20, 1.8, "First Menu URL", "First Image URL", "5416");
		
		theMainManager.getRestaurantManager().addRestaurant(theFirstRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theSecondRestaurant);
		theMainManager.getRestaurantManager().addRestaurant(theThirdRestaurant);
		
		theMainManager.removeRestaurant(theThirdRestaurant);
		
		assertEquals("Name: First Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator() + "Name: Second Restaurant Price: $ Location: Atlanta, GA, USA Distance: 20 Review Score: 1.8 Menu URL: First Menu URL Image URL: First Image URL Id: 5416"
				+ System.lineSeparator(), theMainManager.getRestaurantManager().toString());
	}

}
