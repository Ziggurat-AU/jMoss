/**
 * 
 */
/**
 * @author zhangjuan
 *
 */
package Controller;


import Model.BookingModel;
import Model.SessionModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BookingController {
    public void saveBooking(BookingModel bookingModel) {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("booking.csv", true);

            fileWriter.append(String.valueOf(bookingModel.getBookingRef()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.getSession().getVenue()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.getSession().getMovie()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.getSession().getSessionDate()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.getSession().getTime()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.getSeatsAmount()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.getCustomerEmail()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.getCustomerSuburb()));
            fileWriter.append(",");
            fileWriter.append(String.valueOf(bookingModel.isCreditCardPayment()));
            fileWriter.append("\n");

            System.out.println("Booking successful");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public int getAvailableSeatAmount(SessionModel sessionModel) {
        int seatsTotal = 0;
        Scanner input = null;
        try {
            File file = new File("booking.csv");
            input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String bookingRef = st.nextToken();
                String cinemaName = st.nextToken();
                String movie = st.nextToken();
                String date = st.nextToken();
                String time = st.nextToken();
                if (!cinemaName.equals(sessionModel.getVenue()) && !movie.equals(sessionModel.getMovie()) && !date.equals(sessionModel.getSessionDate()) && !date.equals(sessionModel.getTime()))
                    continue;
                int seatsAmount = Integer.parseInt(st.nextToken());
                seatsTotal = seatsTotal + seatsAmount;
            }
        } catch (Exception e) {
            System.out.println("Error in the fileScanner !!!");
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error while closing the fileScanner !!!");
                e.printStackTrace();
            }
            return seatsTotal;
        }
    }

    public ArrayList<BookingModel> getCustomerBookings(String customerEmail) {
        Scanner input = null;
        ArrayList<BookingModel> customerBookings = new ArrayList<BookingModel>();

        try {
            File file = new File("booking.csv");
            input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String bookingRef = st.nextToken();
                String cinemaName = st.nextToken();
                String movie = st.nextToken();
                String date = st.nextToken();
                String time = st.nextToken();
                int seatsAmount = Integer.parseInt(st.nextToken());
                String email = st.nextToken();
                if (!email.equals(customerEmail))
                    continue;
                String suburb = st.nextToken();
                Boolean isCreditCardPayment = Boolean.parseBoolean(st.nextToken());

                SessionModel session = new SessionModel(cinemaName, movie, date, time);
                BookingModel booking = new BookingModel(bookingRef, session, email, suburb, seatsAmount, isCreditCardPayment);
                customerBookings.add(booking);
            }
        } catch (Exception e) {
            System.out.println("Error in the fileScanner !!!");
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error while closing the fileScanner !!!");
                e.printStackTrace();
            }
            return customerBookings;
        }
    }

    public ArrayList<BookingModel> getAllBookings() {
        Scanner input = null;
        ArrayList<BookingModel> customerBookings = new ArrayList<BookingModel>();

        try {
            File file = new File("booking.csv");
            input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String bookingRef = st.nextToken();
                String cinemaName = st.nextToken();
                String movie = st.nextToken();
                String date = st.nextToken();
                String time = st.nextToken();
                int seatsAmount = Integer.parseInt(st.nextToken());
                String email = st.nextToken();
                String suburb = st.nextToken();
                Boolean isCreditCardPayment = Boolean.parseBoolean(st.nextToken());

                SessionModel session = new SessionModel(cinemaName, movie, date, time);
                BookingModel booking = new BookingModel(bookingRef, session, email, suburb, seatsAmount, isCreditCardPayment);
                customerBookings.add(booking);
            }
        } catch (Exception e) {
            System.out.println("Error in the fileScanner !!!");
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error while closing the fileScanner !!!");
                e.printStackTrace();
            }
            return customerBookings;
        }
    }

    public ArrayList<BookingModel> getBookingLists() {
        Scanner input = null;
        ArrayList<String> emailLists = new ArrayList<String>();

        ArrayList<BookingModel> customerBookings = new ArrayList<BookingModel>();
        try {
            File file = new File("booking.csv");
            input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                String arr[] = line.split(",");
                if (!emailLists.contains(arr[6]))
                    emailLists.add(arr[6]);
            }

            if (emailLists.size() > 0)
                for (int i = 0; i < emailLists.size(); i++) {
                    customerBookings.addAll(customerBookings.size(), getCustomerBookings(emailLists.get(i)));
                }
        } catch (Exception e) {
            System.out.println("Error in the fileScanner !!!");
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error while closing the fileScanner !!!");
                e.printStackTrace();
            }
            return customerBookings;
        }
    }

    public void deleteBooking(String bookingRef) {
        ArrayList<BookingModel> bookingList = getAllBookings();
        for (BookingModel bookingModel : bookingList) {
            if (bookingModel.getBookingRef().equals(bookingRef))
                bookingList.remove(bookingModel);
        }

        File file = new File("booking.csv");
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                try {
                    if (file.createNewFile()) {
                        for (BookingModel bookingModel : bookingList) {
                            saveBooking(bookingModel);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error deleting file");
                    e.printStackTrace();
                }
            }
        }


    }

}










import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LoginController {
    public boolean auth(String uName,String password) throws IOException {
        String File = ("Login.csv");
        BufferedReader reader = new BufferedReader(new FileReader("Login.csv"));
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
            if(user.equals(uName) && pass.equals(password))
                return true;
            index=0;
        }
        return false;
    }
}










import Model.SessionModel;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SessionController {
    public ArrayList<SessionModel> getSessionsByTheatre (String cinemaName) {
        Scanner input = null;
        ArrayList<SessionModel> sessions = new ArrayList<SessionModel>();
        try {
            File file = new File("cinema.csv");
            input = new Scanner(file);

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
        } catch (Exception e) {
            System.out.println("Error in the fileScanner !!!");
            e.printStackTrace();
        }
        finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error while closing the fileScanner !!!");
                e.printStackTrace();
            }
            return sessions;
        }
    }

    public ArrayList<SessionModel> getAllSessions(){
        Scanner input = null;
        ArrayList<SessionModel> sessions = new ArrayList<SessionModel>();
        try {
            File file = new File("cinema.csv");
            input = new Scanner(file);

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
        } catch (Exception e) {
            System.out.println("Error in the fileScanner !!!");
            e.printStackTrace();
        }
        finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error while closing the fileScanner !!!");
                e.printStackTrace();
            }
            return sessions;
        }
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

    public ArrayList getMovieSchedules (String movieName, ArrayList<SessionModel> sessions) {
        ArrayList<SessionModel> schedules=new ArrayList<SessionModel>();
        int count=1;
        System.out.println(movieName);
        System.out.println("Number\tTheatre\tDate\tTime");
        for (SessionModel session : sessions) {
            if(movieName.equals(session.getMovie())) {
                schedules.add(session);
                System.out.println(count + "\t" + session.getVenue() + "\t" + session.getSessionDate() + "\t" + session.getTime());
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
        Scanner input = null;
        ArrayList<SessionModel> sessions = new ArrayList<SessionModel>();
        try {
            File file = new File("cinema.csv");
            input = new Scanner(file);

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
        } catch (Exception e) {
            System.out.println("Error in the fileScanner !!!");
            e.printStackTrace();
        }
        finally {
            try {
                input.close();
            } catch (Exception e) {
                System.out.println("Error while closing the fileScanner !!!");
                e.printStackTrace();
            }
            return sessions;
        }
    }
}

















































