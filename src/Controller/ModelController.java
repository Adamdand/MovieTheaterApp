package Controller;

import java.text.DecimalFormat;
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
	private RegisteredUser user;
	
	public ModelController(MovieOfferingList movies, ProcessCancellation cancel, ProcessPayment payment, RegisteredUserList users, DBController database) {
		setMovies(movies);
		setCancel(cancel);
		setPayment(payment);
		setUsers(users);
		setDatabase(database);
	}
	
	public void loadSeats(ArrayList<MovieOffering> seats) {
		this.soldTickets = seats;
	}
	
	public void checkoutSeats(ArrayList<MovieOffering> soldTickets) {
		this.soldTickets = soldTickets;
		for(MovieOffering o:soldTickets) {
			o.setBooked(true);
		}
	}

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
		return movies.getMovieOfferingListNoSeats();
	}
	public ArrayList<MovieOffering> viewAllOfferings(){
		return movies.getAllOfferings();
	}
	public String makeCancellationRegistered(int ticketId, String cardNumber) {
		String response = "";
		MovieOffering ticket = movies.searchMovieOfferingTicket(ticketId);
		
		if (ticket != null) {
			if (!ticket.isBooked()) {
				response = "Ticket has not been booked";
				return response;
			}
			
			String endDate = java.time.LocalDate.now().plusDays(3).toString();
			int refundDay = Integer.parseInt(endDate.replace("-",""));
			
			if ((ticket.getMovieDate() <= refundDay)) {
				response = "You can only refund before 72 hours of the movie date";
				return response;
			}
			
			
			double myNumber = ticket.getPrice();
			DecimalFormat df = new DecimalFormat("####.##");
			
			String numberString = df.format(myNumber);
			double myNumber2 = Double.parseDouble(numberString);
			
			response = cancel.refundTicketRegistered(myNumber2, ticketId, cardNumber);
			if (response.contains("Refunded")) {
				ticket.setBooked(false);
			}
		} else {
			response = "Ticket does not exist";
		}

		return response;
	}
	
	public String makeCancellationRegular(int ticketId) {
		String response = "";
		MovieOffering ticket = movies.searchMovieOfferingTicket(ticketId);
		
		if (ticket != null) {
			if (!ticket.isBooked()) {
				response = "Ticket has not been booked";
				return response;
			}
			
			String endDate = java.time.LocalDate.now().plusDays(3).toString();
			int refundDay = Integer.parseInt(endDate.replace("-",""));
			
			if ((ticket.getMovieDate() <= refundDay)) {
				response = "You can only refund before 72 hours of the movie date";
				return response;
			}
			
			double myNumber = ticket.getPrice()*0.85;
			DecimalFormat df = new DecimalFormat("####.##");
			
			String numberString = df.format(myNumber);
			double myNumber2 = Double.parseDouble(numberString);
			
			response = cancel.refundTicketRegular(myNumber2, ticketId);
			if (response.contains("Refunded")) {
				ticket.setBooked(false);
			}
		} else {
			response = "Ticket does not exist";
		}

		return response;
	}
	
	public String register(String userName, String password, String creditCard) {
		String response = "";
		
		if (userName.isEmpty()) {
			response = "Username field is empty";
			return response;
		}
		
		if (password.isEmpty()) {
			response = "Password field is empty";
			return response;
		}
		
		if (!creditCard.matches("[0-9]+") || creditCard.length() != 16) {
			response = "Credit card format is incorrect";
			return response;
		}
		
		if (!userName.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
			response = "Email format is incorrect";
			return response;
		}
		
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
				
				response = "User successfully added";
			} else {
				response = "Insufficient funds";
			}
		}
		
		return response;
	}
	
	public String verifyLogin(String userName, String password) {
		RegisteredUser user = users.verifyUser(userName, password);
		
		
		if (user == null) {
			return "Login failed. Please check your username and password.";
		} else {
			setUser(user);
			return "Welcome " + user.getUserName();
		}
		
	}
	
	public String renewUser() {
		String response = "";
		if (payment.payCard(user.getCreditCard(), 10)) {
			user.renewUser();
			payment.generateReceiptFee(10, user.getSubEnd(), user.getUserName());
			
			response = "Membership extended";
		} else {
			response = "Insufficient funds";
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
	public RegisteredUser getUser() {
		return user;
	}
	public void setUser(RegisteredUser user) {
		this.user = user;
	}

}
