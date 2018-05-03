package View;


import Data.DataPath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Time;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;




class Program {
    String ShowName;
    String ItemDate;
    String ItemTime;

    public Program() {

    }

    public Program(String showName, String itemDate, String itemTime) {
        ShowName = showName;
        ItemDate = itemDate;
        ItemTime = itemTime;
    }
}

class ProgramList {
    String Name;
    List<Program> Programs;

    public ProgramList() {
        Programs = new ArrayList<Program>();
    }

    public void AddProgram(Program program) {
        Programs.add(program);
    }

    public void AddProgram(String showName, String itemDate, String itemTime) {
        Programs.add(new Program(showName, itemDate, itemTime));
    }
}

class Cinema {

    List<ProgramList> programList;

    public Cinema() {
        programList = new ArrayList<ProgramList>();
    }

    public void AddCinemaItems(ProgramList programlist) {
        programList.add(programlist);
    }

    public void AddCinema(String CinemaName, Program program) {
        int idx = FindItem(CinemaName);
        programList.get(idx).Programs.add(program);
    }

    public int FindItem(String CinemaName) {
        int Result = 0;
        for (Iterator<ProgramList> items = programList.iterator(); items.hasNext(); ) {
            if (items.next().Name.equals(CinemaName)) {
                break;
            } else
                Result++;
        }
        return Result;
    }

    public boolean Find(String CinemaName) {
        boolean Result = false;
        for (Iterator<ProgramList> items = programList.iterator(); items.hasNext(); ) {
            if (items.next().Name.equals(CinemaName)) {
                Result = true;
                break;
            }
        }
        return Result;
    }

    public void showCinemaPrograms(int idx) throws Exception {
        for (Iterator<Program> items = programList.get(idx).Programs.iterator(); items.hasNext(); ) {
            Program program = items.next();
            System.out.println(program.ShowName + "\t\t\t" + program.ItemDate + "\t\t" + program.ItemTime);
        }
    }
}

class CinemaList {
    String selectedName = null;
    Cinema cinema;

    public CinemaList() throws Exception {
        loadCinema();
    }

    void loadCinema() throws Exception {
        cinema = new Cinema();
        ProgramList cinemaProgram;
        String File = (new DataPath().dataPath + "/cinema.csv");
        BufferedReader reader = new BufferedReader(new FileReader(File));
        Scanner scanner = null;
        String line = null;
        while ((line = reader.readLine()) != null) {
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            String arr[] = scanner.nextLine().split(",");
            if (!arr[0].isEmpty()) {
                if (!cinema.Find(arr[0])) {
                    cinemaProgram = new ProgramList();
                    cinemaProgram.Name = arr[0];
                    cinemaProgram.AddProgram(new Program(arr[1], arr[2], arr[3]));
                    cinema.AddCinemaItems(cinemaProgram);
                } else {
                    cinema.AddCinema(arr[0], new Program(arr[1], arr[2], arr[3]));
//                    String str_date = arr[2];
//                    java.text.DateFormat formatter;
//                    Date date;
//                    formatter = new java.text.SimpleDateFormat("dd/MM/yyyy");
//                    date = formatter.parse(str_date);
//                    System.out.println(formatter.format(date));
//
//                    Date date2;
//                    str_date = arr[3];
//                    formatter = new java.text.SimpleDateFormat("HH:mm");
//                    date2 = formatter.parse(str_date);
//                    System.out.println(formatter.format(date2));
                }
            }
        }
    }


    public void show() {
        int cinemaID = 64;
        System.out.println("---------------------");
        System.out.println("jMOSS - Cinema Lists ");
        for (Iterator<ProgramList> items = cinema.programList.iterator(); items.hasNext(); ) {
            cinemaID++;
            System.out.println((char) cinemaID + " " + items.next().Name);
        }
        System.out.println("R Return");
        System.out.println("Enter your selection : ");
    }

    public void showCinemas() throws Exception {
        show();
        Scanner sc = new Scanner(System.in);
        while (true) {
            selectedName = sc.next().toUpperCase();
            switch (selectedName) {
                case "R":
                    Login.menu.show();
                    return;
                default:
                    cinema.showCinemaPrograms((int) selectedName.charAt(0) - 65);
                    show();
                    break;
            }
        }
    }
}
