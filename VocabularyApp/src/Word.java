import java.util.HashSet;
import java.util.Set;

public class Word implements IWord {
	
	//word data
	private String data;
	//word definition
	private String definition;
	//record how many times we still need to memorize the word
	//initially this will set to 3
	//so the user will need to memorize the word three times
	//then this word will probably never appear again
	private int timeStamp;
	//frequencies of this word in the text
	private int frequency;
	//weight of this word in heap
	private double weight;
	//this will contain all the texts that contain
	private Set<Integer> textSources;
	//time last updated
	long time;
	//check if we meet the word for the first time
	boolean first;
	
	private int init_timeStamp;
	
	/**
	 * constructor with data, definition and frequency
	 * @param data
	 * @param definition
	 * @param frequency
	 */
	public Word(String data, String definition, int frequency){
		this.data = data;
		this.timeStamp = 3;
		this.init_timeStamp = 3;
		this.frequency = frequency;
		this.weight = frequency;
		this.definition = definition;
		textSources = new HashSet<Integer>();
		this.time = -1;
		this.first = true;
	}
	@Override
	public void updateTimeStamp() {
		this.timeStamp--;
	}
	@Override
	public long getTime() {
		return this.time;
	}
	@Override
	public void updateTime() {
		this.time = System.currentTimeMillis();
	}
	
	/**
	 * getter for timeStamp
	 * @return
	 */
	public int getTimeStamp() {
		return this.timeStamp;
	}
	
	@Override
	public void updateFeedback(int status) {
		if(first)
			first = false;
		//0 means the user doesn't know the word
		if(status == 0) {
			this.weight += this.frequency * 1.0 / this.init_timeStamp;
		}
		//1 means the user knows the word
		else if(status == 1) {
			this.weight -= this.frequency * 1.0 / this.init_timeStamp;
		}
		else {
			System.out.println("illegal status of feedback");
		}
	}

	@Override
	public void updateWeight(double weight) {
		this.weight = weight;
	}
	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public String getWord() {
		return data;
	}

	@Override
	public int getFreq() {
		return frequency;
	}

	@Override
	public Set<Integer> getTextSources() {
		return this.textSources;
	}
	@Override
	public String getDefinition() {
		return this.definition;
	}
	
	/**
	 * setter for definition of the word
	 * @param definition of the word
	 */
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	
	/**
	 * add text source of the word
	 * @param source
	 */
	public void addSource(int source) {
		this.textSources.add(source);
	}
	@Override
	public int compareTo(IWord o) {
		if(this.weight < o.getWeight())
			return 1;
		else {
			if(this.weight == o.getWeight())
				return 0;
			else
				return -1;
		}
	}
	@Override
	public boolean isFirst() {
		return this.first;
	}


}
