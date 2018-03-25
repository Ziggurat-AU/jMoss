package Driver;

import java.util.ArrayList;

public class Dependent extends UserNodes {

	ArrayList<String> parents ; 
	ArrayList<UserNodes> fridents;
	
	
	public Dependent(String userName, String userStatus, int userAge,String parent1,String parent2 ) {
		super(userName, userStatus, userAge);
		
		parents = new ArrayList<String>();
		
		//
		
	
		parents.add(parent1);
		parents.add(parent2);
	}
	
	
	public boolean checkAge(int age) {
		
		if ( age > 2 && age < 16 ) 
			
			return true;
		else 
				return false;
	
	}
	
	public boolean makeFriend(UserNodes friend){
		
	
        if ( checkAge (friend.getAge()) ) {
        	    	
        	fridents.add( friend) ;
        	return true;
        }
		//		ArrayList<String>fridentsNames = UerNodes.getfriend();
		
		return false;

	}


	public ArrayList< String > findParents()
	{
		return parents;
	}	
	
	
	
	
	
}
