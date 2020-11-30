package src.view;

import src.controller.SceneController;
/**
 * Abstract class for all SceneController CodeBehinds.
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public abstract class BaseCodeBehind {
	private SceneController controller;

	/**
	 * Returns the scene controller.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @return controller The SceneController
	 */
	public SceneController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller to a SceneController.
	 * 
	 * @precondition none
	 * @postcondition getController() == controller
	 * @param controller The SceneController.
	 */
	public void setController(SceneController controller) {
		this.controller = controller;
	}
	
}