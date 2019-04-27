import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class BagOfWordsTest {

	/**
	 * Test 
	 */
	@Test
	public void testType(){
		Event e1 = new BagOfWords();
		Event e2 = new FlashCard();
		
		assertTrue(e1.type().equals("bag"));
		assertFalse(e2.type().equals("bag"));
	}
	
	@Test
	public void testGetBag(){
		BagOfWords e1 = new BagOfWords();
		Word w1 = new Word("a","fruit",5);
		w1.getTextSources().add(1);
		w1.getTextSources().add(2);
		w1.getTextSources().add(3);
		//System.out.print(w1.getTextSources().size());
		Word w2 = new Word("b","drink",10);
		w2.getTextSources().add(1);
		w2.getTextSources().add(2);
		w2.getTextSources().add(3);
		Word w3 = new Word("c","drink",13);
		w3.getTextSources().add(1);
		w3.getTextSources().add(2);
		w3.getTextSources().add(3);
		Word w4 = new Word("d","container",7);
		w4.getTextSources().add(4);
		Word w5 = new Word("e","fds",7);
		w5.getTextSources().add(4);
		Word w6 = new Word("f","fruit",5);
		w6.getTextSources().add(6);
		Word w7 = new Word("g","drink",10);
		w7.getTextSources().add(5);
		Word w8 = new Word("h","drink",13);
		w8.getTextSources().add(7);
		Word w9 = new Word("i","container",7);
		w9.getTextSources().add(8);
		Word w10 = new Word("j","fds",7);
		w10.getTextSources().add(9);
		Word w11 = new Word("k","fruit",5);
		w11.getTextSources().add(9);
		Word w12 = new Word("l","drink",10);
		w12.getTextSources().add(9);
		Word w13 = new Word("m","drink",13);
		w13.getTextSources().add(9);
		Word w14 = new Word("n","container",7);
		w14.getTextSources().add(10);
		Word w15 = new Word("o","fds",7);
		w15.getTextSources().add(11);
		Word w16 = new Word("p","fruit",5);
		w16.getTextSources().add(12);
		Word w17 = new Word("q","drink",10);
		w17.getTextSources().add(13);
		Word w18 = new Word("r","drink",13);
		w18.getTextSources().add(14);
		System.out.print(w18.getWord() + w18.getTextSources().size());
		Word w19 = new Word("s","container",7);
		w19.getTextSources().add(15);
		Word w20 = new Word("t","fds",7);
		w20.getTextSources().add(16);
		Word w21 = new Word("u","fds",7);
		w21.getTextSources().add(17);
		Word w22 = new Word("v","fruit",5);
		w22.getTextSources().add(18);
		Word w23 = new Word("w","drink",13);
		w23.getTextSources().add(19);
		Word w24 = new Word("x","container",7);
		w24.getTextSources().add(20);
		Word w25 = new Word("y","fds",7);
		w25.getTextSources().add(21);
		Word w26 = new Word("z","fruit",5);
		w26.getTextSources().add(22);
		Word w27 = new Word("aa","drink",10);
		w27.getTextSources().add(23);
		Word w28 = new Word("bb","drink",13);
		w28.getTextSources().add(24);
		Word w29 = new Word("cc","container",7);
		w29.getTextSources().add(9);
		Word w30 = new Word("dd","fds",7);
		w30.getTextSources().add(10);
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
		Set<Word> bagOfWord = e1.getBag(2);
		System.out.print(bagOfWord.size());
	}
	
//	@Test
//	public void testhelper() {
//		Set<IWord> setOfWord = new HashSet<IWord>();
//		Word w1 = new Word("a","fruit",5);
//		Word w2 = new Word("b","drink",10);
//		Word w3 = new Word("c","drink",13);
//		Word w4 = new Word("d","container",7);
//		Word w5 = new Word("e","fds",7);
//		Word w6 = new Word("f","fruit",5);
//		Word w7 = new Word("g","drink",10);
//		Word w8 = new Word("h","drink",13);
//		Word w9 = new Word("i","container",7);
//		Word w10 = new Word("j","fds",7);
//		Word w11 = new Word("k","fruit",5);
//		Word w12 = new Word("l","drink",10);
//		Word w13 = new Word("m","drink",13);
//		Word w14 = new Word("n","container",7);
//		Word w15 = new Word("o","fds",7);
//		Word w16 = new Word("p","fruit",5);
//		Word w17 = new Word("q","drink",10);
//		Word w18 = new Word("r","drink",13);
//		Word w19 = new Word("s","container",7);
//		Word w20 = new Word("t","fds",7);
//		Word w21 = new Word("u","fds",7);
//		Word w22 = new Word("v","fruit",5);
//		Word w23 = new Word("w","drink",13);
//		Word w24 = new Word("x","container",7);
//		Word w25 = new Word("y","fds",7);
//		Word w26 = new Word("z","fruit",5);
//		Word w27 = new Word("aa","drink",10);
//		Word w28 = new Word("bb","drink",13);
//		Word w29 = new Word("cc","container",7);
//		Word w30 = new Word("dd","fds",7);
//		setOfWord.add(w4);
//		setOfWord.add(w3);
//		setOfWord.add(w2);
//		setOfWord.add(w1);
//		setOfWord.add(w5);
//		setOfWord.add(w6);
//		setOfWord.add(w7);
//		setOfWord.add(w8);
//		setOfWord.add(w9);
//		setOfWord.add(w10);
//		setOfWord.add(w11);
//		setOfWord.add(w13);
//		setOfWord.add(w12);
//		setOfWord.add(w14);
//		setOfWord.add(w15);
//		setOfWord.add(w16);
//		setOfWord.add(w17);
//		setOfWord.add(w18);
//		setOfWord.add(w19);
//		setOfWord.add(w20);
//		setOfWord.add(w24);
//		setOfWord.add(w23);
//		setOfWord.add(w22);
//		setOfWord.add(w21);
//		setOfWord.add(w25);
//		setOfWord.add(w26);
//		setOfWord.add(w27);
//		setOfWord.add(w28);
//		setOfWord.add(w29);
//		setOfWord.add(w30);
//		BagOfWords e1 = new BagOfWords();
//		
//		Set<HashSet<IWord>> key = new HashSet<HashSet<IWord>>();
//		HashSet<IWord> currentSet = new HashSet<IWord>();
//		e1.generateBag(setOfWord, 4, key, currentSet);
//
//	}
 
	

}
