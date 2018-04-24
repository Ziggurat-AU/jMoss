import java.util.Date;

public class DataInput {
	private String _Venue;
	private String _Movie;
	private Date _SessionDate;
	private String _Time;
	
	public DataInput(String venue, String movie, Date Sessiondate, String time) {
		_Venue = venue;
		_Movie = movie;
		_SessionDate = Sessiondate;
		
	}

	public String getVenue() {
		return _Venue;
	}

	public String getMovie() {
		return _Movie;
	}

	public Date getSessionDate() {
		return _SessionDate;
	}
	
	public String getTime() {
		return _Time;
	}

	
}
