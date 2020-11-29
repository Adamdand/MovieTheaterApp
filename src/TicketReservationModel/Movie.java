package TicketReservationModel;

public class Movie {
	private String movieName;
	
	public String printMovie() {
		String test="";
		return test;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	
	@Override
	public String toString() {
		return "playing " + movieName;
	}
}
