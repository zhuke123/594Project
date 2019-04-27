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
	public Set<Word> getBag(int bagSize) {
		Set<String> bag = new HashSet<String>();
		Set<HashSet<IWord>> key = new HashSet<HashSet<IWord>>();
		HashSet<IWord> currentSet = new HashSet<IWord>();
		HashMap<HashSet<IWord>, Integer> permutation= new HashMap<HashSet<IWord>,Integer>();
		generateBag(setOfWord,bagSize,key,currentSet);
		for(HashSet<IWord> s: key) {
			List<HashSet<Integer>> textlist = new ArrayList<HashSet<Integer>>();
			for(IWord w:s) {
				textlist.add((HashSet<Integer>) w.getTextSources());
			}
			HashSet<Integer> commonText = textlist.get(0);
			for(int i = 1; i < textlist.size();i++) {
				commonText.retainAll(textlist.get(i));
			}
			permutation.put(s,commonText.size());
		}
		
		ArrayList max = new ArrayList<Integer>(permutation.values());
		Collections.sort(max,Collections.reverseOrder());
		for(HashSet<IWord> k: permutation.keySet()) {
			if(permutation.get(k)==max.get(0)) {
				for(IWord w: k) {
					bagOfWord.add((Word) w);
				}
			}
		}
		return bagOfWord;
	}
	
	public void generateBag(Set<IWord> setOfWords,int bagSize,Set<HashSet<IWord>> combination,HashSet<IWord> currentSet) {
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
