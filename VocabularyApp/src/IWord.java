import java.util.Set;

public interface IWord {
		
	/**
	 * after reviewing, set the timeStamp--
	 */
	public void updateTimeStamp();
	
	/**
	 * update according to users' feedback
	 * if status = 0, feedback + 2;
	 * if status = 1, feedback - 100;, add it into set.
	 */
	public void updateFeedback(int status);
	
	
	
	/**
	 * update weight: sum up value, timeStamp, freq
	 */
	public void updateWeight();
	
	/**
	 * 
	 * @return Word.content
	 */
	public String getWord();
	
	/**
	 * 
	 * @return Word.frequency
	 */
	public int getFreq();
	
	
	/**
	 * 
	 * @return the set containing the text number the word is in
	 */
	public Set<Integer> getSet();	
	
	
	/**
	 * get word definition
	 */
	public String getDefinition();

}
