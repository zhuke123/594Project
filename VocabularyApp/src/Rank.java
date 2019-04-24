import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rank implements IRank {
	List<IUser> usersList;
	
	public Rank() {
		usersList = new ArrayList<IUser>();
	}
	@Override
	public void showAllRank() {
		Collections.reverse(this.usersList);
		for(int i = 0 ; i < this.usersList.size();i++) {
			IUser temp = this.usersList.get(i);
			System.out.println(temp.getUsername() + " Rank : " + (this.usersList.indexOf(temp) + 1)
			+ " Known words : " + temp.getWordCount());	
		}

	}

	@Override
	public void searchRank(IUser user) {
		Collections.reverse(this.usersList);
		if(this.usersList.contains(user)) {
			System.out.println(user.getUsername() + " Rank : " + this.usersList.indexOf(user));
		}
		else {
			System.out.println("user is not in database, cant get rank");
		}
	}

	@Override
	public void updateRank(IUser user) {
		Collections.reverse(this.usersList);
	}
	
	public void addUser(IUser user) {
		if(this.usersList.contains(user))
			return;
		else
			this.usersList.add(user);
	}
	

}
