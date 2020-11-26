package src.test.reviewsViewModel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.model.Review;
import src.viewmodel.ReviewsViewModel;

class TestReviewsViewModel {

	@Test
	public void shouldNotAllowNullReview() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new ReviewsViewModel(null);
		});
	}
	
	@Test
	public void shouldGetReviewer() {
		
		StringProperty reviewerNameTestAgainst = new SimpleStringProperty();
		reviewerNameTestAgainst.set("Lewis Baumstark");
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 3);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewerNameTestAgainst.getValue(), theReviewsViewModel.getReviewer().getValue());
	}
	
	@Test
	public void shouldGetReviewContent() {
		
		StringProperty reviewerContentTestAgainst = new SimpleStringProperty();
		reviewerContentTestAgainst.set("This lamb is so undercooked, it’s following Mary to school!");
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 3);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewerContentTestAgainst.getValue(), theReviewsViewModel.getContent().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreAtMinimum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(1);
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneTenthAboveMinimum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(1.1);
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneAboveMinimum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(2);
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 2);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneTenthBelowMaximum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(4.9);
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4.9);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneBelowMaximum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(4);
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreAtMaximum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(5);
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldReturnStringDescriptionOfViewModel() {
		
		StringProperty reviewerNameTestAgainst = new SimpleStringProperty();
		reviewerNameTestAgainst.set("Reviewer: Lewis Baumstark Content: This lamb is so undercooked, it’s following Mary to school! Review Score: 4.0");
		
		Review theReview = new Review("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4);
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel(theReview);
		
		assertEquals(reviewerNameTestAgainst.getValue(), theReviewsViewModel.toString());
	}
}
