import java.util.*;

public class Program implements IProgram {

	
	private IDictionary dict;
	private List<IUser> users;
	private IRank rank;
	
	public Program(String filename) {
		dict = new Dictionary(filename);
		users = new ArrayList<>();
		rank = new Rank();
	}

	@Override
	public List<IUser> getUsers() {
		return users;
	}

	@Override
	public IRank getRank() {
		return rank;
	}
	

	@Override
	public IUser getUser(String name) {
		for(IUser user : users) {
			if(user.getUsername().equals(name)) {
				return user;
			}
		}
		return null;
	}

	@Override
	public IUser getUser(int idx) {
		return users.get(idx);
	}

	@Override
	public IDictionary getDict() {
		return dict;
	}

}
