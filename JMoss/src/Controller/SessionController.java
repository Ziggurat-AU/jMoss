package Controller;

import Model.SessionModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SessionController {
    public ArrayList<SessionModel> showMovies(String cinemaName) throws Exception {
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

    public ArrayList showSessions(String cinemaName, String movieName, ArrayList<SessionModel> movies) {
        ArrayList arrayList=new ArrayList();
        int count=1;
        System.out.println(movieName);
        for (SessionModel inputs : movies) {
            if(cinemaName.equals(inputs.getVenue())&& movieName.equals(inputs.getMovie())) {
                arrayList.add(inputs.getSessionDate()+" "+ inputs.getTime());
                System.out.println(count + " " + inputs.getSessionDate() + " " + inputs.getTime());
                count++;
            }
        }
        return arrayList;
    }

    public ArrayList getMovies(ArrayList<SessionModel> allData)
    {
        HashSet hs=new HashSet();
        ArrayList arrayList=new ArrayList();
        int count=1;
        for (SessionModel inputs : allData) {
            if(!hs.contains(inputs.getMovie()))
            {
                hs.add(inputs.getMovie());
                arrayList.add(inputs.getMovie());
                System.out.println(count+" "+ inputs.getMovie());
                count++;
            }
        }
        return arrayList;
    }
}