import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rank implements IRank {
	List<IUser> usersList;
	
	/**
	 * constructor with non-input, will build an empty userList
	 */
	public Rank() {
		usersList = new ArrayList<IUser>();
	}
	
	/**
	 * constructor with given userList
	 * @param usersList
	 */
	public Rank(List<IUser> usersList) {
		this.usersList = usersList;
	}
	
	@Override
	public void showAllRank() {
		Collections.sort(this.usersList);
		for(int i = 0 ; i < this.usersList.size();i++) {
			IUser temp = this.usersList.get(i);
			System.out.println(temp.getUsername() + " Rank : " + (i + 1)
			+ " Known words : " + temp.getWordCount());	
		}

	}

	@Override
	public boolean searchRank(String userName) {
		Collections.sort(this.usersList);
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
		Collections.sort(this.usersList);
	}
	
	/**
	 * add user to the user list
	 * @param user input
	 */
	public void addUser(IUser user) {
		if(this.usersList.contains(user))
			return ;
		else
			this.usersList.add(user);
	}
	
	/**
	 * get rank of specific username
	 * @param username
	 * @return rank of the user, return -1 if user not found
	 */
	public int getRank(String username) {
		Collections.sort(this.usersList);
		for(int i = 0; i < this.usersList.size(); i ++) {
			if(this.usersList.get(i).getUsername().equals(username))
				return i + 1;
		}
		return -1;
	}
	
	/**
	 * get username of specific rank
	 * @param rank
	 * @return username of this rank
	 */
	public String getRank(int rank) {
		Collections.sort(this.usersList);
		if(rank <= 0 || rank > this.usersList.size())
			return "no such user";
		else {
			return this.usersList.get(rank - 1).getUsername();
		}
	}
	

}
