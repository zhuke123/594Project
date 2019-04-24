import static org.junit.Assert.*;

import org.junit.Test;

class IRankTest {

	@Test
	void testShowAllRank() {
		Rank rank = new Rank();
		IUser user1 = new User("user1");
		IUser user2 = new User("user2");
		IUser user3 = new User("user3");
		rank.addUser(user1);
		rank.addUser(user2);
		rank.addUser(user3);
		user1.setWordCount(10);
		user2.setWordCount(20);
		user3.setWordCount(30);
		rank.showAllRank();
	}

	@Test
	void testSearchRank() {
		Rank rank = new Rank();
		IUser user1 = new User("user1");
		IUser user2 = new User("user2");
		IUser user3 = new User("user3");
		user1.setWordCount(10);
		user2.setWordCount(20);
		user3.setWordCount(30);
		rank.searchRank(user1);
		user1.setWordCount(user1.getWordCount() + 1);
		rank.searchRank(user1);
		
	}

	@Test
	void testUpdateRank() {
		Rank rank = new Rank();
		IUser user1 = new User("user1");
		IUser user2 = new User("user2");
		IUser user3 = new User("user3");
		user1.setWordCount(10);
		user2.setWordCount(20);
		user3.setWordCount(30);
		rank.showAllRank();
		user1.setWordCount(user1.getWordCount() + 1);
		rank.updateRank(user1);
		rank.showAllRank();
	}

}
