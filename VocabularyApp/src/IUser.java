
public interface IUser {
	
	/**
	 * @return count of word known
	 */
	public int getWordCount();
	
	/**
	 * @return user's name
	 */
	public String getUsername();
	
	/**
	 * @return Flash Card event
	 */
	public IFlashCard getFlashCard();
	
	/**
	 * @return bag of words event
	 */
	public IBagOfWords getBagOfWords();

}
