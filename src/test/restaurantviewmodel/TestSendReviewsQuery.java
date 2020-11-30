/**
 * 
 */
package src.test.restaurantviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import src.data.QueryManager;
import src.data.RestaurantsQuery;
import src.model.MainManager;
import src.model.Review;
import src.test.restaurantviewmodel.TestPickRestaurant.FakeRandom;
import src.viewmodel.RestaurantViewModel;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestSendReviewsQuery {

	@Test
	void testValidRestaurantID() {
		MainManager testMainManager = new MainManager(null);
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		testViewModel.setRestaurantID("E8RJkjfdcwgtyoPMjQ_Olg");
		assertEquals(true,testViewModel.sendReviewsQuery());
		List<Review> testReviews = testMainManager.getReviewManager().getReviews();
		assertEquals(3,testReviews.size());
	}
	
	@Test
	void testInvalidRestaurantID() {
		MainManager testMainManager = new MainManager(null);
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		testViewModel.setRestaurantID("abc");
		assertEquals(false,testViewModel.sendReviewsQuery());
		List<Review> testReviews = testMainManager.getReviewManager().getReviews();
		assertEquals(0,testReviews.size());
	}
	
	@Test
	void testNullRestaurantID() {
		MainManager testMainManager = new MainManager(null);
		RestaurantViewModel testViewModel = new RestaurantViewModel(testMainManager);
		testViewModel.setRestaurantID(null);
		assertEquals(false,testViewModel.sendReviewsQuery());
		List<Review> testReviews = testMainManager.getReviewManager().getReviews();
		assertEquals(0,testReviews.size());
	}

}
