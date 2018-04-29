package View;

import Controller.LoginController;

import java.io.IOException;
import java.util.Scanner;

public class Login {

    public static void main(String args[]) throws IOException {
        Login uLogin=new Login();
        LoginController uLoginController=new LoginController();
        String uName=null;
        String password=null;
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to jMOSS- Java based Movie Search System");

        do {
        System.out.println("Enter your username");
        uName=sc.next();
        System.out.println("Enter your Password");
        password=sc.next();
        if(uLoginController.checkLogin(uName,password))
        {

        }
        else
        {
            System.out.println("Wrong Credentials.Try Again");
        }
        }while(!uLoginController.checkLogin(uName,password));
        int cinemaChoice;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Welcome to jMOSS- Java based Movie Search System");
            System.out.println("------------------------------------------------");
            System.out.println("Welcome to our booking application");
            System.out.println("Select the cinema to proceed with:");
            System.out.println("1. St Kilda");
            System.out.println("2. Fitzroy");
            System.out.println("3. Melbourne CBD");
            System.out.println("4. Sunshine");
            System.out.println("5. Lilydale");
             cinemaChoice=sc.nextInt();
            String cinemaName=null;
            if(cinemaChoice==1)
                cinemaName= "St Kilda";
               else if(cinemaChoice==2)
            cinemaName= "Fitzroy";
            else if(cinemaChoice==3)
                cinemaName= "Melbourne CBD";
            else if(cinemaChoice==4)
                cinemaName= "Sunshine";
            else if(cinemaChoice==5)
                cinemaName= "Lilydale";
            if(cinemaChoice<1&&cinemaChoice>5)
            {
                System.out.println("Please enter the correct choice!");

            }
            else
            {
                uLogin.cinemaChoice(cinemaName)  ;

            }
        }
        while (cinemaChoice<1&&cinemaChoice>5);
    }

    public  void cinemaChoice(String cinemaName)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Welcome to jMOSS- Java based Movie Search System");
        System.out.println("------------------------------------------------");
        System.out.println("Welcome to " + cinemaName +" Cinemas");
        System.out.println("Please select from the below menu:");
        System.out.println("1. Make a new Booking");
        System.out.println("2. Delete a booking");
        int choice=sc.nextInt();
        
    }
}
