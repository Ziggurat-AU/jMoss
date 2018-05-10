package Model;

import java.util.UUID;

public class BookingModel {
    private SessionModel session;
    private String customerEmail;
    private boolean creditCardPayment;
    private String bookingRef;
    private String customerSuburb;

    public BookingModel(SessionModel session, String customerEmail, String customerSuburb, boolean creditCardPayment) {
        this.bookingRef = UUID.randomUUID().toString();
        this.session = session;
        this.customerEmail = customerEmail;
        this.creditCardPayment = creditCardPayment;
        this.customerSuburb = customerSuburb;
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

}
