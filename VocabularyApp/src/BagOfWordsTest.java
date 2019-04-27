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
		Word w1 = new Word("apple","fruit",5);
		Word w2 = new Word("milk","drink",10);
		Word w3 = new Word("cola","drink",13);
		Word w4 = new Word("bag","container",7);
		Word w5 = new Word("flag","fds",7);
		Word w6 = new Word("aapple","fruit",5);
		Word w7 = new Word("midlk","drink",10);
		Word w8 = new Word("cofla","drink",13);
		Word w9 = new Word("basg","container",7);
		Word w10 = new Word("flafg","fds",7);
		Word w11 = new Word("apple","fruit",5);
		Word w12 = new Word("milk","drink",10);
		Word w13 = new Word("cola","drink",13);
		Word w14 = new Word("bag","container",7);
		Word w15 = new Word("flag","fds",7);
		Word w16 = new Word("aapple","fruit",5);
		Word w17 = new Word("midlk","drink",10);
		Word w18 = new Word("cofla","drink",13);
		Word w19 = new Word("basg","container",7);
		Word w20 = new Word("flafg","fds",7);
		Word w21 = new Word("flafg","fds",7);
		Word w22 = new Word("apple","fruit",5);
		Word w23 = new Word("cola","drink",13);
		Word w24 = new Word("bag","container",7);
		Word w25 = new Word("flag","fds",7);
		Word w26 = new Word("aapple","fruit",5);
		Word w27 = new Word("midlk","drink",10);
		Word w28 = new Word("cofla","drink",13);
		Word w29 = new Word("basg","container",7);
		Word w30 = new Word("flafg","fds",7);
		List<IWord> l1= new ArrayList<IWord>();
		l1.add(w1);
		l1.add(w2);
		l1.add(w3);
		l1.add(w4);
		l1.add(w5);
		l1.add(w6);
		l1.add(w7);
		l1.add(w8);
		l1.add(w9);
		l1.add(w10);
		l1.add(w11);
		l1.add(w12);
		l1.add(w13);
		l1.add(w14);
		l1.add(w15);
		l1.add(w16);
		l1.add(w17);
		l1.add(w18);
		l1.add(w19);
		l1.add(w20);
		l1.add(w21);
		l1.add(w22);
		l1.add(w23);
		l1.add(w24);
		l1.add(w25);
		l1.add(w26);
		l1.add(w27);
		l1.add(w28);
		l1.add(w29);
		l1.add(w30);
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
	}
 
	

}
