package Controller;

import java.util.ArrayList;
import java.util.Hashtable;

import DatabaseController.DBController;
import FinanceController.*;
import PaymentModel.*;
import TicketReservationModel.*;
import RegisteredUserModel.*;

/**
 * 
 * TODO:
 * 1. voucher sql table needs "worths", registered user table needs credit cards in sql
 * 2. registered user 4 needs start date fixed
 * 3. implement methods to load from DB (in DBController)
 * 4. implement methods in model controller
 * 5. check if processpayment should hold an arraylist of payment receipts
 * 6. overloaded constructors in voucher and voucheridentifier for easier loading, Karlen double check if its ok
 * 7. should vouchers hold the id as well in an instance variable?
 *
 */

public class Main {
	private static DBController database = new DBController();
	
	private static MovieOfferingList loadMovies() {
		ArrayList<MovieOffering> movieList = database.loadMovies();
		MovieOfferingList movies = new MovieOfferingList(movieList);
		
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
		
		//TODO: load guis
		
		//TODO: load view controllers
		
	}

}
