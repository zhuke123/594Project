import java.util.*;

public interface IProgram {
	
	/**
	 * @return list of users
	 * */
	public List<IUser> getDict();
	
	/**
	 * 
	 * @return ranking system
	 */
	public IRank getRank();
	
	/**
	 * initiate the program
	 */
	public void init();

}
