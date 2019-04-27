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
		Set<String> bag = new HashSet<String>();
		HashMap<HashSet<Integer>, Integer> permunation= new HashMap<HashSet<Integer>,Integer>();
		Set<HashSet<IWord>> key = new HashSet<HashSet<IWord>>();
		HashSet<IWord> currentSet = new HashSet<IWord>();
		generateBag(setOfWord,bagSize,key,currentSet);
		return bag;
	}
	
	public void generateBag(Set<IWord> setOfWords,int bagSize,Set<HashSet<IWord>> combination,HashSet<IWord> currentSet) {
 		if(bagSize>currentSet.size()) {
			for(IWord w:setOfWords) {
				System.out.print("size:"+ setOfWords.size()+ "\n");
				//System.out.print(w.getWord()+ "\n");
				currentSet.add(w);
			    Set<IWord> tmp = new HashSet<IWord>(setOfWords);
			    tmp.remove(w);
			    for(IWord i: currentSet) {
			    	System.out.print(i.getWord()+" ");
			    }
				generateBag(tmp,bagSize,combination,currentSet);
			}
		}
		else {
			combination.add(new HashSet<>(currentSet));
			currentSet.clear();
			generateBag(setOfWords,bagSize,combination,currentSet);
		}
	}
 
}
