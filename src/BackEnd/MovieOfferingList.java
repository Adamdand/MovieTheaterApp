package BackEnd;

import java.util.ArrayList;
import java.util.Date;

public class MovieOfferingList {
	/**
	 * OrderLine generated
	 */
	private ArrayList<MovieOffering> movieOfferingList;
	
	public MovieOfferingList(ArrayList<MovieOffering> movieOfferingList) {
		this.movieOfferingList = movieOfferingList;
	}
	

	public void addClient(MovieOffering movieOffering) {
		movieOfferingList.add(movieOffering);
	}
	
	public void removeClient(MovieOffering movieOffering) {
		movieOfferingList.remove(movieOffering);
	}
	
	public MovieOffering searchMovie(String name) {
		for (MovieOffering i: movieOfferingList) {
			if (i.getMovie().getMovieName() == name)
				return i;
		}
		return null;
	}
	
	public MovieOffering searchTheater(String name) {
		for (MovieOffering i: movieOfferingList) {
			if (i.getTheater().getTheaterName() == name)
				return i;
		}
		return null;
	}
	
	public MovieOffering searchTime(Date time) {
		for (MovieOffering i: movieOfferingList) {
			if (i.getTime().getTime() == time)
				return i;
		}
		return null;
	}
	
	public MovieOffering searchMovieOffering(String movieName, String theaterName, Date time) {
		for (MovieOffering i: movieOfferingList) {
			if (i.getMovie().getMovieName() == movieName && i.getTheater().getTheaterName() == theaterName && i.getTime().getTime() == time)
				return i;
		}
		return null;
	}
	
	public ArrayList<Seats> viewSeating(MovieOffering movieOffering) {
		ArrayList<Seats> seat = new ArrayList<Seats>();
		for (MovieOffering i: movieOfferingList) {
			if (i.getMovie().getMovieName() == movieOffering.getMovie().getMovieName())
				seat.add(i.getSeating());
		}
		return null;
	}
	
public MovieOffering chooseSeating(Seats seats) {
	for (MovieOffering i: movieOfferingList) {
		if (i.getSeating().getColumn() == seats.getColumn() && i.getSeating().getRow() == seats.getRow())
			return i;
	}
	return null;
	}
	
}
