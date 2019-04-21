import java.util.*;

public interface IRank {
	
	/**
	 * 
	 * print out the ranks of all users
	 */
	public void showAllRank();
	
	/**
	 * searching for the rank of a specific user
	 * and print the result
	 * @param userName
	 */
	public void searchRank(String user);
	
	/**
	 * this will update how many words the user have memorized
	 * @param user
	 */
	public void updateRank(String user);
	
	
	
	
}
