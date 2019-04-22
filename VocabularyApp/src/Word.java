import java.util.HashSet;
import java.util.Set;

public class Word implements IWord {
	
	//word data
	String data;
	//source text of this word
	int source;
	//record how many times we still need to memorize the word
	//initially this will set to 3
	//so the user will need to memorize the word three times
	//then this word will probably never appear again
	int timeStamp;
	//frequencies of this word in the text
	int frequency;
	//weight of this word in heap
	double weight;
	//this will contain all the texts that contain
	Set<Integer> textSources;
	
	public Word(String data, int source, int frequency){
		this.data = data;
		this.source = source;
		this.timeStamp = 3;
		this.frequency = frequency;
		this.weight = frequency;
		textSources = new HashSet<Integer>();
		
	}
	@Override
	public void updateTimeStamp() {
		this.timeStamp--;
	}

	@Override
	public void updateFeedback(int status) {
		//0 means the user doesn't know the word
		if(status == 0) {
			this.weight += this.frequency / this.timeStamp;
		}
		//1 means the user knows the word
		else if(status == 1) {
			this.weight -= this.frequency / this.timeStamp;
		}
		else {
			throw new IllegalStateException("update option should be 0 / 1");
		}
	}

	@Override
	public void updateWeight() {
		
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

}
