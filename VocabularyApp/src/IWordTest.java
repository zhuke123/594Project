import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IWordTest {

	@Test
	void testUpdateTimeStamp() {
		Word word1 = new Word("a", 1, 4);
		word1.updateFeedback(1);
		word1.updateTimeStamp();
		assertEquals(word1.getTimeStamp(), 2);
	}

	@Test
	void testUpdateFeedback() {
		Word word1 = new Word("a", 1, 4);
		word1.updateFeedback(1);
		assertEquals(word1.getWeight(), 8 / 3, 0.000000001);
	}

	@Test
	void testUpdateWeight() {
		Word word1 = new Word("a", 1, 4);
		word1.updateFeedback(1);
		assertEquals(word1.getWeight(), 8 / 3, 0.000000001);
	}

}
