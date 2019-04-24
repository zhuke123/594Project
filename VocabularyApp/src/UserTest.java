import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	void testCompareTo() {
		User user1 = new User("a");
		user1.setWordCount(10);
		User user2 = new User("b");
		user2.setWordCount(20);
		User user3 = new User("c");
		user3.setWordCount(20);
		
		assertTrue(user1.compareTo(user2) < 0);
		assertTrue(user2.compareTo(user3) == 0);
		assertTrue(user2.compareTo(user1) > 0);
		
	}

}
