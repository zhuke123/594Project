import java.util.HashSet;
import java.util.Set;

public class Word implements IWord {
	
	//word data
	private String data;
	//source text of this word
	private int source;
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
	
	private int init_timeStamp;
	
	public Word(String data, int source, int frequency){
		this.data = data;
		this.source = source;
		this.timeStamp = 3;
		this.init_timeStamp = 3;
		this.frequency = frequency;
		this.weight = frequency;
		textSources = new HashSet<Integer>();
		
	}
	@Override
	public void updateTimeStamp() {
		this.timeStamp--;
	}
	public int getTimeStamp() {
		return this.timeStamp;
	}
	@Override
	public void updateFeedback(int status) {
		//0 means the user doesn't know the word
		if(status == 0) {
			this.weight += this.frequency / this.init_timeStamp;
		}
		//1 means the user knows the word
		else if(status == 1) {
			this.weight -= this.frequency / this.init_timeStamp;
		}
		else {
			throw new IllegalStateException("update option should be 0 / 1");
		}
	}

	@Override
	public void updateWeight() {
		
	}
	
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
	public Set<Integer> getSet() {
		return this.textSources;
	}
	@Override
	public String getDefinition() {
		// TODO Auto-generated method stub
		return null;
	}

}
