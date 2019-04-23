
public interface IUser extends Comparable<IUser>{
	
	/**
	 * @return count of word known
	 */
	public int getWordCount();
	
	/**
	 * 
	 * @param count new # of words
	 */
	public void setWordCount(int count);
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
