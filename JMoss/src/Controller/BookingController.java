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
            fileWriter = new FileWriter("booking.csv");

                fileWriter.append(String.valueOf(bookingModel.getBookingRef()));
                fileWriter.append(",");
                fileWriter.append(bookingModel.getCustomerEmail());
//            fileWriter.append(",");
//                fileWriter.append(bookingModel.get);
//            fileWriter.append(",");
//                fileWriter.append(student.getGender());
//            fileWriter.append(",");
//                fileWriter.append(String.valueOf(student.getAge()));
//            fileWriter.append(",");
            fileWriter.append("\n");


            System.out.println("CSV file was created successfully !!!");

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

//    public boolean isAvailable(SessionModel sessionModel) throws Exception{
//        try {
//            //movies= uSessionFileReader.read(cinemaName);
//            File file = new File("booking.csv");
//            Scanner input = new Scanner(file);
//
//            while (input.hasNext()) {
//                String line = input.nextLine();
//                StringTokenizer st = new StringTokenizer(line, ",");
//                String venue = st.nextToken();
//                if(!venue.equals(cinemaName))
//                    continue;
//                String movie = st.nextToken();
//                String date = st.nextToken();
//                String time = st.nextToken();
//
//                SessionModel dataInput_new = new SessionModel(venue, movie, date, time);
//                sessions.add(dataInput_new);
//            }
//    }

}
