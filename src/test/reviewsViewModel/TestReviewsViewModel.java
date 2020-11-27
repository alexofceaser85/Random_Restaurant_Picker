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
	public void shouldGetReviewer() {
		
		StringProperty reviewerNameTestAgainst = new SimpleStringProperty();
		reviewerNameTestAgainst.set("Lewis Baumstark");
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 3);
		
		assertEquals(reviewerNameTestAgainst.getValue(), theReviewsViewModel.getReviewer().getValue());
	}
	
	@Test
	public void shouldGetReviewContent() {
		
		StringProperty reviewerContentTestAgainst = new SimpleStringProperty();
		reviewerContentTestAgainst.set("This lamb is so undercooked, it’s following Mary to school!");
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 3);
		
		assertEquals(reviewerContentTestAgainst.getValue(), theReviewsViewModel.getContent().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreAtMinimum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(1);
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneTenthAboveMinimum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(1.1);
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneAboveMinimum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(2);
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 2);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneTenthBelowMaximum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(4.9);
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4.9);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreOneBelowMaximum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(4);
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldGetReviewScoreAtMaximum() {
		
		DoubleProperty reviewScoreTestAgainst = new SimpleDoubleProperty();
		reviewScoreTestAgainst.set(5);
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 5);
		
		assertEquals(reviewScoreTestAgainst.getValue(), theReviewsViewModel.getReviewScore().getValue());
	}
	
	@Test
	public void shouldReturnStringDescriptionOfViewModel() {
		
		StringProperty reviewerNameTestAgainst = new SimpleStringProperty();
		reviewerNameTestAgainst.set("Reviewer: Lewis Baumstark Content: This lamb is so undercooked, it’s following Mary to school! Score: 4.0");
		
		ReviewsViewModel theReviewsViewModel = new ReviewsViewModel("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 4);
		
		assertEquals(reviewerNameTestAgainst.getValue(), theReviewsViewModel.toString());
	}
}
