
public interface IUser {
	
	/**
	 * @return count of word known
	 */
	public int getWordCount();
	
	/**
	 * @return username
	 */
	public String getUsername();
	
	/**
	 * flashcard event
	 */
	public void flashcard();
	
	/**
	 * bag of words event
	 */
	public void bagOfWords();
}
