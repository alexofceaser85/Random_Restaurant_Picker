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
 */
public class SceneController {
	private HashMap<String, Pair<Scene, BaseCodeBehind>> pages;
	private Stage primaryStage;

	/**
	 * @precondition none
	 * @postcondition none
	 * @param primaryStage
	 */
	public SceneController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.pages = new HashMap<String, Pair<Scene, BaseCodeBehind>>();
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param key
	 * @param loader
	 */
	public void add(String key, FXMLLoader loader) {
		Scene scene = new Scene(loader.getRoot());
		BaseCodeBehind codeBehind = (BaseCodeBehind) loader.getController();
		codeBehind.setController(this);
		Pair<Scene, BaseCodeBehind> page = new Pair<Scene, BaseCodeBehind>(scene, codeBehind);
		this.pages.put(key, page);
	}

	/**
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param key
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
	 * 
	 * @precondition none
	 * @postconditon none
	 *
	 * @param key
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