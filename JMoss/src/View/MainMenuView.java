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
        System.out.println("Please select an action from the below menu:");
            selectAction();
    }

    private void selectAction() throws Exception{
        int choice=0;
        do {
            System.out.println("1. Make a new Booking");
            System.out.println("2. Delete a booking");
            System.out.println("3. Retrieve booking details");
            System.out.println("4. Show Booking Lists");
            choice= sc.nextInt();
            if (choice < 1 || choice > 4) {
                System.out.println("Please enter the correct choice!");
            }
        }while(choice<1||choice>4);
        if(choice==1) {
            BookingView bookingView = new BookingView();
            bookingView.makeBooking();
        }
        if(choice==2) {
            BookingView bookingView = new BookingView();
            bookingView.deleteBooking();
        }
        if(choice==3) {
            BookingView bookingView = new BookingView();
            bookingView.getBookingDetails();
        }
        if(choice==4) {
            BookingView bookingView = new BookingView();
            bookingView.getBookingLists();
        }
    }
}
