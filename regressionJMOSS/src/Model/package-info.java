/**
 * 
 */
/**
 * @author zhangjuan
 *
 */
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










public class SessionModel {
	private String venue;
	private String movie;
	private String sessionDate;
	private String time;
	
	public SessionModel(String venue, String movie, String sessionDate, String time) {
		this.venue = venue;
		this.movie = movie;
		this.sessionDate = sessionDate;
		this.time= time;
	}

	public String getVenue() {
		return venue;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public String getSessionDate() {
		return sessionDate;
	}

	public void setSessionDate(String sessionDate) {
		this.sessionDate = sessionDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getMovie() {
		return movie;
	}

}





























