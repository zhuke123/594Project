import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class ProgramTest {
	
	public Program m = new Program("Dictionary.txt");
	
	/**
	 * test for get users, getUsers()
	 */
	@Test
	public void testGetUsers() {
		assertTrue(m.getUsers() != null);
	}
	
	/**
	 * test for get users rank, getRank()
	 */
	@Test
	public void testGetRank() {
		assertTrue(m.getRank() != null);
	}

	/**
	 * test for get users rank, getUsername()
	 */
	@Test
	public void testGetUserString() {
		assertTrue(m.getUser("ds") == null);
		assertTrue(m.addUsers("dsa"));
		assertTrue(m.getUser("dsa").getUsername().equals("dsa"));
	}

	/**
	 * test for get users rank, getUsers(String username)
	 */
	@Test
	public void testGetUserInt() {
		assertTrue(m.addUsers("dsa"));
		assertTrue(m.getUser(0).getUsername().equals("dsa"));
		assertTrue(m.getUser(2) == null);
	}

	/**
	 * test for get users rank, getDict()
	 */
	@Test
	public void testGetDict() {
		assertTrue(m.getDict() != null);
	}

	/**
	 * test for get users rank, addUsers()
	 */
	@Test
	public void testAddUsers() {
		assertTrue(m.addUsers("dsa"));
		assertFalse(m.addUsers("dsa"));
		assertFalse(m.addUsers(null));
	}

}
