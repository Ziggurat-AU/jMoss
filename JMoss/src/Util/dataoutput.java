package Util;

import Model.SessionModel;

import java.util.ArrayList;
import java.util.HashSet;

public class dataoutput {
	public ArrayList display(ArrayList<SessionModel> allData)
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

    public ArrayList showSessions(String cinemaName, String movieName,  ArrayList<SessionModel> movies) {
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
}
