import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class BagOfWordsTest {

	@Test
	public void testType(){
		Event e1 = new BagOfWords();
		Event e2 = new FlashCard();
		
		assertTrue(e1.type().equals("bag"));
		assertFalse(e2.type().equals("bag"));
	}
	
	@Test
	public void testCreateDataStructure(){
		Event e1 = new BagOfWords();
		Word word1 = new Word("a", "lalala", 4);
		Word word2 = new Word("b", "lalala", 5);
		Word word3 = new Word("c", "lalala", 5);
		List<IWord> l1= new ArrayList<IWord>();
		l1.add(word1);
		l1.add(word2);
		l1.add(word3);
		assertTrue(e1.createDataStructure(l1));
	}
	
	@Test
	public void testGetBag(){
		BagOfWords e1 = new BagOfWords();
		Word word1 = new Word("a", "lalala", 4);
		Word word2 = new Word("b", "lalala", 5);
		Word word3 = new Word("c", "lalala", 5);
		List<IWord> l1= new ArrayList<IWord>();
		l1.add(word1);
		l1.add(word2);
		l1.add(word3);
		e1.createDataStructure(l1);
		Set<String> s1 = new HashSet<String>();
		s1.add("a");
		assertEquals(e1.getBag(1),s1);
	}

}
