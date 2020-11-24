package src.test.review;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.Restaurant;
import src.model.Review;

class TestReviewConstructor {

	@Test
	public void reviewerNameCannotBeNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review(null, "My gran could do better! And she’s dead!", 1);
		});
		
	}
	
	@Test
	public void reviewerNameCannotBeEmpty() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("", "There’s enough garlic in here to kill every vampire in Europe.", 1);
		});
		
	}
	
	@Test
	public void reviewContentCannotBeNull() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("John Corley", null, 1);
		});
		
	}
	
	@Test
	public void reviewContentCannotBeEmpty() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("Ana Stanescu", "", 1);
		});
		
	}
	
	@Test
	public void reviewScoreCannotBeOneTenthLessThanMinimum() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", .9);
		});
	}
	
	@Test
	public void reviewScoreCannotBeOneLessThanMinimum() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("Christina Rolka", "WHERE IS THE LAMB SAUCE", 0);
		});
	}
	
	@Test
	public void reviewScoreCannotBeWellLessThanMinimum() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("Christina Rolka", "The Freshest Thing In This Kitchen Is That Pigeon.", -40);
		});
	}
	
	@Test
	public void reviewScoreCannotBeOneTenthAboveMaximum() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("Lewis Baumstark", "It was pretty good", 5.1);
		});
	}
	
	@Test
	public void reviewScoreCannotBeOneAboveMaximum() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("Christina Rolka", "It was so good I had to give it more than five stars", 6);
		});
	}
	
	@Test
	public void reviewScoreCannotBeWellAboveMaximum() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Review("Christina Rolka", "This is some good stuff", 40);
		});
	}
	
	@Test
	public void shouldAllowValidReviewerName() {
		
		Review theReview = new Review("Christina Rolka", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 1);
		assertEquals("Christina Rolka", theReview.getReviewerName());
	}
	
	@Test
	public void shouldAllowValidReviewContent() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4);
		assertEquals("This lamb is so undercooked, it’s following Mary to school!", theReview.getReviewContent());
	}
	
	@Test
	public void shouldAllowReviewScoreAtMinimum() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1);
		assertEquals(1, theReview.getReviewScore()); 
	}
	
	@Test
	public void shouldAllowReviewScoreOneTenthAboveMinimum() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		assertEquals(1.1, theReview.getReviewScore()); 
	}
	
	@Test
	public void shouldAllowReviewScoreOneAboveMinimum() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 2);
		assertEquals(2, theReview.getReviewScore()); 
	}
	
	@Test
	public void shouldAllowReviewScoreBetweenMinimumAndMaximum() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 3);
		assertEquals(3, theReview.getReviewScore()); 
	}

	@Test
	public void shouldAllowReviewScoreOneBelowMaximum() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4);
		assertEquals(4, theReview.getReviewScore()); 
	}
	
	@Test
	public void shouldAllowReviewScoreOneTenthBelowMaximum() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4.9);
		assertEquals(4.9, theReview.getReviewScore()); 
	}
	
	@Test
	public void shouldAllowReviewScoreAtwMaximum() {
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		assertEquals(5, theReview.getReviewScore()); 
	}
}
