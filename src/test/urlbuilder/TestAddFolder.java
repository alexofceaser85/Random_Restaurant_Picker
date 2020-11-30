/**
 * 
 */
package src.test.urlbuilder;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import src.data.URLBuilder;

/**
 *
 * @author Furichous Jones IV
 * @version Fall 2020
 */
class TestAddFolder {
	private URLBuilder testURLBuilder;
	@BeforeEach
	void SetupURLBuilder() {
		this.testURLBuilder = new URLBuilder("maps.google.com","https");
	}
	
	@Test
	void TestValidFolder() {
		this.testURLBuilder.addFolder("folder1");
			assertEquals("/folder1",testURLBuilder.getURL().getPath());
	}
	
	@Test
	void TestValidFolders() {
		this.testURLBuilder.addFolder("folder1");
		this.testURLBuilder.addFolder("folder2");
			assertEquals("/folder1/folder2",testURLBuilder.getURL().getPath());
	}
	
	@Test
	void TestNullFolder() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testURLBuilder.addFolder(null);
		});
	}
	@Test
	void TestBlankFolder() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			this.testURLBuilder.addFolder("");
		});
	}
}
