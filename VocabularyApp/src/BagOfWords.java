import java.util.*;

public class BagOfWords implements IBagOfWords{
	
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
		
		//create set of 30
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
	public Set<IWord> getBag(int bagSize) {
		//generate all combination
		Set<HashSet<IWord>> combinations = new HashSet<HashSet<IWord>>();
		HashSet<IWord> currentSet = new HashSet<IWord>();
		Set<IWord> tmpSetOfWord = new HashSet<IWord>(setOfWord);
		generateBag(tmpSetOfWord,bagSize,combinations,currentSet);
				
		//record for largest　set
		Set<IWord> res = new HashSet<>();
		int max = 0;
		
		//loop through all combinations
		for(HashSet<IWord> set : combinations) {
			HashSet<Integer> texts = new HashSet<>();
			boolean first = true;
			//loop through all words to get intersection texts
			for(IWord word : set) {
				if(first) {
					texts = new HashSet<>(word.getTextSources());					
					first = false;
				}
				else {
					texts.retainAll(word.getTextSources());
				}
			}
			//update maximum set
			if(texts.size() > max) {
				max = texts.size();
				res = set;
			}
		}	
		
		return res;
	}
	

	private void generateBag(Set<IWord> setOfWords,int bagSize,Set<HashSet<IWord>> combination,HashSet<IWord> currentSet) {
 		if(bagSize>currentSet.size()) {
			for(IWord w:setOfWords) {
				currentSet.add(w);
			    Set<IWord> tmp = new HashSet<IWord>(setOfWords);
				
			    tmp.remove(w);		    
				generateBag(tmp,bagSize,combination,currentSet);
				currentSet.remove(w);
			}
		}
		else {
			combination.add(new HashSet<>(currentSet));
		}
	}
  
}
