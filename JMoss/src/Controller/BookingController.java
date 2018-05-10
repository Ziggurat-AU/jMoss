package Controller;

import Model.BookingModel;
import Model.SessionModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BookingController {
    public void saveBooking(BookingModel bookingModel) throws Exception{
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

    public boolean isAvailable(SessionModel sessionModel) throws Exception {
        try {
            //movies= uSessionFileReader.read(cinemaName);
            File file = new File("booking.csv");
            Scanner input = new Scanner(file);
            int count = 0;

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
                count++;
            }
            return (count < 20);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
