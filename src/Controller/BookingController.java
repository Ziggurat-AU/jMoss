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
        File file = new File("booking.csv");

        ArrayList<BookingModel> bookingList = getAllBookings();
        for (BookingModel bookingModel : bookingList) {
            if (bookingModel.getBookingRef().equals(bookingRef)) {
                if (bookingList.size() == 1) {
                    if (file.exists() && file.isFile()) {
                        if (file.delete()) {
                            try {
                                file.createNewFile();
                                return;
                            } catch (Exception e) {
                                System.out.println("Error deleting file");
                                e.printStackTrace();
                            }
                        }
                    }
                }
                else {
                    bookingList.remove(bookingModel);
                }
            }
        }

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
