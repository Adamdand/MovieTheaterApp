package BackEnd;

public class MovieOffering {
	private Theater theater;
	private Movie movie;
	private MovieTime time;
	private Seats seating;
	private double price;
	private String ticketId;
	
	public MovieOffering(Theater theater, Movie movie, MovieTime time, Seats seating, double price, String ticketId) {
		this.theater = theater;
		this.movie= movie;
		this.setTime(time);
		this.seating = seating;
		this.price = price;
		this.ticketId = ticketId;
	}
	
	public String printTicket() {
		return "The ticket is: " + theater + " " + movie + " " + seating + "for " + price + ". Ticket ID: " + ticketId;
	}

	public MovieTime getTime() {
		return time;
	}

	public void setTime(MovieTime time) {
		this.time = time;
	}
	
	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	public Movie getMovie() {
		return movie;
	}

	public void setTheater(Movie movie) {
		this.movie = movie;
	}
	
	public Seats getSeating() {
		return seating;
	}

	public void setTheater(Seats seating) {
		this.seating = seating;
	}
	

}
