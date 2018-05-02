package View;


import Data.DataPath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    int id;
    ArrayList<String> name;

    void loadCinema() throws Exception
    {
        name = new ArrayList<String>();
        String File = (new DataPath().dataPath + "/cinema.csv");
        BufferedReader reader = new BufferedReader(new FileReader(File));
        Scanner scanner = null;
        String line = null;
        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            String arr[] = scanner.nextLine().split(",");
            if (!arr[0].isEmpty())
              if (!name.contains(arr[0]))
                name.add(arr[0]);
        }
    }

    public void showCinemas() throws Exception{
        int cinemaID = 0;
        loadCinema();
        System.out.println("jMOSS - Cinema Lists ");
        System.out.println("---------------------");
        for (int i = 0; i < name.size(); i++){
            cinemaID++;
            System.out.println(cinemaID + " " + name.get(i));
        }
    }
}
