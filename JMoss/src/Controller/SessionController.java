package Controller;

import Model.SessionModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SessionController {
    public ArrayList<SessionModel> getSessions(String cinemaName) {
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

    public ArrayList getMovieSchedules (String cinemaName, String movieName, ArrayList<SessionModel> sessions) {
        ArrayList<SessionModel> schedules=new ArrayList<SessionModel>();
        int count=1;
        System.out.println(movieName);
        for (SessionModel session : sessions) {
            if(cinemaName.equals(session.getVenue())&& movieName.equals(session.getMovie())) {
                schedules.add(session);
                System.out.println(count + " " + session.getSessionDate() + " " + session.getTime());
                count++;
            }
        }
        return schedules;
    }

    public ArrayList getMovies(ArrayList<SessionModel> sessions)
    {
        HashSet hs=new HashSet();
        ArrayList movies=new ArrayList();
        int count=1;
        for (SessionModel session : sessions) {
            if(!hs.contains(session.getMovie()))
            {
                hs.add(session.getMovie());
                movies.add(session.getMovie());
                System.out.println(count+" "+ session.getMovie());
                count++;
            }
        }
        return movies;
    }
}
