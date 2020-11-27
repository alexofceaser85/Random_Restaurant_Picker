package src.viewmodel;

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
import src.model.MainManager;
import src.model.Radius;

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

	public FilterViewModel() {
		this.locationAddressProperty = new SimpleStringProperty();
		this.radiusProperty = new SimpleListProperty<Radius>(FXCollections.observableArrayList(Radius.values()));
		this.selectedRadiusProperty = new SimpleObjectProperty<Radius>();
		this.categoriesProperty = new SimpleStringProperty();
		this.reviewScoreProperty = new SimpleDoubleProperty();
		this.currentlyOpenProperty = new SimpleBooleanProperty();
		this.price1Property = new SimpleBooleanProperty();
		this.price2Property = new SimpleBooleanProperty();
		this.price3Property = new SimpleBooleanProperty();
		this.price4Property = new SimpleBooleanProperty();
		this.handicapAccessibleProperty = new SimpleBooleanProperty();
		this.acceptsReservationsProperty = new SimpleBooleanProperty();
		this.newRestaurantsProperty = new SimpleBooleanProperty();
		this.genderNeutralBathroomProperty = new SimpleBooleanProperty();
	}

	public void setMainManager(MainManager manager) {
		throw new UnsupportedOperationException();
		//TODO Go over with Furichous during meeting
	}

	public void appendRestaurantQuery() {
		throw new UnsupportedOperationException();
		//TODO Go over with Furichous during meeting
	}

	/**
	 * Resets all properties to their respective default values. Empty string for
	 * string properties. 0 for double properties. Radius.FIVE for radius property,
	 * and false for boolean properties.
	 * 
	 * @precondition none
	 * @postcondition all values have been set to their default values.
	 * @param reset whether to reset the properties or not.
	 */
	public void resetProperties(boolean reset) {
		if (reset) {
			this.locationAddressProperty.setValue("");
			this.selectedRadiusProperty.setValue(Radius.FIVE);
			this.categoriesProperty.setValue("");
			this.reviewScoreProperty.setValue(0.0);
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
		return locationAddressProperty;
	}

	/**
	 * Gets the radius property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the radius Fproperty.
	 */
	public ListProperty<Radius> radiusProperty() {
		return radiusProperty;
	}

	/**
	 * Gets the categories property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the categories property.
	 */
	public StringProperty categoriesProperty() {
		return categoriesProperty;
	}

	/**
	 * Gets the review score property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the review score property.
	 */
	public DoubleProperty reviewScoreProperty() {
		return reviewScoreProperty;
	}

	/**
	 * Gets the currently open property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the currently open property.
	 */
	public BooleanProperty currentlyOpenProperty() {
		return currentlyOpenProperty;
	}

	/**
	 * Gets the price 1 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 1 property.
	 */
	public BooleanProperty price1Property() {
		return price1Property;
	}

	/**
	 * Gets the price 2 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 2 property.
	 */
	public BooleanProperty price2Property() {
		return price2Property;
	}

	/**
	 * Gets the price 3 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 3 property.
	 */
	public BooleanProperty price3Property() {
		return price3Property;
	}

	/**
	 * Gets the price 4 property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the price 4 property.
	 */
	public BooleanProperty price4Property() {
		return price4Property;
	}

	/**
	 * Gets the handicap accessible property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the handicap accessible property.
	 */
	public BooleanProperty handicapAccessibleProperty() {
		return handicapAccessibleProperty;
	}

	/**
	 * Gets the accepts reservations property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the accepts reservations property.
	 */
	public BooleanProperty acceptsReservationsProperty() {
		return acceptsReservationsProperty;
	}

	/**
	 * Gets the new restaurants property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the new restaurants property.
	 */
	public BooleanProperty newRestaurantsProperty() {
		return newRestaurantsProperty;
	}

	/**
	 * Gets the gender neutral bathroom property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the gender neutral bathroom property.
	 */
	public BooleanProperty genderNeutralBathroomProperty() {
		return genderNeutralBathroomProperty;
	}

	/**
	 * Gets the selected radius property.
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the selected radius property.
	 */

	public ObjectProperty<Radius> getSelectedRadiusProperty() {
		return selectedRadiusProperty;
	}

}
