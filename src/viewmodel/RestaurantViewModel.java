package src.viewmodel;
import javafx.scene.image.Image;

import java.text.DecimalFormat;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.model.MainManager;
import src.model.Price;
import src.model.Restaurant;
import src.model.RestaurantManager;

public class RestaurantViewModel {
	private StringProperty nameProperty;
	private ObjectProperty<Image> imageProperty;
	private StringProperty locationProperty;
	private StringProperty priceRangeProperty;
	private StringProperty distanceProperty;
	private StringProperty reviewScoreProperty;
	private MainManager mainManager;
	private String restaurantID;
	public RestaurantViewModel() {
		this.nameProperty = new SimpleStringProperty();
		this.imageProperty = new SimpleObjectProperty<Image>();
		this.locationProperty = new SimpleStringProperty();
		this.priceRangeProperty = new SimpleStringProperty();
		this.distanceProperty = new SimpleStringProperty();
		this.reviewScoreProperty = new SimpleStringProperty();
		this.mainManager = new MainManager();
		this.restaurantID = "";
	}
	
	public void setMainManager(MainManager mainManager) {
		this.mainManager = mainManager;
	}
	
	public void pickARestaurant() {
		RestaurantManager theManager = this.mainManager.getRestaurantManager();
		Restaurant pickedRestaurant = theManager.pickRandom();
		this.restaurantID = pickedRestaurant.getId();
		
		String name = pickedRestaurant.getName();
		String location = pickedRestaurant.getLocation();
		Price price = pickedRestaurant.getPrice();
		
		int distance = pickedRestaurant.getDistance();
		String distanceFormatted = Integer.toString(distance);
		
		String imageURL = pickedRestaurant.getImageURL();
		Image image = new Image(imageURL);
		
		double reviewScore = pickedRestaurant.getReviewScore();
		DecimalFormat df = new DecimalFormat("#.#"); 
		String reviewScoreFormatted = df.format(reviewScore);
		
		this.nameProperty.set(name);
		this.imageProperty.set(image);
		this.locationProperty.set(location);
		this.priceRangeProperty.set(price.toString());
		this.distanceProperty.set(distanceFormatted);
		this.reviewScoreProperty.set(reviewScoreFormatted);
	}
	
	public void resetFilters() {
		this.mainManager.setResetFilters(true);
	}
	
	public void appendReviewsQuery() {
		throw new UnsupportedOperationException();
	}
	
	public StringProperty nameProperty() {
		return this.nameProperty;
	}
	
	public ObjectProperty<Image> imageProperty() {
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
	
}
