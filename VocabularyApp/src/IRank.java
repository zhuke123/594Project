import java.util.*;

public interface IRank {
	
	
	/**
	 * this will update how many words the user have memorized
	 * @param user
	 */
	public void updateRank(IUser user);
	
	/**
	 * get rank of specific username
	 * @param username
	 * @return rank of the user, return -1 if user not found
	 */
	public int getRank(String username);
	/**
	 * get username of specific rank
	 * @param rank
	 * @return username of this rank
	 */
	public String getRank(int rank);
	
	
}
