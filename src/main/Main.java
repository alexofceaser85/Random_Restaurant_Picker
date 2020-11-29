package src.main;
	
import java.util.Random;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import src.controller.SceneController;
import src.model.MainManager;
import src.view.FilterCodeBehind;
import src.view.RestaurantViewCodeBehind;
import src.viewmodel.FilterViewModel;
import src.viewmodel.RestaurantViewModel;

public class Main extends Application {
	private SceneController controller;
	@Override
	public void start(Stage primaryStage) {
		MainManager mainManager = new MainManager(new Random());
		this.controller = new SceneController(primaryStage);
		registerReviews();
		registerRestaurantError();
		
		RestaurantViewModel restaurantViewModel = new RestaurantViewModel(mainManager);
		RestaurantViewCodeBehind restaurantController = new RestaurantViewCodeBehind(restaurantViewModel);
		registerRestaurant(restaurantController);
		
		FilterViewModel filterViewModel = new FilterViewModel(mainManager);
		FilterCodeBehind filterController = new FilterCodeBehind(filterViewModel);
		
		registerFilter(filterController);
		registerLocation(filterController);
	
		this.controller.activate("Location");
	}

	private void registerReviews() {
		FXMLLoader reviewsLoader = new FXMLLoader();
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

	private void registerRestaurant(RestaurantViewCodeBehind restaurantController) {
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

	private void registerFilter(FilterCodeBehind filterController) {
		FXMLLoader filtersLoader = new FXMLLoader();
		filtersLoader.setController(filterController);
		filtersLoader.setLocation(Main.class.getClassLoader().getResource("src/view/FilterPageGUI.fxml"));
		try {
			filtersLoader.load();
		} catch (Exception e) {
			System.out.println("FilterPageGUI load error");
		}
		this.controller.add("Filter", filtersLoader);
	}

	private void registerLocation(FilterCodeBehind filterController) {
		FXMLLoader locationLoader = new FXMLLoader();
		locationLoader.setController(filterController);
		locationLoader.setLocation(Main.class.getClassLoader().getResource("src/view/LocationAndRadiusGUI.fxml"));
		try {
			locationLoader.load();
		} catch (Exception e) {
			System.out.println("LocationAndRadiusGUI load error");
		}
		this.controller.add("Location", locationLoader);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
