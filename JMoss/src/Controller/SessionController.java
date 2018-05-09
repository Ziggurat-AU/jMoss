package Controller;

import Model.SessionModel;
import Util.SessionFileReader;

import java.util.ArrayList;

public class SessionController {
    public ArrayList<SessionModel> showMovies(String cinemaName) throws Exception {
        ArrayList<SessionModel> movies = new ArrayList<SessionModel>();
        SessionFileReader uSessionFileReader =new SessionFileReader();
        try {
            movies= uSessionFileReader.read(cinemaName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList showSessions(String cinemaName, String movieName, ArrayList<SessionModel> movies) {
        SessionFileReader sessionFileReader=new SessionFileReader();
        return sessionFileReader.showSessions(cinemaName,movieName,movies);
    }
}
