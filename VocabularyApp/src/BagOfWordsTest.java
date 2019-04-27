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
	
	@Test
	public void testhelper() {
		Set<IWord> setOfWord = new HashSet<IWord>();
		Word w1 = new Word("apple","fruit",5);
		Word w2 = new Word("milk","drink",10);
		Word w3 = new Word("cola","drink",13);
		Word w4 = new Word("bag","container",7);
		Word w5 = new Word("flag","fds",7);
		setOfWord.add(w4);
		setOfWord.add(w3);
		setOfWord.add(w2);
		setOfWord.add(w1);
		setOfWord.add(w5);
		BagOfWords e1 = new BagOfWords();
		Set<HashSet<IWord>> key = new HashSet<HashSet<IWord>>();
		HashSet<IWord> currentSet = new HashSet<IWord>();
		e1.generateBag(setOfWord, 2, key, currentSet);
		for(HashSet<IWord> i: key) {
			for(IWord w: i) {
				System.out.print(w.getWord());
				System.out.print("  ");
			}
			System.out.print("\n");
		}
	}
 
	

}
