import static org.junit.Assert.*;

import org.junit.Test;

import java.util.*;

public class DictionaryTest {

	@Test
	public void testGetWords() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		List<IWord> words = dict.getWords();
		assertEquals(words.size(), 5375);
	}

	@Test
	public void testReadFile() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		assertFalse(dict.readFile("sda"));		
	}

	@Test
	public void testHandleRequest() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		FlashCard card = new FlashCard();
		assertTrue(dict.handleRequest(card));
		BagOfWords bag = new BagOfWords();
		assertTrue(dict.handleRequest(bag));
	}

}
