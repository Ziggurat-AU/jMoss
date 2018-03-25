package Driver;

import java.util.ArrayList;

public class UserData {
	
	ArrayList<UserNodes> data;
	
	public UserData () {
		
		data= new ArrayList<UserNodes>();
	
		data.add(new UserNodes("Alan","Studnet",18));
		data.add(new UserNodes("Ellen","Teacher",28));
		data.add(new UserNodes("Jay","professor",38));
	}
	

}
