import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dictionary implements IDictionary {
	
	List<IWord> wordList;
	
	public Dictionary(String filename) {
		wordList = new ArrayList<>();
		if(readFile(filename)) {
			System.out.println("Successfully create a dictionary");
		}
	}

	@Override
	public List<IWord> getWords() {
		return wordList;
	}

	@Override
	public boolean readFile(String filename) {
		try {
			BufferedReader b = new BufferedReader(new FileReader(filename));
			String line;
			while((line = b.readLine()) != null) {
				String word = line;
				String def = b.readLine();
				int freq = Integer.parseInt(b.readLine());					
				Word cur = new Word(word, def, freq);
				
				String[] pas = b.readLine().split(" ");
				for(String t : pas) {
					cur.addSource(Integer.parseInt(t));
				}
				wordList.add(cur);
			}
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Not able to read file");
		}
		return false;
	}

	@Override
	public boolean handleRequest(Event event) {
		if(event.type().equals("FlashCard")) {
			
		}
		else if(event.type().equals("BagOfWords")) {
			
		}
		return false;
	}

}
