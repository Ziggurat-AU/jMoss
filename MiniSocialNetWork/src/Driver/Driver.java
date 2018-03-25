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
	
	
	
	
//	public void start1 (Stage primaryStage) {
//	{
		/*
	//	System.out.println(" Please write your name :  ");
	//	System.out.println(" Your activities that you currently engaged in :  ");
		
		
		Scanner option = new Scanner ( System.in) ; 
		
		System.out.println("1. first time come to Mini-NetStation. Please  Register");
		System.out.println("2. Login");
		System.out.println("Enter an option : ");
		
	    int userOption = option.nextInt() ;
	    
	    //new to the application 
	    if (userOption = 1) {
	    	
	    	List <UsersProfileCollection> userarrayList = new ArrayList <UsersProfileCollection > ; 
	    	//List<String> arratList;
			userarrayList.add(userOption) ;
	    	
			
			
			//store the user data and go to next stage MiniNet Menu. 
	    	 
	    	 
	    }
	    //has already existed 
	    else if (userOption = 2) {
	    	
	    	
	    	
	    	
	    }
	    //wrong enter 
	    else
	    	//(question: here how to use right exception throw)
	     System.out.println("Pleae enter right option ");
		/
		
		
	/*	System.out.println("      MiniNet Menu       ");
		System.out.println("1.   List everyone ;  ")  ;
		System.out.println("2.   Select a person ;");
		System.out.println("3.   Are these two direct frieds?  ");
	    System.out.println("4.   Exit ");
	    System.out.println("");
	    System.out.println("Enter an option:   ");
		
	    */
	    
	 /*   Scanner menuOption = new Scanner (System.in) ;
	    int userOption = menuOption. nextInt() ;
	    
	    switch (userOption)
	    {
	    case 1: List();
	    case 2:
	    case 3:
	    case 4: 
	    
	    
	    }
	    */
	
	    //application board display
	 
   
	    
//	}  
		
		
//	}
	
	public static void main(String[] args) {
		Driver d = new Driver();
		System.out.print(d.data.get(0).getName());

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


 















