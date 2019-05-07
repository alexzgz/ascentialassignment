package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import demo.CustomNumberEntity;
import demo.ListCustomNumberEntityChecker;


public class ListCustomNumberEntityCheckerTest {

	private static final String PATH = "/home/ale/Escritorio/ej.json"; 
	@Test
	public void testIsInList() {
		ListCustomNumberEntityChecker checker = new ListCustomNumberEntityChecker();
		List<CustomNumberEntity> list = checker.readFromFile(PATH);
        assertTrue(checker.contains(45, list));
	}

	
	@Test
	public void testIsNotInList() {
		ListCustomNumberEntityChecker checker = new ListCustomNumberEntityChecker();
		List<CustomNumberEntity> list = checker.readFromFile(PATH);
        assertFalse(checker.contains(495, list));
	}

	// We tried to run into the array list, and it lasted 37 seconds
	// We tried to use the map, and it lasted 6 seconds
	
	
}
