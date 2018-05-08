package Controller;

import Model.SessionModel;
import Util.DataReader;
import Util.LoginFileReading;
import Util.dataoutput;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {
    public boolean checkLogin(String uName,String password) throws IOException {
        LoginFileReading uLoginFileReading=new LoginFileReading();
        return uLoginFileReading.auth(uName,password);
    }

    public ArrayList<SessionModel> showMovies(String cinemaName) throws Exception {
        ArrayList<SessionModel> movies = new ArrayList<SessionModel>();
        DataReader uDataReader=new DataReader();
        try {
            movies=uDataReader.read(cinemaName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList showSessions(String cinemaName, String movieName, ArrayList<SessionModel> movies) {
        dataoutput udataoutput=new dataoutput();
        return udataoutput.showSessions(cinemaName,movieName,movies);
    }
}
