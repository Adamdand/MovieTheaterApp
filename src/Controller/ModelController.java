package Controller;

import DatabaseController.DBController;
import PaymentModel.ProcessCancellation;
import PaymentModel.ProcessPayment;
import RegisteredUserModel.RegisteredUserList;
import TicketReservationModel.MovieOfferingList;

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
