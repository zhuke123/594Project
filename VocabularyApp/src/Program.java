import java.util.*;

public class Program implements IProgram {

	
	private IDictionary dict = null;
	private List<IUser> users = null;
	private IRank rank = null;
	private HashSet<String> usernames;
	
	public Program(String filename) {
		dict = new Dictionary(filename);
		users = new ArrayList<>();
		rank = new Rank();
		usernames = new HashSet<>();
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
		if(idx < 0 || idx >= users.size())
			return null;
		return users.get(idx);
	}

	@Override
	public IDictionary getDict() {
		return dict;
	}

	@Override
	public boolean addUsers(String username) {
		if(username == null || usernames.contains(username))
			return false;
		usernames.add(username);
		users.add(new User(username));
		return true;
	}
	
	public static void main(String[] arg) {
		
	}

}
