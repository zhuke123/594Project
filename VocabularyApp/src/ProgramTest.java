import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class ProgramTest {
	
	public Program m = new Program("Dictionary.txt");

	@Test
	public void testGetUsers() {
		assertTrue(m.getUsers() != null);
	}

	@Test
	public void testGetRank() {
		assertTrue(m.getRank() != null);
	}

	@Test
	public void testGetUserString() {
		assertTrue(m.getUser("ds") == null);
	}

	@Test
	public void testGetUserInt() {
		assertTrue(m.getUser(2) == null);
	}

	@Test
	public void testGetDict() {
		assertTrue(m.getDict() != null);
	}
	
	@Test
	public void testAddUsers() {
		assertFalse(m.addUsers("dsa"));
	}

}
