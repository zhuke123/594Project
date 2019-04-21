
public interface IFlashCard extends Event {

	
	
	/***
	 * return the top word of the user's heap
	 */
	public IWord getFlashCard();
	
	/***
	 * 
	 * insert the updated word back into the heap
	 */
    public void insert(IWord word);
}
