package TicketReservationModel;

public class movieOfferingAdam {
	
	private String theaterName;
	private String movieName;
	private String movieTime;
	
	public movieOfferingAdam(String theater, String movie, String time) {
		setTheaterName(theater);
		setMovieName(movie);
		setMovieTime(time);
		
		
	}

	public int getOfferingID() {
		return offeringID;
	}

	public void setOfferingID(int offeringID) {
		this.offeringID = offeringID;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	
	public String toString() {
		return ("theater Name: " + theaterName + ", movie Name" + movieName + ", movie Time " + movieTime + "\n");
	}

}
