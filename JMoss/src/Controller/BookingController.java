package Controller;

import Model.BookingModel;
import Model.SessionModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
        try {
            //movies= uSessionFileReader.read(cinemaName);
            File file = new File("booking.csv");
            Scanner input = new Scanner(file);

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
            e.printStackTrace();
        }
        finally {
            return seatsTotal;
        }
    }

    public ArrayList<BookingModel> getCustomerBookings (String customerEmail){
        ArrayList<BookingModel> customerBookings = new ArrayList<BookingModel>();
        try {
            File file = new File("booking.csv");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                String bookingRef = st.nextToken();
                String cinemaName = st.nextToken();
                String movie = st.nextToken();
                String date = st.nextToken();
                String time = st.nextToken();
                int seatsAmount = 1;// Integer.parseInt(st.nextToken());
                String email = st.nextToken();
                //if (!email.equals(customerEmail))
                //    continue;
                String suburb = st.nextToken();
                Boolean isCreditCardPayment = Boolean.parseBoolean(st.nextToken());

                SessionModel session = new SessionModel(cinemaName,movie,date,time);
                BookingModel booking = new BookingModel(bookingRef, session,email,suburb, seatsAmount,isCreditCardPayment);
                customerBookings.add(booking);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return customerBookings;
        }
    }

    public ArrayList<BookingModel> getBookingLists (){
        ArrayList<String> emailLists = new ArrayList<String>();

        ArrayList<BookingModel> customerBookings = new ArrayList<BookingModel>();
        try {
            File file = new File("booking.csv");
            Scanner input = new Scanner(file);

            while (input.hasNext()) {
                String line = input.nextLine();
                String arr[] = line.split(",");
                if (!emailLists.contains(arr[5]))
                    emailLists.add(arr[5]);
            }

            if (emailLists.size() > 0)
            for (int i =0; i < emailLists.size(); i++) {
                customerBookings.addAll(customerBookings.size(),getCustomerBookings(emailLists.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            return customerBookings;
        }
    }
}
