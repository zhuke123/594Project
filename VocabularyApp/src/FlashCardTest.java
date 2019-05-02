import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FlashCardTest {

	/**
	 * test for the event type of the flash-card
	 */
	@Test
	public void testType() {
		FlashCard fc = new FlashCard();
		assertEquals(fc.type(),"flashcard");
	}

	/**
	 * test for initiate the flash-card event
	 */
	@Test
	public void testCreateDataStructure() {
		Word word1 = new Word("a","def",1);
		Word word2 = new Word("b","def",2);
		Word word3 = new Word("c","def",3);
		Word word4 = new Word("d","def",4);
		Word word5 = new Word("e","def",5);
		Word word6 = new Word("f","def",6);
		Word word7 = new Word("g","def",7);
		Word word8 = new Word("h","def",8);
		ArrayList<IWord> wordList = new ArrayList<IWord>();
		wordList.add(word1);
		wordList.add(word2);
		wordList.add(word3);
		wordList.add(word4);
		wordList.add(word5);
		wordList.add(word6);
		wordList.add(word7);
		wordList.add(word8);
		FlashCard fc = new FlashCard();
		fc.createDataStructure(wordList);
		assertEquals(fc.getFlashCard().getWord(),word8.getWord());
		assertEquals(fc.getFlashCard(),word7);
		word8.updateWeight(9.2);
		fc.insert(word8);
		assertEquals(fc.getFlashCard(),word8);
	}
	
	/**
	 * test for exception
	 */
	@Test(expected = NullPointerException.class)
		public void testNull(){
		FlashCard fc = new FlashCard();
		ArrayList<IWord> wordList = null;
		fc.createDataStructure(wordList);
	}
	
	
}
