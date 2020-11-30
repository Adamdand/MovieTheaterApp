package Controller;

import java.util.ArrayList;

import DatabaseController.DBController;
import PaymentModel.ProcessCancellation;
import PaymentModel.ProcessPayment;
import RegisteredUserModel.RegisteredUserList;
import TicketReservationModel.MovieOffering;
import TicketReservationModel.MovieOfferingList;
import TicketReservationModel.MovieTime;
import TicketReservationModel.Seats;

public class ModelController {
	private MovieOfferingList movies;
	private ProcessCancellation cancel;
	private ProcessPayment payment;
	private RegisteredUserList users;
	private DBController database;
	
	public ModelController(MovieOfferingList movies, ProcessCancellation cancel, ProcessPayment payment, RegisteredUserList users, DBController database) {
		setMovies(movies);
		setCancel(cancel);
		setPayment(payment);
		setUsers(users);
		setDatabase(database);
	}
	
	ArrayList<MovieOffering> viewTheater(String name){
		return movies.searchTheater(name);
	}
	
	ArrayList<MovieOffering> viewMovies(String name){
		return movies.searchMovie(name);
	}
	
	ArrayList<MovieOffering> viewTimes(MovieTime time){
		return movies.searchTime(time);
	}
	
	MovieOffering chooseSeat(String movieName, String theaterName, MovieTime time, Seats seat){
		return movies.chooseOffering(movieName, theaterName, time, seat);
	}
	
	//TODO: add necessary methods

	public DBController getDatabase() {
		return database;
	}

	public void setDatabase(DBController database) {
		this.database = database;
	}

	public RegisteredUserList getUsers() {
		return users;
	}

	public void setUsers(RegisteredUserList users) {
		this.users = users;
	}

	public ProcessPayment getPayment() {
		return payment;
	}

	public void setPayment(ProcessPayment payment) {
		this.payment = payment;
	}

	public ProcessCancellation getCancel() {
		return cancel;
	}

	public void setCancel(ProcessCancellation cancel) {
		this.cancel = cancel;
	}

	public MovieOfferingList getMovies() {
		return movies;
	}

	public void setMovies(MovieOfferingList movies) {
		this.movies = movies;
	}

}
