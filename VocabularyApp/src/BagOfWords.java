import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class BagOfWords implements IBagOfWords{
	
	Set<Word> bagOfWord;
	List<IWord> listOfWord;

	@Override
	public String type() {
		return "bag";
	}

	@Override
	public boolean createDataStructure(List<IWord> words) {
		PriorityQueue<IWord> pq = new PriorityQueue<IWord>();
		if(words==null) {
			throw new NullPointerException("word list is null");
		}
		for(IWord word : words) {
			pq.add(word);
		}
		for(int i =0;i<30;i++) {
			listOfWord.add(pq.poll());
		}
		return true;
	}

	@Override
	public Set<String> getBag(int bagSize) {
		return null;
	}

}
