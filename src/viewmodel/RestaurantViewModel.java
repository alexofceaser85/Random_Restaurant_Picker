package src.viewmodel;

import javafx.scene.image.Image;

import java.text.DecimalFormat;
import java.util.List;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import src.data.JSONLoader;
import src.data.QueryManager;
import src.data.ReviewsQuery;
import src.error_messages.ErrorMessages;
import src.model.MainManager;
import src.model.Price;
import src.model.Restaurant;
import src.model.RestaurantManager;
import src.model.Review;
import src.model.ReviewManager;
/**
 * ViewModel class of the RestaurantViewCodeBehind
 * 
 * @author Furichous Jones IV
 * @version Fall 2020
 **/
public class RestaurantViewModel {
	private StringProperty nameProperty;
	private ObjectProperty<Image> imageProperty;
	private StringProperty locationProperty;
	private StringProperty priceRangeProperty;
	private StringProperty distanceProperty;
	private StringProperty reviewScoreProperty;
	private MainManager mainManager;
	private String restaurantID;
	private StringProperty menuURLProperty;

	/**
	 * Constructor of RestaurantViewModel
	 * 
	 * @param mainManager the MainManager of the application
	 * 
	 * @precondition mainManager != null
	 * @postcondition none
	 */
	public RestaurantViewModel(MainManager mainManager) {
		if (mainManager == null) {
			throw new IllegalArgumentException();
		}
		this.nameProperty = new SimpleStringProperty();
		this.imageProperty = new SimpleObjectProperty<Image>();
		this.locationProperty = new SimpleStringProperty();
		this.priceRangeProperty = new SimpleStringProperty();
		this.distanceProperty = new SimpleStringProperty();
		this.reviewScoreProperty = new SimpleStringProperty();
		this.restaurantID = "";
		this.menuURLProperty = new SimpleStringProperty();
		this.mainManager = mainManager;
	}

	/**
	 * Picks a random restaurant
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return boolean of whether a restaurant was picked
	 */
	public boolean pickARestaurant() {
		RestaurantManager theManager = this.mainManager.getRestaurantManager();
		Restaurant pickedRestaurant = theManager.pickRandom();
		if (pickedRestaurant == null) {
			return false;
		}

		String name = pickedRestaurant.getName();
		String location = pickedRestaurant.getLocation();
		Price price = pickedRestaurant.getPrice();

		int distance = pickedRestaurant.getDistance();
		String distanceFormatted = Integer.toString(distance) + " mi";

		Image image = this.buildImage(pickedRestaurant);
		this.imageProperty.set(image);

		double reviewScore = pickedRestaurant.getReviewScore();
		DecimalFormat df = new DecimalFormat("#.#");
		String reviewScoreFormatted = df.format(reviewScore);

		this.nameProperty.set(name);

		this.locationProperty.set(location);
		this.priceRangeProperty.set(price.toString());
		this.distanceProperty.set(distanceFormatted);
		this.reviewScoreProperty.set(reviewScoreFormatted);
		this.restaurantID = pickedRestaurant.getId();
		this.menuURLProperty.set(pickedRestaurant.getMenuURL());
		return true;
	}

	private Image buildImage(Restaurant pickedRestaurant) {
		String imageURL = pickedRestaurant.getImageURL();
		Image image;
		try {
			image = new Image(imageURL);
		} catch (Exception e) {
			image = new Image(JSONLoader.DEFAULT_IMAGE);
		}
		return image;
	}

	/**
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public void resetFilters() {
		this.mainManager.setResetFilters(true);
	}

	/**
	 * @return the value of menuURLProperty
	 */
	public StringProperty menuURLProperty() {
		return this.menuURLProperty;
	}
	
	/**
	 * Returns the menuURL property
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 */
	public boolean sendReviewsQuery() {
		ReviewsQuery query = new ReviewsQuery(this.restaurantID);

		String response = QueryManager.sendQuery(query);
		List<Review> reviews = JSONLoader.parseReviews(response);

		ReviewManager theManager = this.mainManager.getReviewManager();
		theManager.setReviews(reviews);
		return reviews.isEmpty();
	}

	/**
	 * Returns the menuURL property
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the menuURL property
	 */
	public StringProperty nameProperty() {
		return this.nameProperty;
	}

	/**
	 * Returns the menuURL property
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the menuURL property
	 */
	public ObjectProperty<Image> imageProperty() {
		return this.imageProperty;
	}

	/**
	 * Returns the menuURL property
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the menuURL property
	 */
	public StringProperty locationProperty() {
		return this.locationProperty;
	}

	/**
	 * Returns the menuURL property
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the menuURL property
	 */
	public StringProperty priceRangeProperty() {
		return this.priceRangeProperty;
	}

	/**
	 * Returns the menuURL property
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the menuURL property
	 */
	public StringProperty distanceProperty() {
		return this.distanceProperty;
	}

	/**
	 * Returns the menuURL property
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the menuURL property
	 */
	public StringProperty reviewScoreProperty() {
		return this.reviewScoreProperty;
	}

	/**
	 * Returns the mainManager
	 * 
	 * @precondition none
	 * @postcondition none
	 *
	 * @return the mainManager value
	 */
	public MainManager getMainManager() {
		return this.mainManager;
	}
	
	/**
	 * @return the value of restaurantID
	 */
	public String getRestaurantID() {
		return this.restaurantID;
	}

	
}
