import java.util.Set;

public interface IWord {
	
	/**
	 * set Word's frequency
	 */
	public void setFreq();
	
	/**
	 * set Word's timeStamp according to review interval
	 */
	public void updateTimeStamp();
	
	/**
	 * update Word's value according to users' feedback
	 */
	public void updateValue();
	
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
	 * timeStamp indicates how long is the time interval
	 * @return  Word.timestamp
	 */
	public int getTimestamp();
	
	/**
	 * value indicates user's feedback
	 * @return Word.value
	 */
	public int getValue();
	
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
