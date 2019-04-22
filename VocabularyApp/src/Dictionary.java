import java.util.*;

public class Dictionary implements IDictionary {
	
	List<IWord> wordList;
	
	public Dictionary(String filename) {
		wordList = new ArrayList<>();
		readFile(filename);
	}

	@Override
	public List<IWord> getWords() {
		return wordList;
	}

	@Override
	public boolean readFile(String filename) {
		// TODO Auto-generated method stub
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
