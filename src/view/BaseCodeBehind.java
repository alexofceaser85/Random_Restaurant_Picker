package src.view;

import src.controller.SceneController;

public abstract class BaseCodeBehind {
	private SceneController controller;

	public SceneController getController() {
		return this.controller;
	}

	public void setController(SceneController controller) {
		this.controller = controller;
	}

	public abstract void onActivation();
	
}