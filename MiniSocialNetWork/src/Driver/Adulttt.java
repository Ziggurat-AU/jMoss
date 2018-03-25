
package Driver;

import java.util.ArrayList;

public class Adulttt extends UserNodes 

{

	private ArrayList<String> fridentsNames ;
	
	public Adulttt (String userName, String userStatus, int userAge) {
		super(userName, userStatus, userAge);
		
		//intialize arraylist
		fridentsNames = new ArrayList<String>();
	}
	
	public boolean makeFriend(String friend){
		
//		ArrayList<String>fridentsNames = UerNodes.getfriend();
		fridentsNames.add( friend) ;
		return true; 

	}
	
	public ArrayList<String> listFridents (){
		
		
		
		
		
		return null; 
	}
	

}