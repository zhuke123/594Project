import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class FlashCardTest {

	@Test
	public void testType() {
		FlashCard fc = new FlashCard();
		assertEquals(fc.type(),"flashcard");
	}

	@Test
	public void testCreateDataStructure() {
		Word word1 = new Word("a",1);
		Word word2 = new Word("b",2);
		Word word3 = new Word("c",3);
		Word word4 = new Word("d",4);
		Word word5 = new Word("e",5);
		Word word6 = new Word("f",6);
		Word word7 = new Word("g",7);
		Word word8 = new Word("h",8);
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
		assertEquals(fc.getFlashCard(),word8);
		assertEquals(fc.getFlashCard(),word7);
		word8.updateWeight(9.2);
		fc.insert(word8);
		assertEquals(fc.getFlashCard(),word8);
		
	}
	
}
