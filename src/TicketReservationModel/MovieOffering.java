package TicketReservationModel;
//import java.util.Random;

public class MovieOffering {
	private Theater theater;
	private Movie movie;
	private String time;
	private Seats seating;
	private double price;
	private int ticketId;
	private boolean booked;
	private int movieDate;
	
	
	public MovieOffering(Theater theater, Movie movie,  int movieDate, String time, Seats seating, int ticketId) {
//		Random rand = new Random();
		this.setMovieDate(movieDate);
		this.theater = theater;
		this.movie= movie;
		this.setTime(time);
		this.seating = seating;
//		this.price = (13.50)*1.05;
		this.price = 14.18;
		this.booked = false;
//		this.ticketId = rand.nextInt(1000);
		this.ticketId = ticketId;
	}
	
	public MovieOffering(Theater theater, Movie movie, int movieDate, String time, int ticketId) {
//		Random rand = new Random();
		this.theater = theater;
		this.setMovieDate(movieDate);
		this.movie= movie;
		this.setTime(time);
//		this.price = (13.50)*1.05;
		this.price = 14.18;
		this.booked = false;
//		this.ticketId = rand.nextInt(1000);
		this.ticketId = ticketId;
	}
	
	@Override
	public String toString() {
		String year = Integer.toString(movieDate).substring(0, 4);
		String month = Integer.toString(movieDate).substring(4, 6);
		String day = Integer.toString(movieDate).substring(6, 8);
		String date = year + "-" + month + "-" + day;
		return theater.getTheaterName() + " " + movie.toString() + " " + time + " " + date;
	}
	
	public String printTicket() {
		return "The ticket is: " + theater + " " + movie + " " + seating + "for " + price + ". Ticket ID: " + ticketId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
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
	
	public int getTicketId() {
		return ticketId;
	}
	
	public double getPrice() {
		return price;
	}

	public int getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(int movieDate) {
		this.movieDate = movieDate;
	}
	

}

