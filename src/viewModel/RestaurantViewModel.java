package src.viewModel;
import javafx.scene.image.Image;

import java.text.DecimalFormat;
import java.util.Random;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.error_messages.ErrorMessages;
import src.model.MainManager;
import src.model.Price;
import src.model.Restaurant;
import src.model.RestaurantManager;

public class RestaurantViewModel {
	private StringProperty nameProperty;
	private StringProperty imageProperty;
	private StringProperty locationProperty;
	private StringProperty priceRangeProperty;
	private StringProperty distanceProperty;
	private StringProperty reviewScoreProperty;
	private MainManager mainManager;
	private String restaurantID;
	private String menuURL;
	public RestaurantViewModel() {
		this.nameProperty = new SimpleStringProperty();
		this.imageProperty = new SimpleStringProperty();
		this.locationProperty = new SimpleStringProperty();
		this.priceRangeProperty = new SimpleStringProperty();
		this.distanceProperty = new SimpleStringProperty();
		this.reviewScoreProperty = new SimpleStringProperty();
		this.restaurantID = "";
		this.menuURL = "";
	}
	
	public void setMainManager(MainManager mainManager) {
		if(mainManager == null) {
			throw new IllegalArgumentException(ErrorMessages.MAIN_MANAGER_SHOULD_NOT_BE_NULL);
		}
		this.mainManager = mainManager;
	}
	
	public void pickARestaurant() {
		RestaurantManager theManager = this.mainManager.getRestaurantManager();
		Restaurant pickedRestaurant = theManager.pickRandom();
		if (pickedRestaurant == null) {
			throw new IllegalArgumentException(ErrorMessages.RESTAURANT_NOT_FOUND);
		}
		
		
		String name = pickedRestaurant.getName();
		String location = pickedRestaurant.getLocation();
		Price price = pickedRestaurant.getPrice();
		
		int distance = pickedRestaurant.getDistance();
		String distanceFormatted = Integer.toString(distance);
		
		String imageURL = pickedRestaurant.getImageURL();
		
		double reviewScore = pickedRestaurant.getReviewScore();
		DecimalFormat df = new DecimalFormat("#.#"); 
		String reviewScoreFormatted = df.format(reviewScore);
		
		this.nameProperty.set(name);
		this.imageProperty.set(imageURL);
		this.locationProperty.set(location);
		this.priceRangeProperty.set(price.toString());
		this.distanceProperty.set(distanceFormatted);
		this.reviewScoreProperty.set(reviewScoreFormatted);
		this.restaurantID = pickedRestaurant.getId();
		this.menuURL = pickedRestaurant.getMenuURL();
	}
	
	public void resetFilters() {
		if(this.mainManager == null) {
			throw new IllegalArgumentException(ErrorMessages.MAIN_MANAGER_SHOULD_NOT_BE_NULL);
		}
		this.mainManager.setResetFilters(true);
	}
	
	public void appendReviewsQuery() {
		throw new UnsupportedOperationException();
	}
	
	public StringProperty nameProperty() {
		return this.nameProperty;
	}
	
	public StringProperty imageProperty() {
		return this.imageProperty;
	}
	
	public StringProperty locationProperty() {
		return this.locationProperty;
	}
	
	public StringProperty priceRangeProperty() {
		return this.priceRangeProperty;
	}
	
	public StringProperty distanceProperty() {
		return this.distanceProperty;
	}
	
	public StringProperty reviewScoreProperty() {
		return this.reviewScoreProperty;
	}
	
	public String getRestaurantID() {
		return this.restaurantID;
	}
	
	public MainManager getMainManager() {
		return this.mainManager;
	}
	
	public String getMenuURL() {
		return this.menuURL;
	}
}
