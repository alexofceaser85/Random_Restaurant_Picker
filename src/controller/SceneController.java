package src.controller;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import src.view.BaseCodeBehind;

/**
 * Class for activating and showing registered scenes.
 * 
 * @author Furichous Jones IV
 * @version Fall 2020
 */
public class SceneController {
	private HashMap<String, Pair<Scene, BaseCodeBehind>> pages;
	private Stage primaryStage;

	/**
	 * One-parameter constructor.
	 * 
	 * @precondition none
	 * @postcondition none
	 * 
	 * @param primaryStage the stage to be displayed primarily.
	 */
	public SceneController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.pages = new HashMap<String, Pair<Scene, BaseCodeBehind>>();
	}

	/**
	 * Adds a new scene to the collection.
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param key name of the scene being added
	 * @param loader the loader containing the fxml for the scene.
	 */
	public void add(String key, FXMLLoader loader) {
		Scene scene = new Scene(loader.getRoot());
		BaseCodeBehind codeBehind = (BaseCodeBehind) loader.getController();
		codeBehind.setController(this);
		Pair<Scene, BaseCodeBehind> page = new Pair<Scene, BaseCodeBehind>(scene, codeBehind);
		this.pages.put(key, page);
	}

	/**
	 * Sets the scene and then shows it on the GUI.
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param key name of the scene being activated.
	 */
	public void activate(String key) {
		Pair<Scene, BaseCodeBehind> page = this.pages.get(key);
		if (page != null) {
			Activatable codeBehind = (Activatable) page.getValue();
			codeBehind.onActivation();
			this.show(key);
		}
	}

	/**
	 * Shows the selected scene to the GUI.
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param key the name of the scene being shown.
	 */
	public void show(String key) {
		Pair<Scene, BaseCodeBehind> page = this.pages.get(key);
		if (page != null) {
			Scene scene = page.getKey();
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		}
	}

}