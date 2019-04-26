import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rank implements IRank {
	List<IUser> usersList;
	
	public Rank() {
		usersList = new ArrayList<IUser>();
	}
	
	public Rank(List<IUser> usersList) {
		this.usersList = usersList;
	}
	
	@Override
	public void showAllRank() {
		Collections.reverse(this.usersList);
		for(int i = 0 ; i < this.usersList.size();i++) {
			IUser temp = this.usersList.get(i);
			System.out.println(temp.getUsername() + " Rank : " + (i + 1)
			+ " Known words : " + temp.getWordCount());	
		}

	}

	@Override
	public boolean searchRank(String userName) {
		Collections.reverse(this.usersList);
		for(int i = 0; i < this.usersList.size(); i ++) {
			if(this.usersList.get(i).getUsername().equals(userName)) {
				System.out.println(userName + " Rank : " + (i + 1));
				return true;
			}
		}
		System.out.println("user is not in database, cant get rank");
		return false;
	}

	@Override
	public void updateRank(IUser user) {
		Collections.reverse(this.usersList);
	}
	
	public void addUser(IUser user) {
		if(this.usersList.contains(user))
			return ;
		else
			this.usersList.add(user);
	}
	

}
