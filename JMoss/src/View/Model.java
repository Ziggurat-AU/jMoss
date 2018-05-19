package View;

public class Model {

	public class SessionModel {

		private String venue;
		private String movie;
		private String date;
		private int time;

		public SessionModel(String venue, String movie, String date, int time) {
			
			this.venue = venue ;
			this.movie = movie ;
			this.date = date;
			this.time = time ;
			
		}

		public SessionModel(String venue, String movie, String date) {
			this.venue = venue ;
			this.movie = movie ;
			this.date = date;
			
			
			
		}

		public SessionModel(String venue2, String movie2, String date2, String time2) {
	
		}

		public Object getVenue() {
		
			return venue;
		}

		public Object getMovie() {
	
			return movie;
		}
		
		public String getSessionDate() {
			
			return date;
		}
		
		

		public int getTime() {
	
			return time;
		}

	

	}

}
