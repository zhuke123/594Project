
public class User implements IUser{
	String userName;
	int knownWords;
	
	public User(String name) {
		this.userName = name;
	}
	@Override
	public int getWordCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void setWordCount(int count) {
		this.knownWords = count;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
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
