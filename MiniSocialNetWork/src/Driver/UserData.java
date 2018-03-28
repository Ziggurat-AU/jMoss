package Driver;

import java.util.ArrayList;

public class UserData {
	
	ArrayList<UserNodes> data;
	
	////////// For keep track of the information, use the key value link to the profile. 
	////////// How to show the each time updated information.
	////////// When you face these questions how do you solve them?What is your each step's 
	////////// coding the concrete codes. 
	
	public UserData () {
		
		data= new ArrayList<UserNodes>();
	
		data.add(new Adulttt("Alan","Studnet",18));
		data.add(new Adulttt("Ellen","Teacher",28));
		data.add(new Adulttt("Jay","professor",38));
		
		///////realize the delete, add ,select(boolean)......? through array List? 
		
		//thread
		//operating system
		
		//add friendship
		data.get(0).makeFriend(data.get(1)); 
	}
	
	

}
