package src.test.reviewmanagerviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.model.Review;
import src.viewmodel.ReviewsManagerViewModel;

class TestGetReviewer {

	@Test
	public void shouldNotGetReviewerFromEmptyReviewManager() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		
		Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			theReviewsManagerViewModel.getReviewer(1);
		});
		
	}
	
	@Test
	public void shouldGetFirstReviewer() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("Lewis Baumstark", theReviewsManagerViewModel.getReviewer(0));
	}
	
	@Test
	public void shouldGetSecondReviewer() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("Duane Yoder", theReviewsManagerViewModel.getReviewer(1));
	}
	
	@Test
	public void shouldGetThirdReviewer() {
		MainManager mainManager = new MainManager(new Random());
		ReviewsManagerViewModel theReviewsManagerViewModel = new ReviewsManagerViewModel(mainManager);
		
		theReviewsManagerViewModel.addReview("Lewis Baumstark", "This lamb is so undercooked, it’s following Mary to school!", 1.1);
		theReviewsManagerViewModel.addReview("Duane Yoder", "This pizza is so disgusting, if you take it to Italy you’ll get arrested.", 4.5);
		theReviewsManagerViewModel.addReview("Alexander Ayers", "Roses are Red. Violets Are Blue. Null Pointer Exception on Line 2", 3.1);
		
		assertEquals("Alexander Ayers", theReviewsManagerViewModel.getReviewer(2));
	}

}
