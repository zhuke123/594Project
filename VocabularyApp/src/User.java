
public class User implements IUser{
	String userName;
	int knownWords;
	IFlashCard flashCard;
	IBagOfWords bagOfWords;
	
	public User(String name) {
		this.userName = name;
		this.knownWords = 0;
		flashCard = new FlashCard();
		bagOfWords = new BagOfWords();
	}
	
	@Override
	public int getWordCount() {
		return this.knownWords;
	}
	
	@Override
	public void setWordCount(int count) {
		this.knownWords = count;
	}

	@Override
	public String getUsername() {
		return this.userName;
	}

	@Override
	public IFlashCard getFlashCard() {
		return flashCard;
	}
	
	public void setFlashCard(IFlashCard flashCard) {
		this.flashCard = flashCard;
	}
	
	@Override
	public IBagOfWords getBagOfWords() {
		return this.bagOfWords;
	}
	
	public void setBagOfWords(IBagOfWords bagOfWords) {
		this.bagOfWords = bagOfWords;
	}

	@Override
	public int compareTo(IUser o) {
		return this.getWordCount() - o.getWordCount();
	}


}
