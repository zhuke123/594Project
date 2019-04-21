import java.util.*;

public interface IDictionary {
	
	/**
	 * 
	 * @return list of words
	 */
	public List<IWord> getWords();
	
	/**
	 * read file and create a word list
	 * @param filename
	 * @return whether succeeded to read the file and create list
	 */
	public boolean readFile(String filename);
	
	/**
	 * handle incoming event request
	 * @param event
	 * @return whether succeeded to fulfill the event request
	 */
	public boolean handleRequest(Event event);
}
