package test.filterviewmodel;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import src.model.MainManager;
import src.model.Radius;
import src.viewmodel.FilterViewModel;

class TestResetProperties {

	@Test
	void testFalseReset() {
		FilterViewModel viewModel = new FilterViewModel(new MainManager(null));
		viewModel.selectedRadiusProperty().set(Radius.TEN);
		viewModel.getMainManager().setResetFilters(false);
		viewModel.resetProperties();
		
		assertEquals(Radius.TEN, viewModel.selectedRadiusProperty().getValue());
	}
	
	@Test
	void testTrueReset() {
		FilterViewModel viewModel = new FilterViewModel(new MainManager(null));
		viewModel.selectedRadiusProperty().set(Radius.TEN);
		viewModel.getMainManager().setResetFilters(true);
		viewModel.resetProperties();
		
		assertEquals(Radius.FIVE, viewModel.selectedRadiusProperty().getValue());
	}

}
