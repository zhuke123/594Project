import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.*;

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
