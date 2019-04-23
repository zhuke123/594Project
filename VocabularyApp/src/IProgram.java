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
