/**
 * 
 */
package src.test.mainmanager;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Test;

import src.model.MainManager;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestConstructor {

	@Test
	void testNonNullRandom() {
		MainManager testMainManager = new MainManager(new Random());
		assertNotNull(testMainManager.getRestaurantManager());
		assertNotNull(testMainManager.getRestaurantManager());
		assertFalse(testMainManager.getResetFilters());
	}

	@Test
	void testNullRandom() {
		MainManager testMainManager = new MainManager(null);
		assertNotNull(testMainManager.getRestaurantManager());
		assertNotNull(testMainManager.getRestaurantManager());
		assertFalse(testMainManager.getResetFilters());
	}
}
