package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import Data.DataPath;

public class LoginFileReading {

    public boolean auth(String uName,String password) throws IOException {
        String File = (new DataPath().dataPath + "/Login.csv");
        BufferedReader reader = new BufferedReader(new FileReader(File));
        Scanner scanner = null;
        String line = null;
        int index = 0;
        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            String user=null;
            String pass=null;
            while (scanner.hasNext()) {
                String data = scanner.next();

                if(index == 0)
                 user = data;
                else
                    pass = data;

                index++;
            }


            if(user.equals(uName)&&pass.equals(password))
                    return true;
            index=0;
        }
        return false;
    }



}
