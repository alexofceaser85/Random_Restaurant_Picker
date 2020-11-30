package src.viewmodel;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import src.data.JSONLoader;
import src.data.QueryManager;
import src.data.RestaurantsQuery;
import src.model.MainManager;
import src.model.Price;
import src.model.Radius;
import src.model.Restaurant;
import src.model.RestaurantManager;

/**
 * View Model for the Filtering section of the UI.
 * 
 * @author Alexander Ayers
 *
 */
public class FilterViewModel {
	private StringProperty locationAddressProperty;
	private ListProperty<Radius> radiusProperty;
	private ObjectProperty<Radius> selectedRadiusProperty;
	private StringProperty categoriesProperty;
	private DoubleProperty reviewScoreProperty;
	private BooleanProperty currentlyOpenProperty;
	private BooleanProperty price1Property;
	private BooleanProperty price2Property;
	private BooleanProperty price3Property;
	private BooleanProperty price4Property;
	private BooleanProperty handicapAccessibleProperty;
	private BooleanProperty acceptsReservationsProperty;
	private BooleanProperty newRestaurantsProperty;
	private BooleanProperty genderNeutralBathroomProperty;
	private MainManager mainManager;

	/**
	 * 
	 * @param mainManager the MainManager of the application
	 * 
	 * @precondition mainManager != null
	 * @postcondition none
	 */
	public FilterViewModel(MainManager mainManager) {
		if (mainManager == null) {
			throw new IllegalArgumentException();
		}
		this.locationAddressProperty = new SimpleStringProperty();
		this.radiusProperty = new SimpleListProperty<Radius>(FXCollections.observableArrayList(Radius.values()));
		this.selectedRadiusProperty = new SimpleObjectProperty<Radius>();
		this.categoriesProperty = new SimpleStringProperty();
		this.reviewScoreProperty = new SimpleDoubleProperty(1);
		this.currentlyOpenProperty = new SimpleBooleanProperty();
		this.price1Property = new SimpleBooleanProperty();
		this.price2Property = new SimpleBooleanProperty();
		this.price3Property = new SimpleBooleanProperty();
		this.price4Property = new SimpleBooleanProperty();
		this.handicapAccessibleProperty = new SimpleBooleanProperty();
		this.acceptsReservationsProperty = new SimpleBooleanProperty();
		this.newRestaurantsProperty = new SimpleBooleanProperty();
		this.genderNeutralBathroomProperty = new SimpleBooleanProperty();
		this.mainManager = mainManager;
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 */
	public void sendRestaurantQuery() {
		String location = this.locationAddressProperty.getValue();
		int radius = this.selectedRadiusProperty.getValue().getMeters();
		String categories = this.categoriesProperty.getValue();
		double reviewScore = this.reviewScoreProperty.getValue();
		boolean currentlyOpen = this.currentlyOpenProperty.getValue();
		boolean handicapAccessible = this.handicapAccessibleProperty.getValue();
		boolean acceptsReservations = this.acceptsReservationsProperty.getValue();
		boolean hotAndNew = this.newRestaurantsProperty.getValue();
		boolean neutralBathrooms = this.genderNeutralBathroomProperty.getValue();
		List<Price> prices = this.buildPrices();

		RestaurantsQuery query = new RestaurantsQuery(location, radius, categories, reviewScore, prices, currentlyOpen,
				handicapAccessible, acceptsReservations, hotAndNew, neutralBathrooms);
		String response = QueryManager.sendQuery(query);
		List<Restaurant> restaurants = JSONLoader.parseRestaurants(response);
		RestaurantManager theManager = this.mainManager.getRestaurantManager();
		theManager.setTheRestaurants(restaurants);
	}

	private List<Price> buildPrices() {
		boolean price1 = this.price1Property.getValue();
		boolean price2 = this.price2Property.getValue();
		boolean price3 = this.price3Property.getValue();
		boolean price4 = this.price4Property.getValue();

		List<Price> prices = new ArrayList<Price>();
		if (price1) {
			prices.add(Price.$);
		}
		if (price2) {
			prices.add(Price.$$);
		}
		if (price3) {
			prices.add(Price.$$$);
		}
		if (price4) {
			prices.add(Price.$$$$);
		}
		return prices;
	}

	/**
	 * Resets all properties to their respective default values. Empty string for
	 * string properties. 0 for double properties. Radius.FIVE for radius property,
	 * and false for boolean properties.
	 * 
	 * @precondition none
	 * @postcondition all values have been set to their default values.
	 */
	public void resetProperties() {
		if (this.mainManager.getResetFilters()) {
			this.mainManager.setResetFilters(false);
			this.locationAddressProperty.setValue("");
			this.selectedRadiusProperty.setValue(Radius.FIVE);
			this.categoriesProperty.setValue("");
			this.reviewScoreProperty.setValue(1);
			this.currentlyOpenProperty.setValue(false);
			this.price1Property.setValue(false);
			this.price2Property.setValue(false);
			this.price3Property.setValue(false);
			this.price4Property.setValue(false);
			this.handicapAccessibleProperty.setValue(false);
			this.acceptsReservationsProperty.setValue(false);
			this.newRestaurantsProperty.setValue(false);
			this.genderNeutralBathroomProperty.setValue(false);
		}
	}

	/**
	 * Gets the location address property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the location address property.
	 */
	public StringProperty locationAddressProperty() {
		return this.locationAddressProperty;
	}

	/**
	 * Gets the radius property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the radius Fproperty.
	 */
	public ListProperty<Radius> radiusProperty() {
		return this.radiusProperty;
	}

	/**
	 * Gets the categories property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the categories property.
	 */
	public StringProperty categoriesProperty() {
		return this.categoriesProperty;
	}

	/**
	 * Gets the review score property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the review score property.
	 */
	public DoubleProperty reviewScoreProperty() {
		return this.reviewScoreProperty;
	}

	/**
	 * Gets the currently open property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the currently open property.
	 */
	public BooleanProperty currentlyOpenProperty() {
		return this.currentlyOpenProperty;
	}

	/**
	 * Gets the price 1 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 1 property.
	 */
	public BooleanProperty price1Property() {
		return this.price1Property;
	}

	/**
	 * Gets the price 2 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 2 property.
	 */
	public BooleanProperty price2Property() {
		return this.price2Property;
	}

	/**
	 * Gets the price 3 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 3 property.
	 */
	public BooleanProperty price3Property() {
		return this.price3Property;
	}

	/**
	 * Gets the price 4 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 4 property.
	 */
	public BooleanProperty price4Property() {
		return this.price4Property;
	}

	/**
	 * Gets the handicap accessible property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the handicap accessible property.
	 */
	public BooleanProperty handicapAccessibleProperty() {
		return this.handicapAccessibleProperty;
	}

	/**
	 * Gets the accepts reservations property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the accepts reservations property.
	 */
	public BooleanProperty acceptsReservationsProperty() {
		return this.acceptsReservationsProperty;
	}

	/**
	 * Gets the new restaurants property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the new restaurants property.
	 */
	public BooleanProperty newRestaurantsProperty() {
		return this.newRestaurantsProperty;
	}

	/**
	 * Gets the gender neutral bathroom property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the gender neutral bathroom property.
	 */
	public BooleanProperty genderNeutralBathroomProperty() {
		return this.genderNeutralBathroomProperty;
	}

	/**
	 * Gets the selected radius property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the selected radius property.
	 */

	public ObjectProperty<Radius> selectedRadiusProperty() {
		return this.selectedRadiusProperty;
	}

	/**
	 * Gets the Main Manager.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the Main Manager
	 */
	public MainManager getMainManager() {
		return this.mainManager;
	}
}
