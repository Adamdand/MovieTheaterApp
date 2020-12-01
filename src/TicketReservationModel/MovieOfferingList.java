package TicketReservationModel;

import java.util.ArrayList;

public class MovieOfferingList {
	/**
	 * OrderLine generated
	 */
	private ArrayList<MovieOffering> movieOfferingList;
	private ArrayList<MovieOffering> movieOfferingListNoSeats;
	
	public MovieOfferingList(ArrayList<MovieOffering> movieOfferingList, ArrayList<MovieOffering> movieOfferingListNoSeats) {
		this.movieOfferingList = movieOfferingList;
		this.movieOfferingListNoSeats = movieOfferingListNoSeats;
	}
	
	public ArrayList<MovieOffering> getMovieOfferingListNoSeats(){
		return movieOfferingListNoSeats;
	}
	
	public ArrayList<MovieOffering> setMovieOfferingListNoSeats(ArrayList<MovieOffering> movieOfferingListNoSeats){
		return this.movieOfferingListNoSeats = movieOfferingListNoSeats;
	}
	

	public void addMovieOfferinng(MovieOffering movieOffering) {
		movieOfferingList.add(movieOffering);
	}
	
	public void removeMovieOffering(MovieOffering movieOffering) {
		movieOfferingList.remove(movieOffering);
	}
	
	public ArrayList<MovieOffering> searchMovie(String name) {
		ArrayList<MovieOffering> listOffering = new ArrayList<MovieOffering>();
		for (MovieOffering i: movieOfferingListNoSeats) {
			if (i.getMovie().getMovieName().equals(name))
				listOffering.add(i);
		}
		return listOffering;
	}
	
	public ArrayList<MovieOffering> searchTheater(String name) {
		ArrayList<MovieOffering> listOffering = new ArrayList<MovieOffering>();
		for (MovieOffering i: movieOfferingListNoSeats) {
			if (i.getTheater().getTheaterName().equals(name))
				listOffering.add(i);
		}
		return listOffering;
	}
	
	public ArrayList<MovieOffering> searchTime(String time) {
		ArrayList<MovieOffering> listOffering = new ArrayList<MovieOffering>();
		for (MovieOffering i: movieOfferingListNoSeats) {
			if (i.getTime().equals(time))
				listOffering.add(i);
		}
		return listOffering;
	}
	
	public MovieOffering searchMovieOffering(String movieName, String theaterName, MovieTime time) {
		for (MovieOffering i: movieOfferingListNoSeats) {
			if (i.getMovie().getMovieName().equals(movieName) && i.getTheater().getTheaterName().equals(theaterName) && i.getTime().equals(time.getTime()));
				return i;
		}
		return null;
	}
	
//	public ArrayList<Seats> viewSeating(MovieOffering movieOffering) {
//		ArrayList<Seats> seat = new ArrayList<Seats>();
//		for (MovieOffering i: movieOfferingList) {
//			if (i.getMovie().getMovieName() == movieOffering.getMovie().getMovieName())
//				seat.add(i.getSeating());
//		}
//		return null;
//	}
	
	public MovieOffering chooseOffering(String movieName, String theaterName, MovieTime time, Seats seat) {
	for (MovieOffering i: movieOfferingList) {
		if (i.getMovie().getMovieName().equals(movieName) && i.getTheater().getTheaterName().equals(theaterName) && i.getTime().equals(time.getTime()) && i.getSeating().getColumn()==seat.getColumn() && i.getSeating().getRow() == seat.getRow())
			return i;
	}
	return null;
	}
	
	public MovieOffering searchMovieOfferingTicket(int ticketId) {
		for (MovieOffering i: movieOfferingList) {
			if (i.getTicketId() == ticketId)
				return i;
		}
		return null;
	}
	public ArrayList<MovieOffering> getAllOfferings(){
		return movieOfferingList;
	}
}
