package Driver;
import java.util.ArrayList;


public abstract class UserNodes  {
 

	private String name;
	private String status ;
	private int age;
	ArrayList<UserNodes> friends;
	 

	//UserNodes constructor for user own, no friends.
	public UserNodes (String userName, String userStatus, int userAge) 
	{
		
		name = userName;
		status = userStatus ;
		age = userAge ;
	
	}
	 
	  
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getAge() {
		return this.age;  
	}
	public void setAge(int age) {
		this.age = age;
	}
	//Check Age to decide the the user is adult or dependent. 
	
	// public UserNodes checkAge (String age ) {
		
		
//	}
	
//	public UserNodes checkAge(String userName) { 
//		
//		if ( UserNodes.getAge() > 2 && UserNodes.getAge() < 16 ) {
//			System.out.println("This is a dependent user. " + userName );
//			}
//	
//	
//	
	public ArrayList<UserNodes> listFriends() { 
		return friends;
	}
	

	public boolean checkAge(UserNodes friend) { 
		
		if( friend.getAge() >= 16 ) {
//			
//			System.out.println("This is a adult user. ");
//		
			return true;
		}
		return false; 
			
	}


	public boolean makeFriend(UserNodes userNodes) {
		return false;
	}
	 

}












