import java.util.List;
import java.util.PriorityQueue;

public class FlashCard implements IFlashCard{
	
	PriorityQueue<IWord> pq;
	
	/***
	 * constructor
	 */
	
	public FlashCard() {
		this.pq = new PriorityQueue<IWord>();
	}
	
	@Override
	/***
	 * return the type of the event
	 */
	public String type() {	
		return "flashcard";
	}

	/***
	 * create the data structure
	 * return true if succeed
	 */
	@Override
	public boolean createDataStructure(List<IWord> words) {
		if(words==null) {
			throw new NullPointerException("word list is null");
		}
		for(IWord word : words) {
			pq.add(word);
		}
		return true;
	}

	@Override
	public IWord getFlashCard() {
		return pq.poll();
	}

	@Override
	public void insert(IWord word) {
		this.pq.add(word);
	}

}
