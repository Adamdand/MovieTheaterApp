package TicketReservationModel;
import java.util.Random;

public class MovieOffering {
	private Theater theater;
	private Movie movie;
	private String time;
	private Seats seating;
	private double price;
	private int ticketId;
	private boolean booked;
	
	
	public MovieOffering(Theater theater, Movie movie, String time, Seats seating, int ticketId) {
		Random rand = new Random();
		this.theater = theater;
		this.movie= movie;
		this.setTime(time);
		this.seating = seating;
		this.price = (13.50)*1.05;
		this.booked = true;
		this.ticketId = rand.nextInt(1000);
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
	

}

