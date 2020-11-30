package src.main;
	
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import src.controller.SceneController;
import src.model.MainManager;
import src.view.FilterCodeBehind;
import src.view.RestaurantViewCodeBehind;
import src.view.ReviewsCodeBehind;
import src.viewmodel.FilterViewModel;
import src.viewmodel.RestaurantViewModel;
import src.viewmodel.ReviewsManagerViewModel;

/**
 * Main class for application entry.
 * 
 * @author Furichous Jones IV
 * @version Fall 2020
 **/
public class Main extends Application {
	private SceneController controller;
	private MainManager mainManager;
	
	@Override
	public void start(Stage primaryStage) {
		this.mainManager = new MainManager(new Random());
		this.controller = new SceneController(primaryStage);
		
		this.registerReviewError();
		this.registerReviews();
		
		this.registerRestaurantError();
		this.registerRestaurantLoad();
		this.registerRestaurant();
		
		FilterViewModel filterViewModel = new FilterViewModel(this.mainManager);
		this.registerFilter(filterViewModel);
		this.registerLocation(filterViewModel);
	
		this.controller.activate("Location");
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 */
	private void registerReviewError() {
		FXMLLoader reviewErrorLoader = new FXMLLoader();
		reviewErrorLoader.setLocation(Main.class.getClassLoader().getResource("src/view/ReviewErrorGUI.fxml"));
		try {
			reviewErrorLoader.load();
		} catch (Exception e) {
			System.out.println("ReviewsErrorGUI load error");
		}
		this.controller.add("ReviewsError", reviewErrorLoader);
	}

	private void registerReviews() {
		FXMLLoader reviewsLoader = new FXMLLoader();
		ReviewsManagerViewModel reviewsViewModel = new ReviewsManagerViewModel(this.mainManager);
		ReviewsCodeBehind reviewsManagerCodeBehind = new ReviewsCodeBehind(reviewsViewModel);
		reviewsLoader.setController(reviewsManagerCodeBehind);
		reviewsLoader.setLocation(Main.class.getClassLoader().getResource("src/view/ReviewsPageGUI.fxml"));
		try {
			reviewsLoader.load();
		} catch (Exception e) {
			System.out.println("ReviewsPageGUI load error");
		}
		this.controller.add("Reviews", reviewsLoader);
	}

	private void registerRestaurantError() {
		FXMLLoader restaurantErrorLoader = new FXMLLoader();
		restaurantErrorLoader.setLocation(Main.class.getClassLoader().getResource("src/view/RestaurantErrorGUI.fxml"));
		try {
			restaurantErrorLoader.load();
		} catch (Exception e) {
			System.out.println("RestaurantErrorGUI load error");
		}
		this.controller.add("RestaurantError", restaurantErrorLoader);
	}

	private void registerRestaurantLoad() {
		FXMLLoader restaurantLoadLoader = new FXMLLoader();
		restaurantLoadLoader.setLocation(Main.class.getClassLoader().getResource("src/view/RestaurantLoadGUI.fxml"));
		try {
			restaurantLoadLoader.load();
		} catch (Exception e) {
			System.out.println("RestaurantLoadGUI load error");
		}
		this.controller.add("RestaurantLoad", restaurantLoadLoader);
	}
	
	private void registerRestaurant() {
		RestaurantViewModel restaurantViewModel = new RestaurantViewModel(this.mainManager);
		RestaurantViewCodeBehind restaurantController = new RestaurantViewCodeBehind(restaurantViewModel);
		FXMLLoader restaurantLoader = new FXMLLoader();
		restaurantLoader.setController(restaurantController);
		restaurantLoader.setLocation(Main.class.getClassLoader().getResource("src/view/RestaurantGUI.fxml"));
		try {
			restaurantLoader.load();
		} catch (Exception e) {
			System.out.println("RestaurantGUI load error");
		}
		this.controller.add("Restaurant", restaurantLoader);
	}

	private void registerFilter(FilterViewModel filterViewModel) {
		FXMLLoader filtersLoader = new FXMLLoader();
		FilterCodeBehind filterController = new FilterCodeBehind(filterViewModel);
		filtersLoader.setController(filterController);
		filtersLoader.setLocation(Main.class.getClassLoader().getResource("src/view/FilterPageGUI.fxml"));
		try {
			filtersLoader.load();
		} catch (Exception e) {
			System.out.println("FilterPageGUI load error");
		}
		this.controller.add("Filter", filtersLoader);
	}

	private void registerLocation(FilterViewModel filterViewModel) {
		FXMLLoader locationLoader = new FXMLLoader();
		FilterCodeBehind filterController = new FilterCodeBehind(filterViewModel);
		locationLoader.setController(filterController);
		locationLoader.setLocation(Main.class.getClassLoader().getResource("src/view/LocationAndRadiusGUI.fxml"));
		try {
			locationLoader.load();
		} catch (Exception e) {
			System.out.println("LocationAndRadiusGUI load error");
		}
		this.controller.add("Location", locationLoader);
	}
	
	/**
	 * Main program entry point
	 * 
	 * @param args execution arguments
	 * 
	 * @precondition none
	 * @postcondition none
	 **/
	public static void main(String[] args) {
		launch(args);
	}
}
