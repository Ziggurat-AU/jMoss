package View;

import Controller.BookingController;
import Controller.SessionController;
import Model.BookingModel;
import Model.SessionModel;
import Utils.JmossUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class BookingView {
    private SessionController sessionController = new SessionController();
    private BookingController bookingController = new BookingController();

    public void selectBookingType() throws Exception{
        Scanner sc=new Scanner(System.in);
        int searchChoice =0;
        System.out.println("Enter your search option:");
        System.out.println("1. Search by theatre");
        System.out.println("2. Search by movie");
        do {
            searchChoice = JmossUtils.getInt();
            if (searchChoice == 1) {
                bookByTheatre();
            } else if (searchChoice == 2) {
                bookByMovie();
            } else {
                System.out.println("Please enter a correct choice!");
            }
        } while (searchChoice < 1 && searchChoice >2);
    }

    private void bookByTheatre(){
        Scanner sc=new Scanner(System.in);
        String cinemaName = null;
        int cinemaChoice;
        System.out.println("Select the cinema to proceed with:");
        System.out.println("1. St Kilda");
        System.out.println("2. Fitzroy");
        System.out.println("3. Melbourne CBD");
        System.out.println("4. Sunshine");
        System.out.println("5. Lilydale");
        cinemaChoice=JmossUtils.getInt();
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
            ArrayList<SessionModel> sessions;
            System.out.println("Welcome to jMOSS- Java based Movie Search System");
            System.out.println("------------------------------------------------");
            System.out.println("Movies Playing at this cinema are:");
            sessions = sessionController.getSessionsByTheatre(cinemaName);

            if (sessions.size() > 0) {
                int sessionChoice;
                ArrayList movieSchedules = new ArrayList();

                ArrayList<String> movieNames = new ArrayList<String>(sessionController.getMovies(sessions));
                String selectedMovie = selectMovie(movieNames);

                do {
                    sessions = sessionController.getMovieSchedules(cinemaName, selectedMovie, sessions);
                    sessionChoice = JmossUtils.getInt();
                    SessionModel selectedSession = sessions.get(sessionChoice - 1);
                    makeBooking(selectedSession);
                } while (sessionChoice < 1 || sessionChoice > sessions.size());
            }
            else{
                System.out.println("No movies are currently playing at this theatre!");
            }
        }
    }

    private void makeBooking(SessionModel selectedSession){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter amount of seats for booking:");
        int seatsAmount = JmossUtils.getInt();

        int availableSeatAmount = 20 - (bookingController.getAvailableSeatAmount(selectedSession));
        if (seatsAmount <= availableSeatAmount) {
            System.out.println("Enter customer's email:");
            String customerEmail = sc.nextLine();

            System.out.println("Enter customer's Suburb:");
            sc = new Scanner(System.in);
            String customerSuburb = sc.nextLine();

            Boolean creditCardPayment = null;

            do {
                System.out.println("Credit card payment (Y/N):");
                sc = new Scanner(System.in);
                char creditCardOption = sc.next().charAt(0);

                if (creditCardOption == 'Y' || creditCardOption == 'y') {
                    creditCardPayment = true;
                } else if (creditCardOption == 'N' || creditCardOption == 'n') {
                    creditCardPayment = false;
                }
                else{
                    System.out.println("Invalid choice!");
                    System.out.println("Credit card payment (Y/N):");
                }
            }
            while (creditCardPayment == null);

            BookingModel bookingModel = new BookingModel(selectedSession, customerEmail, customerSuburb,seatsAmount, creditCardPayment);
            bookingController.saveBooking(bookingModel);
        }
        else if (availableSeatAmount == 0) {
            System.out.println("Cannot proceed with booking!");
            System.out.println("Session is already full!");
        }
        else{
            System.out.println("Cannot proceed with booking!");
            System.out.println("Maximum number of seats available for this session is: " + availableSeatAmount);
        }
    }

    private void bookByMovie(){
        int sessionChoice;
        ArrayList movieSchedules = new ArrayList();

        ArrayList<SessionModel> allSessionList = sessionController.getAllSessions();

        if (allSessionList.size() > 0) {
            ArrayList<String> movieNames = new ArrayList<String>(sessionController.getMovies(allSessionList));
            String selectedMovie = selectMovie(movieNames);
            ArrayList<SessionModel> sessions = sessionController.getMovieSchedules(selectedMovie, allSessionList);

            do {
                sessionChoice = JmossUtils.getInt();
                SessionModel selectedSession = sessions.get(sessionChoice - 1);
                makeBooking(selectedSession);
            } while (sessionChoice < 1 || sessionChoice > sessions.size());
        }
        else{
            System.out.println("No movies are currently playing!");
        }
    }

    private String selectMovie(ArrayList<String> movieNames){
        int movieChoice;
        do {
            System.out.println("Number\tMovie Name");
            for (int i = 0; i < movieNames.size(); i++) {
                System.out.println(i+1 +"\t"+movieNames.get(i));
            }
            System.out.println("Enter your choice of the movie you want to display the sessions for");
            movieChoice = JmossUtils.getInt();
        } while (movieChoice < 1 || movieChoice > movieNames.size());

        return movieNames.get(movieChoice - 1 );
    }

    public void deleteBooking(){

    }

    public void getBookingDetails(){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter customer's email:");
        String customerEmail = sc.nextLine();

        ArrayList<BookingModel> customerBookings = bookingController.getCustomerBookings(customerEmail);

        if (customerBookings.size() > 0){
            int count = 1;
            for (BookingModel booking : customerBookings) {
                System.out.println("Booking " + count + " details:");
                System.out.println("Booking Ref: " + booking.getBookingRef());
                System.out.println("Cinema theatre: " + booking.getSession().getVenue());
                System.out.println("Movie: " + booking.getSession().getMovie());
                System.out.println("Date: " + booking.getSession().getSessionDate());
                System.out.println("Time: " + booking.getSession().getVenue());
                System.out.println("Amount of seat: " + booking.getSeatsAmount());
                System.out.println("\n");
                count++;
            }
        }
        else{
            System.out.println("Customer has no booking!");
        }
    }

    public void getBookingLists() {
        BookingController bookingController = new BookingController();

        ArrayList<BookingModel> bookingLists = bookingController.getBookingLists();

        String email = null;
        int counter = 0;
        int counterInner = 0;
        if (bookingLists.size() > 0) {
            for(BookingModel bm : bookingLists){
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
