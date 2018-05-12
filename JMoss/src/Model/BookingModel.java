package Model;

import java.util.UUID;

public class BookingModel {
    private SessionModel session;
    private String customerEmail;
    private boolean creditCardPayment;
    private String bookingRef;
    private String customerSuburb;

    private int seatsAmount;

    public BookingModel(SessionModel session, String customerEmail, String customerSuburb, int seatsAmount, boolean creditCardPayment) {
        this.bookingRef = UUID.randomUUID().toString();
        this.session = session;
        this.customerEmail = customerEmail;
        this.creditCardPayment = creditCardPayment;
        this.customerSuburb = customerSuburb;
        this.seatsAmount = seatsAmount;
    }

    public BookingModel(String bookingRef, SessionModel session, String customerEmail, String customerSuburb, int seatsAmount, boolean creditCardPayment) {
        this.bookingRef = bookingRef;
        this.session = session;
        this.customerEmail = customerEmail;
        this.creditCardPayment = creditCardPayment;
        this.customerSuburb = customerSuburb;
        this.seatsAmount = seatsAmount;
    }

    public SessionModel getSession() {
        return session;
    }

    public void setSession(SessionModel session) {
        this.session = session;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isCreditCardPayment() {
        return creditCardPayment;
    }

    public void setCreditCardPayment(boolean creditCardPayment) {
        this.creditCardPayment = creditCardPayment;
    }

    public String getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(String bookingNo) {
        this.bookingRef = bookingNo;
    }

    public String getCustomerSuburb() {
        return customerSuburb;
    }

    public void setCustomerSuburb(String customerSuburb) {
        this.customerSuburb = customerSuburb;
    }

    public int getSeatsAmount() {
        return seatsAmount;
    }

    public void setSeatsAmount(int seatsAmount) {
        this.seatsAmount = seatsAmount;
    }

}
