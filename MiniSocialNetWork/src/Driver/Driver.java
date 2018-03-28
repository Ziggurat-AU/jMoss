/**
 * 
 */
/**
 * @author zhangjuan
 *
 */
package Driver;



import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.shape.Rectangle;



//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;


 
public class Driver {
	
	public ArrayList<UserNodes> data ;
	
	public Driver () {
	   
		data= (new UserData()).data;
		
		
//		userNodes = new ArrayList<UserNodes>();
//		this.userNodes = userNodes;
	   
   }
	
	public void diverMenu(){

		
	//	System.out.println(" Please write your name :  ");
	//	System.out.println(" Your activities that you currently engaged in :  ");
		
		
		Scanner sc = new Scanner ( System.in) ; 
		
		//later
//		System.out.println("1. first time come to Mini-NetStation. Please  Register");
//		System.out.println("2. Login");
//		System.out.println("Enter an option : ");
		
//	    int userOption = option.nextInt() ;
	    
	    //new to the application 
//	    if (userOption = 1) {
//	    	
//	    	List <UsersProfileCollection> userarrayList = new ArrayList <UsersProfileCollection > ; 
//	    	//List<String> arratList;
//			userarrayList.add(userOption) ;
//	    	
//			
//			
//			//store the user data and go to next stage MiniNet Menu. 
//	    	 
//	    	 
//	    }
	    //has already existed 
//	    else if (userOption = 2) {
//	    	
//	    	
//	    	
//	    }
	    //wrong enter 
//	    else
	    	//(question: here how to use right exception throw)
//	     System.out.println("Pleae enter right option ");
		
		
		int userOption;
		
		do{
			System.out.println("MiniNet Menu");
			System.out.println("===================================");
			System.out.println("1.   List everyone ;  ")  ;
			System.out.println("2.   Select two person, Are these two direct friends ;");
			System.out.println("3.  Exit   ");
		   // System.out.println("4.   Exit ");
		    System.out.println("");
		    System.out.println("Enter an option:   ");
			
		    
		    
		    userOption = sc. nextInt() ;
	    
		    switch (userOption)
		    {
			    case 1: 
			    	 listEveryone() ;
			    	break;
			    case 2:
			    	checkIfFriends();
			    	break;
			    case 3:
			    	System.out.println("3. ")  ;
			    	break;
			    case 4: 
			    	System.out.println("EXIT ")  ;
			    	break;
			    	
			    default:
			    	System.out.println("Not a correct input");
		    }
	    
	    
	    
		} while( userOption!= 4) ;
	    
	    
	
	    //application board display
	 
   
	    
	}  
		
	private  void listEveryone(){
		for(int i=0;i<data.size();i++){
			System.out.print(data.get(i).getName()+" ");
		}
		System.out.println();
		System.out.println();
	}
	
	private void checkIfFriends(){
		//get two person

		System.out.println("Input two Persons' names ( one name per line):");
		System.out.println("(ex:");
	    System.out.println("Jay");
	    System.out.println("Alan");
	    System.out.println(")");
		
		
		Scanner sc = new Scanner ( System.in) ; 
		String firstInput=sc.nextLine();
		String secondInput=sc.nextLine();
		
		
		UserNodes firstPerson=null;
		UserNodes secondPerson=null;
		for(int i=0;i<data.size();i++){
			if(data.get(i).getName().equals( firstInput) ){
				firstPerson=data.get(i);
			}
			if(data.get(i).getName().equals( secondInput) ){
				secondPerson=data.get(i);
			}
		}
		
		//check friends
		ArrayList<UserNodes> friends=firstPerson.listFriends();
		
		boolean found=false;
		
		
		//check if person one have person two in friend list
		for(int i=0;i<friends.size();i++){
			if(friends.get(i).getName()==secondPerson.getName()){
				found=true;
				break;
			}
		}
		
		friends=secondPerson.listFriends();
		
		
		//check if person two have person one in friend list
		for(int i=0;i<friends.size();i++){
			if(friends.get(i).getName()==firstPerson.getName()){
				found=true;
				break;
			}
		}
		
		if(found){
			System.out.println("They are friends.");
		}else{
			System.out.println("They are not friends.");
		}
		
	}
	
	public static void main(String[] args) {
		
		
		Driver d = new Driver();
//		d.diverMenu();
//		System.out.print(d.data.get(0).getName());
		
		
//		
//		ArrayList<UserNodes> friends= d.data.get(0).listFriends();
//		
//		System.out.print(friends.get(0).getName());
		
		d.diverMenu();

	} 
	

	public String addName (String name)
	{
		Scanner inputName = new Scanner (System.in) ;
		System.out.println(" Enter your name :   ") ;
	      name = inputName.next() ;
	      return name;	
	}

	
    public Boolean selectName( )
    { 
    	return true ; 

     } 
	 
	
	public String displaySelectedName( String selectedName) 
	{
		while( selectName())
		{
		System.out.println( selectedName);
		}
		
		return selectedName ;
		
	}
    
    
    public void updateSelectedUser()
    
    {
    	
    	
    }
    
    public void deleteSelectedUser()
    {
    	
    	
    	
    }
    
    
    public boolean checkIfDirectFriend () {
    	
    	return true;
    	
    	
    }
    
    
    
    
    
    public void connectTwoUser()
    {
//    	if 
    	
    	
    	
    }	
	
	
	

//	@Override

}


 















