package src.test.restaurant;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.Restaurant;
import src.model.Price;

class TestConstructor {

	@Test
	public void RestaurantNameCannotBeNull() {
		
		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant(null, thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantNameCannotBeEmpty() {
		
		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantPriceShouldNotBeNull() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", null, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantLocationShouldNotBeNull() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, null, 20, 4, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantLocationShouldNotBeEmpty() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "", 20, 4, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantDistanceShouldNotBeOneBelowMinimumDistance() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", -1, 4, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantDistanceShouldNotBeWellBelowMinimumDistance() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", -100, 4, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantReviewScoreShouldNotBeOneBelowMinimumReviewScore() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 0, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantReviewScoreShouldNotBeOneTenthBelowMinimumReviewScore() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, .9, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantReviewScoreShouldNotBeWellBelowMinimumReviewScore() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, -100, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantReviewScoreShouldNotBeOneTenthAboveMaximumReviewScore() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 5.1, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantReviewScoreShouldNotBeOneAboveMaximumReviewScore() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 6, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantReviewScoreShouldNotBeWellAboveMaximumReviewScore() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 100, "The Menu URL", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantMenuURLShouldNotBeNull() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, null, "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantMenuURLShouldNotBeEmpty() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "", "The Image URL", "156");
		});
	}
	
	@Test
	public void RestaurantImageURLShouldNotBeNull() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", null, "156");
		});
	}
	
	@Test
	public void RestaurantImageURLShouldNotBeEmpty() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "", "156");
		});
	}
	
	@Test
	public void RestaurantImageIdShouldNotBeNull() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", null);
		});
	}
	
	@Test
	public void RestaurantImageIdShouldNotBeEmpty() {

		Price thePrice = Price.$;
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "");
		});
	}

	@Test
	public void ShouldAllowValidRestaurantName() {
		
		Price thePrice = Price.$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals("The Name", theRestaurant.getName());
	}
	
	@Test
	public void ShouldAllowMinimumRestaurantPrice() {
		
		Price thePrice = Price.$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals(Price.$, theRestaurant.getPrice());
	}
	
	@Test
	public void ShouldAllowMaximumRestaurantPrice() {
		
		Price thePrice = Price.$$$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals(Price.$$$$, theRestaurant.getPrice());
	}
	
	@Test
	public void ShouldAllowRestaurantPriceBetweenMinimumAndMaximum() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals(Price.$$, theRestaurant.getPrice());
		
	}
	
	@Test
	public void ShouldAllowRestaurantLocation() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 20, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals("Atlanta, GA, USA", theRestaurant.getLocation());
		
	}
	
	@Test
	public void ShouldAllowMinimumRestaurantDistance() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 5, "The Menu URL", "The Image URL", "156");
		
		assertEquals(0, theRestaurant.getDistance());
		
	}
	
	@Test
	public void ShouldAllowOneAboveMinimumRestaurantDistance() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 1, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals(1, theRestaurant.getDistance());
		
	}
	
	@Test
	public void ShouldAllowWellAboveMinimumRestaurantDistance() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 100, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals(100, theRestaurant.getDistance());
		
	}
	
	@Test
	public void ShouldAllowMinimumRestaurantReviewScore() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 1, "The Menu URL", "The Image URL", "156");
		
		assertEquals(1, theRestaurant.getReviewScore());
		
	}
	
	@Test
	public void ShouldAllowOneTenthAboveMinimumRestaurantReviewScore() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 1.1, "The Menu URL", "The Image URL", "156");
		
		assertEquals(1.1, theRestaurant.getReviewScore());
		
	}
	
	@Test
	public void ShouldAllowOneAboveMinimumRestaurantReviewScore() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 2, "The Menu URL", "The Image URL", "156");
		
		assertEquals(2, theRestaurant.getReviewScore());
		
	}
	
	@Test
	public void ShouldAllowRestaurantReviewScoreBetweenMinimumAndMaximum() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 3, "The Menu URL", "The Image URL", "156");
		
		assertEquals(3, theRestaurant.getReviewScore());
		
	}
	
	@Test
	public void ShouldAllowMaximumRestaurantReviewScore() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 5, "The Menu URL", "The Image URL", "156");
		
		assertEquals(5, theRestaurant.getReviewScore());
		
	}
	
	@Test
	public void ShouldAllowOneBelowMaximumRestaurantReviewScore() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 4, "The Menu URL", "The Image URL", "156");
		
		assertEquals(4, theRestaurant.getReviewScore());
		
	}
	
	@Test
	public void ShouldAllowOneTenthBelowMaximumRestaurantReviewScore() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 4.9, "The Menu URL", "The Image URL", "156");
		
		assertEquals(4.9, theRestaurant.getReviewScore());
		
	}
	
	@Test
	public void ShouldAllowValidMenuURL() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 4.9, "The Menu URL", "The Image URL", "156");
		
		assertEquals("The Menu URL", theRestaurant.getMenuURL());
		
	}
	
	@Test
	public void shouldAllowValidImageURL() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 4.9, "The Menu URL", "The Image URL", "156");
		
		assertEquals("The Image URL", theRestaurant.getImageURL());
		
	}
	
	@Test
	public void shouldAllowValidId() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 4.9, "The Menu URL", "The Image URL", "156");
		
		assertEquals("156", theRestaurant.getId());
		
	}
	
	@Test
	public void shouldReturnToStringWithValidValues() {
		
		Price thePrice = Price.$$;
		Restaurant theRestaurant = new Restaurant("The Name", thePrice, "Atlanta, GA, USA", 0, 4.9, "The Menu URL", "The Image URL", "156");
		
		assertEquals("Name: The Name Price: $$ Location: Atlanta, GA, USA Distance: 0 Review Score: 4.9 Menu URL: The Menu URL Image URL: The Image URL Id: 156", theRestaurant.toString());
		
	}
	
}
