import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IRankTest {

	@Test
	void testShowAllRank() {
		Rank rank = new Rank();
		IUser user1 = new User("user1");
		IUser user2 = new User("user2");
		IUser user3 = new User("user3");
		rank.showAllRank();
	}

	@Test
	void testSearchRank() {
		Rank rank = new Rank();
		IUser user1 = new User("user1");
		IUser user2 = new User("user2");
		IUser user3 = new User("user3");
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
		rank.showAllRank();
		user1.setWordCount(user1.getWordCount() + 1);
		rank.showAllRank();
	}

}
