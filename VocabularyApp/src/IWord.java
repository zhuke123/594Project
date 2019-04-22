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
	 * add the test number into the test set
	 */
	public void addToSet();
	
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
	 * weight is the sum of frequency, timeStamp, and user's feedback
	 * @return Word.weight
	 */
	public int getWeight();
	
	/**
	 * 
	 * @return the set containing the text number the word is in
	 */
	public Set<Integer> getSet();
	
	
	
	
	

}
