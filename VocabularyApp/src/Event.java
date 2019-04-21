import java.util.*;

public interface Event {
	
	/**
	 * 
	 * @return a string for the event type
	 * 
	 * */
	public String type();
	
	/**
	 * This function will create a certain data structure for the event
	 * Depending on the event type
	 * @param A list of words
	 * @return Whether we succeed to create the data structure
	 * */
	public boolean createDataStructure(List<IWord> words);
	
}
