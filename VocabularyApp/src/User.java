
public class User implements IUser{
	String userName;
	int knownWords;
	IFlashCard falshCard;
	
	public User(String name) {
		this.userName = name;
		this.knownWords = 0;
		this.falshCard = new FlashCard();
		
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBagOfWords getBagOfWords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(IUser o) {
		return this.getWordCount() - o.getWordCount();
	}


}
