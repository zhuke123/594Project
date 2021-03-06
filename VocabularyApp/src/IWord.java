import java.util.Date;
import java.util.Set;

public interface IWord extends Comparable<IWord>{
		
	/**
	 * after reviewing, set the timeStamp--
	 */
	public void updateTimeStamp();
	
	/**
	 * update according to users' feedback
	 * if status = 0, feedback + 2;
	 * if status = 1, feedback - 100;, add it into set.
	 * @param status of the feedback
	 */
	public void updateFeedback(int status);
	
	
	
	/**
	 * update weight: sum up value, timeStamp, freq
	 * @param weight
	 */
	public void updateWeight( double weight);
	
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
	public Set<Integer> getTextSources();	
	
	
	/**
	 * @return word definition
	 */
	public String getDefinition();
	
	/**
	 * 
	 * @return weight of the word
	 */
	public double getWeight();
	
	/**
	 * 
	 * @return last updated date of this word
	 */
	public long getTime();
	
	/**
	 * update time 
	 */
	public void updateTime();
	
	/**
	 * check if we meet the word for the first time
	 */
	public boolean isFirst();
	

	
	

}
