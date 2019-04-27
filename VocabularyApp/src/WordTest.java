import static org.junit.Assert.*;

import org.junit.Test;

public class WordTest {
	
	/**
	 * Test for update time stamp
	 */
	@Test
	public void testUpdateTimeStamp() {
		Word word1 = new Word("a", "lalala", 4);
		word1.updateFeedback(1);
		word1.updateTimeStamp();
		assertEquals(word1.getTimeStamp(), 2);
	}
	
	/**
	 * test for updateFeedback
	 */
	@Test
	public void testUpdateFeedback() {
		Word word1 = new Word("a", "lalala", 4);
		word1.updateFeedback(1);
		assertEquals(word1.getWeight(), 8.0 / 3, 0.000000001);
	}
	/**
	 * test for updateWeight
	 */
	@Test
	public void testUpdateWeight() {
		Word word1 = new Word("a", "lalala", 4);
		word1.updateWeight(0.22);
		assertEquals(word1.getWeight(), 0.22, 0.000000001);
	}
	/**
	 * test for compareTo
	 */
	@Test
	public void testCompareTo() {
		Word word1 = new Word("a", "lalala", 4);
		Word word2 = new Word("b", "lalala", 5);
		Word word3 = new Word("c", "lalala", 5);
		assertEquals(word1.compareTo(word2), 1);
		assertEquals(word2.compareTo(word3), 0);
		assertEquals(word2.compareTo(word1), -1);
	}
	/**
	 * test for getTextSources
	 */
	@Test
	public void testGetTextSources() {
		Word word1 = new Word("a", "lalala", 4);
		assertTrue(word1.getTextSources().isEmpty());
		word1.addSource(1);
		word1.addSource(2);
		assertTrue(word1.getTextSources().contains(1));
		assertTrue(word1.getTextSources().contains(2));
		
	}
	/**
	 * test for update time, getters and setters
	 */
	@Test
	public void testUpdateTime() {
		Word word1 = new Word("a", "lalala", 3);
		word1.getTime();
		word1.updateTime();
		word1.updateFeedback(0);
		assertEquals(word1.getWeight(), 4.0, 0.000000001);
		word1.updateFeedback(1);
		word1.updateFeedback(33);
		assertEquals(word1.getWeight(), 3.0, 0.000000001);
		assertEquals(word1.getFreq(),3);
		assertEquals(word1.getWord(),"a");
		assertEquals(word1.getDefinition(),"lalala");
		word1.setDefinition("qwer");
		assertEquals(word1.getDefinition(),"qwer");
	}

}
