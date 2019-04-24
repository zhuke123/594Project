import java.util.*;

public interface IProgram {
	
	/**
	 * @return list of users
	 * */
	public IDictionary getDict();
	
	/**
	 * @return list of users
	 * */
	public List<IUser> getUsers();
	
	/**
	 * if no duplicate username
	 * @return whether successfully add a user
	 */
	public boolean addUsers(String username);
	
	/**
	 * 
	 * @return ranking system
	 */
	public IRank getRank();
	
	/**
	 * @return user
	 */
	public IUser getUser(String name);
	
	/**
	 * @return user
	 */
	public IUser getUser(int idx);
	
	

}
