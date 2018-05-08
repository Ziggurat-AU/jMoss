package Model;

public class BookingModel {
    private SessionModel session;
    private String customerEmail;
    private boolean creditCardPayment;
    private int bookingNo;

    public BookingModel(SessionModel session, String customerEmail, boolean creditCardPayment, int bookingNo) {
        this.session = session;
        this.customerEmail = customerEmail;
        this.creditCardPayment = creditCardPayment;
        this.bookingNo = bookingNo;
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

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }
}
