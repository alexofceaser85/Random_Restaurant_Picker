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
	@Override
	public void start(Stage primaryStage) {
		MainManager mainManager = new MainManager(new Random());
		
		SceneController controller = new SceneController(primaryStage);
		boolean loadError = false;
		
		FXMLLoader reviewsLoader = new FXMLLoader();
		reviewsLoader.setLocation(Main.class.getClassLoader().getResource("src/view/ReviewsPageGUI.fxml"));
		try {
			reviewsLoader.load();
		} catch (Exception e) {
			loadError = true;
		}
		
		FXMLLoader restaurantErrorLoader = new FXMLLoader();
		restaurantErrorLoader.setLocation(Main.class.getClassLoader().getResource("src/view/RestaurantErrorGUI.fxml"));
		try {
			restaurantErrorLoader.load();
		} catch (Exception e) {
			loadError = true;
		}
		
		RestaurantViewModel restaurantViewModel = new RestaurantViewModel(mainManager);
		RestaurantViewCodeBehind restaurantController = new RestaurantViewCodeBehind(restaurantViewModel);
		
		FXMLLoader restaurantLoader = new FXMLLoader();
		restaurantLoader.setController(restaurantController);
		restaurantLoader.setLocation(Main.class.getClassLoader().getResource("src/view/RestaurantGUI.fxml"));
		try {
			restaurantLoader.load();
		} catch (Exception e) {
			loadError = true;
		}
		
		FilterViewModel filterViewModel = new FilterViewModel(mainManager);
		FilterCodeBehind filterController = new FilterCodeBehind(filterViewModel);
		
		FXMLLoader filtersLoader = new FXMLLoader();
		filtersLoader.setController(filterController);
		filtersLoader.setLocation(Main.class.getClassLoader().getResource("src/view/FilterPageGUI.fxml"));
		try {
			filtersLoader.load();
		} catch (Exception e) {
			loadError = true;
		}
		
		FXMLLoader locationLoader = new FXMLLoader();
		locationLoader.setController(filterController);
		locationLoader.setLocation(Main.class.getClassLoader().getResource("src/view/LocationAndRadiusGUI.fxml"));
		try {
			locationLoader.load();
		} catch (Exception e) {
			loadError = true;
		}
		
		if (!loadError) {
			controller.add("Restaurant", restaurantLoader);
			controller.add("Reviews", reviewsLoader);
			controller.add("Filter", filtersLoader);
			controller.add("Location", locationLoader);
			controller.add("RestaurantError", restaurantErrorLoader);
			controller.activate("Restaurant");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
