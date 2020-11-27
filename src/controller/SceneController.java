package src.controller;

import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Pair;
import src.view.BaseCodeBehind;

public class SceneController {
	private HashMap<String,Pair<Scene,BaseCodeBehind>> pages;
	private Stage primaryStage;
	
	public SceneController(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}
	
	public boolean add(String key, String resourcePath) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SceneController.class.getClassLoader().getResource(resourcePath));
			loader.load();
			
			Scene scene = new Scene(loader.getRoot());
			BaseCodeBehind codeBehind = (BaseCodeBehind) loader.getController();
			codeBehind.setController(this);
			Pair<Scene,BaseCodeBehind> page = new Pair<Scene,BaseCodeBehind>(scene, codeBehind);
			
			pages.put(key, page);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void activate(String key) {
		Pair<Scene,BaseCodeBehind> page = pages.get(key);
		BaseCodeBehind codeBehind = page.getValue();
		Scene scene = page.getKey();
		codeBehind.onActivation();
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}