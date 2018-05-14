package Controller;

import Model.SessionModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SessionController {
    public ArrayList<SessionModel> getSessionsByTheatre (String cinemaName) {
        ArrayList<SessionModel> sessions = new ArrayList<SessionModel>();
        try {
            //movies= uSessionFileReader.read(cinemaName);
            File file = new File("cinema.csv");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String venue = st.nextToken();
                if(!venue.equals(cinemaName))
                    continue;
                String movie = st.nextToken();
                String date = st.nextToken();
                String time = st.nextToken();

                SessionModel dataInput_new = new SessionModel(venue, movie, date, time);
                sessions.add(dataInput_new);
            }

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessions;
    }

    public ArrayList<SessionModel> getAllSessions(){
        ArrayList<SessionModel> sessions = new ArrayList<SessionModel>();
        try {
            //movies= uSessionFileReader.read(cinemaName);
            File file = new File("cinema.csv");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String venue = st.nextToken();
                String movie = st.nextToken();
                String date = st.nextToken();
                String time = st.nextToken();

                SessionModel dataInput_new = new SessionModel(venue, movie, date, time);
                sessions.add(dataInput_new);
            }

            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessions;
    }

    public ArrayList getMovieSchedules (String cinemaName, String movieName, ArrayList<SessionModel> sessions) {
        ArrayList<SessionModel> schedules=new ArrayList<SessionModel>();
        int count=1;
        System.out.println(movieName);
        System.out.println("Number\tDate\tTime");
        for (SessionModel session : sessions) {
            if(cinemaName.equals(session.getVenue())&& movieName.equals(session.getMovie())) {
                schedules.add(session);
                System.out.println(count + "\t" + session.getSessionDate() + "\t" + session.getTime());
                count++;
            }
        }
        return schedules;
    }

    public HashSet<String> getMovies(ArrayList<SessionModel> sessions)
    {
        HashSet hs=new HashSet();
        int count=1;
        for (SessionModel session : sessions) {
            if(!hs.contains(session.getMovie()))
            {
                hs.add(session.getMovie());
                count++;
            }
        }
        return hs;
    }

    public ArrayList<SessionModel> getSessionsByMovie (String movieName){
        ArrayList<SessionModel> sessions = new ArrayList<SessionModel>();
        try {
            File file = new File("cinema.csv");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String venue = st.nextToken();
                String movie = st.nextToken();
                if(!movie.equals(movieName))
                    continue;
                String date = st.nextToken();
                String time = st.nextToken();

                SessionModel dataInput_new = new SessionModel(venue, movie, date, time);
                sessions.add(dataInput_new);
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sessions;
    }
}
