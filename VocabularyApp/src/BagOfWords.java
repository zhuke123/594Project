import java.util.*;

public class BagOfWords implements IBagOfWords{
	
	Set<Word> bagOfWord;
	Set<IWord> setOfWord;
	int size;	

	@Override
	public String type() {
		return "bag";
	}

	@Override
	public boolean createDataStructure(List<IWord> words) {
		if(words == null || words.size() < 30)
			return false;
		setOfWord = new HashSet<>();
		while(setOfWord.size() < 30) {
			IWord maxi = null;
			int freq = -1;
			for(IWord word : words) {
				if(word.getFreq() > freq && !setOfWord.contains(word)) {
					freq = word.getFreq();
					maxi = word;
				}
			}
			setOfWord.add(maxi);
		}
		return true;
	}

	@Override
	public Set<String> getBag(int bagSize) {
		return null;
	}

}
