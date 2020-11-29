package BackEnd;
import java.util.Random;

public class MovieOffering {
	private Theater theater;
	private Movie movie;
	private MovieTime time;
	private Seats seating;
	private double price;
	private String ticketId;
	private boolean booked;
	
	
	public MovieOffering(Theater theater, Movie movie, MovieTime time, Seats seating, String ticketId) {
		Random rand = new Random();
		this.theater = theater;
		this.movie= movie;
		this.setTime(time);
		this.seating = seating;
		this.price = (13.50)*1.05;
		this.booked = true;
		this.ticketId = Integer.toString(rand.nextInt(1000000));
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

	public boolean isBooked() {
		return booked;
	}

	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	

}

