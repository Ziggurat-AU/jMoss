package View;

import Controller.SessionController;
import Model.SessionModel;

import java.util.ArrayList;
import java.util.Scanner;

public class BookingView {
    public BookingView(String cinemaName) throws Exception{
        Scanner sc=new Scanner(System.in);
        SessionController sessionController=new SessionController();
        ArrayList<SessionModel> movies = new ArrayList<SessionModel>();
        System.out.println("Welcome to jMOSS- Java based Movie Search System");
        System.out.println("------------------------------------------------");
        System.out.println("Movies Playing at this cinema are:");
        movies=sessionController.showMovies(cinemaName);
        ArrayList arrayList=new ArrayList();
        int movieChoice;
        do {
            arrayList= sessionController.getMovies(movies);
            System.out.println("Enter your choice for you want to display the sessions for");
            movieChoice=sc.nextInt();
        }while(movieChoice<1||movieChoice>arrayList.size());
        int sessionChoice;
        ArrayList sessions;
        do {
            String movieName = (String) arrayList.get(movieChoice - 1);
            sessions = new ArrayList();
            sessions = sessionController.showSessions(cinemaName, movieName, movies);
            sessionChoice=sc.nextInt();
        }while(sessionChoice<1||sessionChoice> sessions.size());
    }
}
