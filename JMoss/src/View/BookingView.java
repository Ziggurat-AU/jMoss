package View;

import Controller.BookingController;
import Controller.SessionController;
import Model.BookingModel;
import Model.SessionModel;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingView {
    public void makeBooking() throws Exception{
        Scanner sc=new Scanner(System.in);
        String cinemaName = null;
        int cinemaChoice;
        System.out.println("Select the cinema to proceed with:");
        System.out.println("1. St Kilda");
        System.out.println("2. Fitzroy");
        System.out.println("3. Melbourne CBD");
        System.out.println("4. Sunshine");
        System.out.println("5. Lilydale");
        cinemaChoice=sc.nextInt();
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
        else {
            System.out.println("------------------------------------------------");
            System.out.println("Welcome to " + cinemaName + " Cinemas");
            SessionController sessionController = new SessionController();
            ArrayList<SessionModel> sessions;
            System.out.println("Welcome to jMOSS- Java based Movie Search System");
            System.out.println("------------------------------------------------");
            System.out.println("Movies Playing at this cinema are:");
            sessions = sessionController.getSessions(cinemaName);
            ArrayList movies = new ArrayList();
            int movieChoice;
            do {
                movies = sessionController.getMovies(sessions);
                System.out.println("Enter your choice of the movie you want to display the sessions for");
                movieChoice = sc.nextInt();
            } while (movieChoice < 1 || movieChoice > sessions.size());
            int sessionChoice;
            ArrayList movieSchedules;
            do {
                String movieName = (String) movies.get(movieChoice - 1);
                movieSchedules = new ArrayList();
                sessions = sessionController.getMovieSchedules(cinemaName, movieName, sessions);
                sessionChoice = sc.nextInt();

                BookingController bookingController = new BookingController();

                sc = new Scanner(System.in);
                System.out.println("Enter amount of seats for booking:");
                int seatsAmount = sc.nextInt();

                int availableSeatAmount = 20 - (bookingController.getAvailableSeatAmount(sessions.get(sessionChoice-1)));
                if (seatsAmount <= availableSeatAmount) {
                    System.out.println("Enter customer's email:");
                    sc = new Scanner(System.in);
                    String customerEmail = sc.nextLine();

                    System.out.println("Enter customer's Suburb:");
                    sc = new Scanner(System.in);
                    String customerSuburb = sc.nextLine();
                    BookingModel bookingModel = new BookingModel(sessions.get(sessionChoice - 1), customerEmail, customerSuburb,seatsAmount, true);

                    bookingController.saveBooking(bookingModel);
                }
                else if (availableSeatAmount == 0) {
                    System.out.println("Cannot proceed with booking!");
                    System.out.println("Session is already full!");
                }
                else{
                    System.out.println("Cannot proceed with booking!");
                    System.out.println("Maximum number of seats available is: " + availableSeatAmount);
                }
            } while (sessionChoice < 1 || sessionChoice > sessions.size());
        }
    }

    private void selectCinema(){

    }

    public void deleteBooking(){}

    public void getBookingDetails(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter customer's email:");
        sc = new Scanner(System.in);
        String customerEmail = sc.nextLine();

        BookingController bookingController = new BookingController();

        ArrayList<BookingModel> customerBookings = bookingController.getCustomerBookings(customerEmail);

        if (customerBookings.size() > 0){
            int count = 1;
            for (BookingModel booking : customerBookings) {
                System.out.println("Booking " + count + " details:");
                System.out.println("Cinema theatre: " + booking.getSession().getVenue());
                System.out.println("Movie: " + booking.getSession().getMovie());
                System.out.println("Date: " + booking.getSession().getSessionDate());
                System.out.println("Time: " + booking.getSession().getVenue());
                System.out.println("Amount of seat: " + booking.getSeatsAmount());
            }
        }
        else{
            System.out.println("Customer has no booking!");
        }
    }

    public void getBookingLists() {
        BookingController bookingController = new BookingController();

        ArrayList<BookingModel> bookinglists = bookingController.getBookingLists();

        String email = null;
        int counter = 0;
        int counterInner = 0;
        if (bookinglists.size() > 0) {
            for(BookingModel bm : bookinglists){
                if (email == null){
                    counter++;
                    counterInner = 0;
                    System.out.println("============================================================================================");
                    System.out.println("============================================================================================");
                    System.out.println("\t" + counter + "\t Booking \t" +  bm.getCustomerEmail());
                }
                    email = bm.getCustomerEmail();
                if (email == bm.getCustomerEmail()) {
                    counterInner++;
                    System.out.println("");
                    System.out.println("\t\t Cinema theatre: " + bm.getSession().getVenue());
                    System.out.println("\t\t Movie: " + bm.getSession().getMovie());
                    System.out.println("\t\t Date: " + bm.getSession().getSessionDate());
                    System.out.println("\t\t Time: " + bm.getSession().getVenue());
                    System.out.println("\t\t Amount of seat: " + bm.getSeatsAmount());
                }
                else{
                    counter++;
                    counterInner = 0;
                    System.out.println("============================================================================================");
                    System.out.println("============================================================================================");
                    System.out.println(counter +  "===================" + bm.getCustomerEmail() + "===========================");
                }
                email = bm.getCustomerEmail();
            }
            System.out.println("============================================================================================");
            System.out.println("============================================================================================");
        }
    }
}
