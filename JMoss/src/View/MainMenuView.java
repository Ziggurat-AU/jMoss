package View;

import Controller.LoginController;
import Utils.JmossUtils;

import java.util.Scanner;

public class MainMenuView {

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
        System.out.println("Please select an action from the below menu:");
        do {
            System.out.println("1. Make a new Booking");
            System.out.println("2. Delete a booking");
            System.out.println("3. Retrieve booking details");
            System.out.println("4. Show Booking Lists");
            System.out.println("5. Exit");
            choice= JmossUtils.getInt();
            if (choice < 1 || choice > 5) {
                System.out.println("Please enter the correct choice!");
            }
        }while(choice<1||choice>5);
        if(choice==1) {
            BookingView bookingView = new BookingView();
            bookingView.selectBookingType();
            selectAction();
        }
        if(choice==2) {
            BookingView bookingView = new BookingView();
            bookingView.deleteBooking();
            selectAction();
        }
        if(choice==3) {
            BookingView bookingView = new BookingView();
            bookingView.getBookingDetails();
            selectAction();
        }
        if(choice==4) {
            BookingView bookingView = new BookingView();
            bookingView.getBookingLists();
            selectAction();
        }
        if (choice == 5){
            System.out.println("System exiting.");
            java.awt.Toolkit.getDefaultToolkit().beep();
            System.exit(0);
        }
    }
}
