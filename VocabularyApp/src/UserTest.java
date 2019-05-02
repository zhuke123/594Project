import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserTest {
	/**
	 * test for compareTo
	 */
	@Test
	public void testCompareTo() {
		User user1 = new User("a");
		user1.setWordCount(10);
		User user2 = new User("b");
		user2.setWordCount(20);
		User user3 = new User("c");
		user3.setWordCount(20);
		assertTrue(user1.getUsername().equals("a"));
		assertTrue(user1.compareTo(user2) > 0);
		assertTrue(user2.compareTo(user3) == 0);
		assertTrue(user2.compareTo(user1) < 0);
		
	}
	/**
	 * test for flashCard
	 */
	@Test
	public void testFlashCard() {
		User user1 = new User("a");
		IFlashCard fl = new FlashCard();
		user1.setFlashCard(fl);
		List<IWord> list = new ArrayList<IWord>();
		list.add(new Word("aa","bb",3));
		user1.getFlashCard().createDataStructure(list);
		assertEquals(user1.getFlashCard().getFlashCard().getWord(),"aa");
	}
	
	/**
	 * test for bagofwords
	 */
	@Test
	public void testBagOfWords() {
		User user1 = new User("a");
		IBagOfWords bag = new BagOfWords();
		user1.setBagOfWords(bag);
		List<IWord> list = new ArrayList<IWord>();
		Word a = new Word("aa","bb",3);
		list.add(a);
		user1.getBagOfWords().createDataStructure(list);
		
	}

}
