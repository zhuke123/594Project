import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public  class RankTest {
	/**
	 * test for show all rank and different constructors
	 */
	@Test
	public void testShowAllRank() {
		System.out.println("show all rank");
		
		IUser user1 = new User("user1");
		IUser user2 = new User("user2");
		IUser user3 = new User("user3");
		List<IUser> usersList = new ArrayList<IUser>();
		usersList.add(user1);
		usersList.add(user1);
		usersList.add(user2);
		usersList.add(user3);
		Rank rank = new Rank(usersList);
		
		user1.setWordCount(10);
		user2.setWordCount(20);
		user3.setWordCount(30);
	}
	
	/**
	 * test for search rank
	 */
	@Test
	public  void testSearchRank() {
		System.out.println("search rank");
		Rank rank = new Rank();
		IUser user1 = new User("user1");
		IUser user2 = new User("user2");
		IUser user3 = new User("user3");
		rank.addUser(user1);
		rank.addUser(user1);
		rank.addUser(user2);
		rank.addUser(user3);
		user1.setWordCount(10);
		user2.setWordCount(20);
		user3.setWordCount(30);
		user1.setWordCount(user1.getWordCount() + 1);
		
	}
	
	/**
	 * test for update rank
	 */
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
		user1.setWordCount(user1.getWordCount() + 1);
		rank.updateRank(user1);

	}
	@Test
	public  void testGetRank() {
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
		assertEquals(rank.getRank(1),"user3");
		assertEquals(rank.getRank(2),"user2");
		assertEquals(rank.getRank(3),"user1");
		user1.setWordCount(40);
		assertEquals(rank.getRank(1),"user1");
		assertEquals(rank.getRank("user1"),1);
		assertEquals(rank.getRank("user3"),2);
		assertEquals(rank.getRank(-1),"no such user");
		assertEquals(rank.getRank("acsd"),-1);
	}
	

}
