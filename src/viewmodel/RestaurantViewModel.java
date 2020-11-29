package src.viewmodel;

import javafx.scene.image.Image;

import java.awt.Desktop;
import java.net.URL;
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

public class RestaurantViewModel {
	private StringProperty nameProperty;
	private ObjectProperty<Image> imageProperty;
	private StringProperty locationProperty;
	private StringProperty priceRangeProperty;
	private StringProperty distanceProperty;
	private StringProperty reviewScoreProperty;
	private MainManager mainManager;
	private String restaurantID;
	private String menuURL;

	public RestaurantViewModel(MainManager mainManager) {
		this.nameProperty = new SimpleStringProperty();
		this.imageProperty = new SimpleObjectProperty<Image>();
		this.locationProperty = new SimpleStringProperty();
		this.priceRangeProperty = new SimpleStringProperty();
		this.distanceProperty = new SimpleStringProperty();
		this.reviewScoreProperty = new SimpleStringProperty();
		this.restaurantID = "";
		this.menuURL = "";
		this.mainManager = mainManager;
	}

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
		String distanceFormatted = Integer.toString(distance);

		String imageURL = pickedRestaurant.getImageURL();
		Image image;
		try {
			image = new Image(imageURL);
		} catch (Exception e) {
			image = new Image(JSONLoader.DEFAULT_IMAGE);
		}
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
		this.menuURL = pickedRestaurant.getMenuURL();
		return true;
	}

	public void resetFilters() {
		if (this.mainManager == null) {
			throw new IllegalArgumentException(ErrorMessages.MAIN_MANAGER_SHOULD_NOT_BE_NULL);
		}
		this.mainManager.setResetFilters(true);
	}

	public void sendReviewsQuery() {
		ReviewsQuery query = new ReviewsQuery(this.restaurantID);

		String response = QueryManager.sendQuery(query);
		List<Review> reviews = JSONLoader.parseReviews(response);

		ReviewManager theManager = this.mainManager.getReviewManager();
		theManager.setReviews(reviews);
	}

	public void openMenuInBrowser() {
		try {
			Desktop.getDesktop().browse(new URL(this.menuURL).toURI());
		} catch (Exception e) {
			// swallow catch
		}
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
