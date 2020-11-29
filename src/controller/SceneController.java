package src.controller;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import src.view.BaseCodeBehind;
/**
 * Class for activating and showing registered scenes.
 * @author Furichous Jones IV
 */
public class SceneController {
	private HashMap<String,Pair<Scene,BaseCodeBehind>> pages;
	private Stage primaryStage;
	
	public SceneController(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.pages = new HashMap<String,Pair<Scene,BaseCodeBehind>>();
	}
	
	public void add(String key, FXMLLoader loader) {		
		Scene scene = new Scene(loader.getRoot());
		BaseCodeBehind codeBehind = (BaseCodeBehind) loader.getController();
		codeBehind.setController(this);
		Pair<Scene,BaseCodeBehind> page = new Pair<Scene,BaseCodeBehind>(scene, codeBehind);
		pages.put(key, page);
	}
	
	public void activate(String key) {
		Pair<Scene,BaseCodeBehind> page = pages.get(key);
		if (page != null) {
			Activatable codeBehind = (Activatable) page.getValue();
			codeBehind.onActivation();
			this.show(key);
		}
	}
	public void show(String key) {
		Pair<Scene,BaseCodeBehind> page = pages.get(key);
		if (page != null) {
			Scene scene = page.getKey();
			primaryStage.setScene(scene);
			primaryStage.show();
		}
	}
	
}