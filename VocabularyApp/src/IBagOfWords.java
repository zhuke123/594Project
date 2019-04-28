import java.util.Set;

public interface IBagOfWords extends Event {
	
	
	/**
	 * 
	 * @param bagSize - an integer indicating the size of the bag
	 * @return Set<String> - a set that contains bagSize Words
	 */
	public Set<IWord> getBag(int bagSize);

}

