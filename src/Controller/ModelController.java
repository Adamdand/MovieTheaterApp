package Controller;

import java.util.ArrayList;

import DatabaseController.*;
import PaymentModel.*;
import RegisteredUserModel.*;
import TicketReservationModel.*;

public class ModelController {
	private MovieOfferingList movies;
	private ProcessCancellation cancel;
	private ProcessPayment payment;
	private RegisteredUserList users;
	private DBController database;
	private ArrayList<MovieOffering> soldTickets;
	
	public ModelController(MovieOfferingList movies, ProcessCancellation cancel, ProcessPayment payment, RegisteredUserList users, DBController database) {
		setMovies(movies);
		setCancel(cancel);
		setPayment(payment);
		setUsers(users);
		setDatabase(database);
	}
	public void checkoutSeats(ArrayList<MovieOffering> soldTickets) {
		this.soldTickets = soldTickets;
		for(MovieOffering o:soldTickets) {
			o.setBooked(true);
		}
	}
	//TODO: add necessary methods
	public boolean makeCardPayment(String card,String email,double price) {
		boolean paymentFullfilled = payment.payCard(card, price);
		if(paymentFullfilled) {
			payment.generateReceipt(soldTickets, email, price);
		}
		return paymentFullfilled;
	}
	public double redeemVoucher(int id, String email, double price) {
		double remain = payment.payVoucher(id, price);
		if(remain==0) {
			payment.generateReceipt(soldTickets, email, price);
			return 0;
		}
		return remain;
	}
	public ArrayList<MovieOffering> viewAllUniqueOfferings(){
		//need to be added to the MovieOfferingList()
		return movies.getMovieOfferingListNoSeats();
	}
	public ArrayList<MovieOffering> viewAllOfferings(){
		//need to be added to the MovieOfferingList()
		return movies.getAllOfferings();
	}
	public String makeCancellationRegistered(int ticketId, String cardNumber) {
		String response = "";
		//need a ticket search method
		MovieOffering ticket = movies.searchMovieOfferingTicket(ticketId);
		
		if (ticket != null) {
			//need to add date to cancellation receipts
			//need a getter for price
			response = cancel.refundTicketRegistered(ticket.getPrice(), ticketId, cardNumber);
			if (response.contains("refunded")) {
				ticket.setBooked(false);
			}
		} else {
			response = "Ticket does not exist";
		}

		return response;
	}
	
	public String makeCancellationRegular(int ticketId) {
		String response = "";
		//need a ticket search method
		MovieOffering ticket = movies.searchMovieOfferingTicket(ticketId);
		
		if (ticket != null) {
			//need to add date to cancellation receipts
			//need a getter for price
			response = cancel.refundTicketRegular(ticket.getPrice(), ticketId);
		} else {
			response = "Ticket does not exist";
		}

		return response;
	}
	
	public String register(String userName, String password, String creditCard) {
		String response = "";
		
		//check if registered user exists
		if (users.userExists(userName)) {
			response = "User already exists";
		} else {
			//attempt payment
			if (payment.payCard(creditCard, 10)) {
				
				//if payment is successful, go through with the registration
				String start = java.time.LocalDate.now().toString();
				String end = java.time.LocalDate.now().plusDays(365).toString();
				int startDate = Integer.parseInt(start.replace("-",""));
				int endDate = Integer.parseInt(end.replace("-",""));
				RegisteredUser user = new RegisteredUser(userName, password, creditCard, startDate, endDate);
				users.addUser(user);
				payment.generateReceiptFee(10, endDate, userName);
				
				response = "User sucessfully added";
			} else {
				response = "Insufficient funds";
			}
		}
		
		return response;
	}
	public boolean addNewVoucher(int id, double value) {
		return payment.getVoucherIdentifier().addVoucher(id, value);
	}
	public ArrayList<MovieOffering> viewTheater(String name){
		return movies.searchTheater(name);
	}
	
	public ArrayList<MovieOffering> viewMovies(String name){
		return movies.searchMovie(name);
	}
	
	public ArrayList<MovieOffering> viewTimes(String time){
		return movies.searchTime(time);
	}
	
	public MovieOffering chooseSeat(String movieName, String theaterName, MovieTime time, Seats seat){
		return movies.chooseOffering(movieName, theaterName, time, seat);
	}
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
