package Model;

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
