package src.view;

import src.controller.SceneController;
/**
 * Abstract class for all SceneController CodeBehinds
 * @author Furichous Jones IV
 */
public abstract class BaseCodeBehind {
	private SceneController controller;

	/**
	 * Returns the scene controller 
	 * @return controller The SceneController
	 */
	public SceneController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller to a SceneController
	 * @param controller The SceneController
	 */
	public void setController(SceneController controller) {
		this.controller = controller;
	}
	
}