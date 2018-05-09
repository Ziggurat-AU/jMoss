package View;

import Controller.LoginController;

import java.util.Scanner;

public class MainMenuView {
    private Scanner sc=new Scanner(System.in);

    public MainMenuView() throws Exception{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Welcome to jMOSS- Java based Movie Search System");
            System.out.println("------------------------------------------------");
            System.out.println("Welcome to our booking application");
            selectAction();
    }

    private void selectAction() throws Exception{
        int choice=0;
        do {
            System.out.println("1. Make a new Booking");
            System.out.println("2. Delete a booking");
            System.out.println("2. Retrieve booking details");
            choice= sc.nextInt();
            if (choice < 1 || choice > 2) {
                System.out.println("Please enter the correct choice!");
            }
        }while(choice<1||choice>2);
        if(choice==1) {
            selectCinema();
        }
    }

    private  void selectCinema() throws Exception{
        int cinemaChoice;
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
            System.out.println("Welcome to jMOSS- Java based Movie Search System");
            System.out.println("------------------------------------------------");
            System.out.println("Welcome to " + cinemaName + " Cinemas");
            BookingView bookingView = new BookingView(cinemaName);
            //System.out.println("Please select from the below menu:");
            //selectAction();
            //selectCinema(cinemaName);
        }
    }

//    private void selectCinema(String cinemaName) throws Exception {
//        Scanner sc=new Scanner(System.in);
//        LoginController uLoginController=new LoginController();
//        int choice=0;
//        do {
//            System.out.println("Welcome to jMOSS- Java based Movie Search System");
//            System.out.println("------------------------------------------------");
//            System.out.println("Welcome to " + cinemaName + " Cinemas");
//            System.out.println("Please select from the below menu:");
//            System.out.println("1. Make a new Booking");
//            System.out.println("2. Delete a booking");
//            choice= sc.nextInt();
//            if (choice < 1 || choice > 2) {
//                System.out.println("Please enter the correct choice!");
//            }
//        }while(choice<1||choice>2);
//        if(choice==1) {
//            BookingView bookingView = new BookingView(cinemaName);
//        }
//    }
}
