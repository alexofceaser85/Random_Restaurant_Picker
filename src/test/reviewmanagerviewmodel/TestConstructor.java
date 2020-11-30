/**
 * 
 */
package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.ReviewsManagerViewModel;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestConstructor {

	@Test
	void testNullManager() {
		assertThrows(IllegalArgumentException.class, () ->  {
			new ReviewsManagerViewModel(null);
			});
	}
	
	@Test
	void testValidData() {
		MainManager manager = new MainManager(null);
		ReviewsManagerViewModel viewModel = new ReviewsManagerViewModel(manager);
		assertNotNull(viewModel.getRestaurantName());
	}
}
