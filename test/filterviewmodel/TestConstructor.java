package test.filterviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.viewmodel.FilterViewModel;

class TestConstructor {

	@Test
	void testValidData() {
		MainManager manager = new MainManager(null);
		FilterViewModel viewModel = new FilterViewModel(manager);
		assertNotNull(viewModel.acceptsReservationsProperty());
		assertNotNull(viewModel.categoriesProperty());
		assertNotNull(viewModel.currentlyOpenProperty());
		assertNotNull(viewModel.genderNeutralBathroomProperty());
		assertNotNull(viewModel.handicapAccessibleProperty());
		assertNotNull(viewModel.locationAddressProperty());
		assertNotNull(viewModel.newRestaurantsProperty());
		assertNotNull(viewModel.price1Property());
		assertNotNull(viewModel.price2Property());
		assertNotNull(viewModel.price3Property());
		assertNotNull(viewModel.price4Property());
		assertNotNull(viewModel.radiusProperty());
		assertNotNull(viewModel.reviewScoreProperty());
		assertNotNull(viewModel.selectedRadiusProperty());
		assertEquals(manager, viewModel.getMainManager());
	}

}
