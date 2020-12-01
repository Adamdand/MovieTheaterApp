package Controller;

import java.util.ArrayList;
import java.util.Hashtable;

import DatabaseController.DBController;
import FinanceController.*;
import PaymentModel.*;
import TicketReservationModel.*;
import View.LoginGUI;
import ViewController.LoginGUIController;
import RegisteredUserModel.*;

public class Main {
	private static DBController database = new DBController();
	
	private static MovieOfferingList loadMovies() {
		ArrayList<MovieOffering> movieList = database.loadMovies();
		ArrayList<MovieOffering> movieListNoSeats = database.loadMoviesNoSeats();
		MovieOfferingList movies = new MovieOfferingList(movieList, movieListNoSeats);
		
		return movies;
	}
	
	private static RegisteredUserList loadUsers() {
		ArrayList<RegisteredUser> userList = database.loadUsers();
		RegisteredUserList users = new RegisteredUserList(userList);
		
		return users;
	}
	
	private static VoucherIdentifier loadVouchers() {
		Hashtable<Integer, Voucher> voucherList = database.loadVouchers();
		VoucherIdentifier vouchers = new VoucherIdentifier(voucherList);
		
		return vouchers;
	}

	public static void main(String[] args) {
		FinancialInstitute institute = new FinancialInstitute();
		FinanceController finance = new FinanceController(institute);
		
		MovieOfferingList movies = loadMovies();
		RegisteredUserList users = loadUsers();
		VoucherIdentifier vouchers = loadVouchers();
		
		ProcessPayment payment = new ProcessPayment(finance, vouchers);
		ProcessCancellation cancel = new ProcessCancellation(finance, vouchers);

		ModelController model = new ModelController(movies, cancel, payment, users, database);

		LoginGUI theView = new LoginGUI();

		LoginGUIController loginStart = new LoginGUIController(theView, model);
		theView.setVisible(true);
		
	}

}
