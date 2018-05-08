package View;

import Model.SessionModel;
import Controller.LoginController;
import Util.dataoutput;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static void main(String args[]) throws Exception {
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
            uLogin.showCinemas();
        }
        else
        {
            System.out.println("Wrong Credentials.Try Again");
        }
        }while(!uLoginController.checkLogin(uName,password));
    }


    public void showCinemas() throws Exception {
        Scanner sc=new Scanner(System.in);
        Login uLogin=new Login();
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
            if(cinemaChoice<1||cinemaChoice>5)
            {
                System.out.println("Please enter the correct choice!");

            }
            else
            {
                uLogin.cinemaChoice(cinemaName)  ;

            }
        }
        while (cinemaChoice<1||cinemaChoice>5);
    }
    public  void cinemaChoice(String cinemaName) throws Exception {
        Scanner sc=new Scanner(System.in);
        LoginController uLoginController=new LoginController();
        int choice=0;
        do {
            System.out.println("Welcome to jMOSS- Java based Movie Search System");
            System.out.println("------------------------------------------------");
            System.out.println("Welcome to " + cinemaName + " Cinemas");
            System.out.println("Please select from the below menu:");
            System.out.println("1. Make a new Booking");
            System.out.println("2. Delete a booking");
            choice= sc.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Please enter the correct choice!");
            }
        }while(choice<1||choice>2);
        if(choice==1)
            makeBooking(cinemaName);
    }
    public void makeBooking(String cinemaName) throws Exception {
        Scanner sc=new Scanner(System.in);
        LoginController uLoginController=new LoginController();
        ArrayList<SessionModel> movies = new ArrayList<SessionModel>();
        System.out.println("Welcome to jMOSS- Java based Movie Search System");
        System.out.println("------------------------------------------------");
        System.out.println("Movies Playing at this cinema are:");
        movies=uLoginController.showMovies(cinemaName);
        dataoutput udataoutput=new dataoutput();
        ArrayList arrayList=new ArrayList();
        int movieChoice;
        do {
            arrayList= udataoutput.display(movies);
            System.out.println("Enter your choice for you want to display the sessions for");
            movieChoice=sc.nextInt();
        }while(movieChoice<1||movieChoice>arrayList.size());
        int sessionChoice;
        ArrayList sessions;
        do {
            String movieName = (String) arrayList.get(movieChoice - 1);
             sessions = new ArrayList();
            sessions = uLoginController.showSessions(cinemaName, movieName, movies);
            sessionChoice=sc.nextInt();
        }while(sessionChoice<1||sessionChoice> sessions.size());


    }
}
