import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

class DictionaryTest {

	@Test
	void testGetWords() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		List<IWord> words = dict.getWords();
		assertEquals(words.size(), 5375);
	}

	@Test
	void testReadFile() {
		Dictionary dict = new Dictionary("Dictionary.txt");
		assertFalse(dict.readFile("sda"));		
	}

	@Test
	void testHandleRequest() {
		fail("Not yet implemented");
	}

}
