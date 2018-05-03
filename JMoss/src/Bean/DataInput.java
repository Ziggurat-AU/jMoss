package Bean;

import java.util.Date;

public class DataInput {
	private String _Venue;
	private String _Movie;
	private String _SessionDate;
	private String _Time;
	
	public DataInput(String venue, String movie, String Sessiondate, String time) {
		_Venue = venue;
		_Movie = movie;
		_SessionDate = Sessiondate;
		_Time= time;
		
	}

	public String getVenue() {
		return _Venue;
	}

	public String getMovie() {
		return _Movie;
	}

	public String getSessionDate() {
		return _SessionDate;
	}
	
	public String getTime() {
		return _Time;
	}

}
