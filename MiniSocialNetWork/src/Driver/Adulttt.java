
package Driver;

import java.util.ArrayList;

public class Adulttt extends UserNodes 

{

	
	public Adulttt (String userName, String userStatus, int userAge) {
		super(userName, userStatus, userAge);
		
		//intialize arraylist
		friends = new ArrayList<UserNodes>();
	}
	
	
	//check if one family from two : parent1 and parent2 
	//
	
	
	public boolean makeFriend(UserNodes friend){
		
		if(checkAge(friend)){
			friends.add( friend) ;
			return true; 
		}
		
		return false;
//		ArrayList<String>fridentsNames = UerNodes.getfriend();
		

	}
	

	

}