import static org.junit.Assert.*;

import org.junit.Test;

public  class RankTest {

	@Test
	public void testShowAllRank() {
		System.out.println("show all rank");
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
	public  void testSearchRank() {
		System.out.println("search rank");
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
		rank.searchRank("user1");
		user1.setWordCount(user1.getWordCount() + 1);
		rank.searchRank("user1");
		
	}

	@Test
	public  void testUpdateRank() {
		System.out.println("update rank");
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
		user1.setWordCount(user1.getWordCount() + 1);
		rank.updateRank(user1);
		rank.showAllRank();
	}

}
