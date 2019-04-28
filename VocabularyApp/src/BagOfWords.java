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
		
		Set<HashSet<IWord>> key = new HashSet<HashSet<IWord>>();
		HashSet<IWord> currentSet = new HashSet<IWord>();
		HashMap<HashSet<IWord>, Integer> permutation= new HashMap<HashSet<IWord>,Integer>();
		Set<IWord> tmpSetOfWord = new HashSet<IWord>(setOfWord);
		generateBag(tmpSetOfWord,bagSize,key,currentSet);
		
		for(HashSet<IWord> s: key) {
			
			List<HashSet<Integer>> textlist = new ArrayList<HashSet<Integer>>();
			for(IWord w:s) {
				System.out.print(w.getTextSources().size()+" ");
				for(IWord i: setOfWord) {
					//System.out.print(i.getTextSources().size());
					if(w.getWord().equals(i.getWord())) {
						textlist.add((HashSet<Integer>) i.getTextSources());
					}
				}	
			}
//			for(IWord i : setOfWord) {
//				System.out.print(i.getTextSources().size());
//			}
			HashSet<Integer> commonText = textlist.get(0);
			for(int i = 1; i < textlist.size();i++) {
				commonText.retainAll(textlist.get(i));
			}
			permutation.put(s,commonText.size());
		}
		
//		for(IWord i : setOfWord) {
//			System.out.print(i.getTextSources().size());
//		}
		ArrayList<Integer> max = new ArrayList<Integer>(permutation.values());		
		Collections.sort(max,Collections.reverseOrder());
		//System.out.print(max.get(0));
		for(HashSet<IWord> k: permutation.keySet()) {
			//System.out.print(k.size());
			if(permutation.get(k)==max.get(0)) {
				for(IWord w: k) {
					bagOfWord.add((Word) w);
				}
			}
		}
		return bagOfWord;
	}
	
	
//	for(IWord i : setOfWord) {
//		System.out.print(i.getTextSources().size());
//	}

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
