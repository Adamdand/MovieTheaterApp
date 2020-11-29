package DatabaseController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;

import TicketReservationModel.Seats;
import TicketReservationModel.Theater;
import RegisteredUserModel.RegisteredUser;
import PaymentModel.Voucher;
import TicketReservationModel.Movie;
import TicketReservationModel.MovieOffering;
import TicketReservationModel.voucher;

public class DBController {
	public String databaseName = "movieTheaterDB";
	public String connectionInfo2 = "jdbc:mysql://localhost:3306/movieTheaterDB",  
			  login          = "root",
			  password       = "password";
	
	public Connection jdbc_connection;
	public Statement statement;
	
	public DBController(){
		
		try{
			//try to connect to DataBase
			jdbc_connection = DriverManager.getConnection(connectionInfo2, login, password);
			System.out.println("Connected to: " + connectionInfo2 + "\n");
			
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
		
		
	}
	
	/**
	 * Search for a movieOffering from the SQL DataBase given its IDNumber
	 * @param offeringID
	 * @return
	 */
	/**
	public movieOfferingAdam searchOfferings(String theaterName, String movieName, String movieTime)
	{
		PreparedStatement getOffering = null;
		String sql = "SELECT * FROM " + "movieOfferings" + " WHERE theaterName = ? AND movieName = ?  AND movieTime = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
		try {
			//statement = jdbc_connection.createStatement();
			//tool = statement.executeQuery(sql);
			if(jdbc_connection != null)
			{
				getOffering = jdbc_connection.prepareStatement(sql);
				getOffering.setString(1, theaterName);
				getOffering.setString(2, movieName);
				getOffering.setString(3, movieTime);
				ResultSet rs = getOffering.executeQuery();
				if(rs.next()) {
					movieOfferingAdam offering = new movieOfferingAdam(rs.getString("theaterName"), rs.getString("movieName"), rs.getString("movieTime"));
					//item.linkSupplier(rs.getString("supplier"));
					return offering;
				}
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}*/
	
	public voucher searchVouchers(int code)
	{
		PreparedStatement getVoucher = null;
		String sql = "SELECT * FROM voucherlist"  + " WHERE voucherCode = ? OR voucherCode = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
		try {
			//statement = jdbc_connection.createStatement();
			//tool = statement.executeQuery(sql);
			if(jdbc_connection != null)
			{
				getVoucher = jdbc_connection.prepareStatement(sql);
				getVoucher.setInt(1, code);
				getVoucher.setInt(2, code);
				ResultSet rs = getVoucher.executeQuery();
				if(rs.next()) {
					voucher thisvoucher = new voucher(rs.getInt("voucherCode"),rs.getInt("endDate"));
					//item.linkSupplier(rs.getString("supplier"));
					return thisvoucher;
				}
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}
	
	public RegisteredUser searchUsers(String email, String password)
	{
		PreparedStatement getVoucher = null;
		String sql = "SELECT * FROM registeredusers"  + " WHERE email = ? AND password = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
		try {
			//statement = jdbc_connection.createStatement();
			//tool = statement.executeQuery(sql);
			if(jdbc_connection != null)
			{
				getVoucher = jdbc_connection.prepareStatement(sql);
				getVoucher.setString(1, email);
				getVoucher.setString(2, password);
				ResultSet rs = getVoucher.executeQuery();
				if(rs.next()) {
					RegisteredUser thisUser = new RegisteredUser(rs.getString("email"),rs.getString("password"), rs.getString("creditCard"), rs.getInt("startDate"),rs.getInt("endDate"));
					//item.linkSupplier(rs.getString("supplier"));
					return thisUser;
				}
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}

	/**
	 * print Offerings to the user to view in Java
	 */
	public void printTable()
	{
		try {
			String sql = "SELECT * FROM movieOfferings";
			//create prepared statement
			statement = jdbc_connection.prepareStatement(sql);
			ResultSet tools = statement.executeQuery(sql);
			System.out.println("Tools:");
			while(tools.next())
			{
				System.out.println(tools.getInt("offeringID") + " " + 
								   tools.getString("theaterName") + " " + 
								   tools.getString("movieName") + " " + 
								   tools.getString("movieTime"));
			}
			tools.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Add a voucher to voucherList
		public void addVoucher(voucher thisVoucher)
		{
			PreparedStatement addVoucher = null;
			String sql = "INSERT INTO voucherlist" + " VALUES (?,?);"; 
					try {
						addVoucher = jdbc_connection.prepareStatement(sql);
						addVoucher.setInt(1, thisVoucher.getVoucherCode());
						addVoucher.setInt(2, thisVoucher.getEndDate());

					}catch(SQLException ex) {
						ex.printStackTrace();
					}		
		}
		
		// Add a registeredUser
		public void addRegisteredUser(RegisteredUser thisRegisteredUser)
		{
			PreparedStatement addUser = null;
			String sql = "INSERT INTO voucherlist" + " VALUES (?,?,?,?,?);"; 
					try {
						addUser = jdbc_connection.prepareStatement(sql);
						addUser.setString(1, thisRegisteredUser.getUserName());
						addUser.setString(2, thisRegisteredUser.getPassword());
						addUser.setString(3, thisRegisteredUser.getCreditCard());
						addUser.setInt(4, thisRegisteredUser.getSubStart());
						addUser.setInt(5, thisRegisteredUser.getSubEnd());
						addUser.executeUpdate();

					}catch(SQLException ex) {
						ex.printStackTrace();
					}		
		}
		
		
		public void updateUser(RegisteredUser thisUser)
		{
			PreparedStatement renewUser = null;
			String sql = "UPDATE registeredusers SET " + 
					"userID =  ? ," +
					"startDate =  ? ," +
					"endDate =  ? ," +
					"email =  ? ," +
					"password =  ? ," +
					"WHERE email = " + thisUser.getUserName() + ";"; 
					try {
						renewUser = jdbc_connection.prepareStatement(sql);
						renewUser.setString(1, thisUser.getUserName());
						renewUser.setString(2, thisUser.getPassword());
						renewUser.setString(3, thisUser.getCreditCard());
						renewUser.setInt(4, thisUser.getSubStart());
						renewUser.setInt(5, thisUser.getSubEnd());
						renewUser.executeUpdate();
					}catch(SQLException ex) {
						ex.printStackTrace();
					}		
		}
		
		public void deleteVoucher(int voucherCode) {
			PreparedStatement deleteVoucher = null;
			String sql = "DELETE FROM voucherlist WHERE voucherCode = ? OR voucherCode = ?";
			try {
				deleteVoucher = jdbc_connection.prepareStatement(sql);
				deleteVoucher = jdbc_connection.prepareStatement(sql);
				deleteVoucher.setInt(1, voucherCode);
				deleteVoucher.setInt(2, voucherCode);
				deleteVoucher.executeUpdate();

			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		public RegisteredUser searchUsersforRenewalorAddition(String userName, String password, String creditCard, int startDate, int endDate)
		{
			PreparedStatement getUser = null;
			String sql = "SELECT * FROM registeredusers " + " WHERE email = ? OR email = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
			try {
				//statement = jdbc_connection.createStatement();
				//tool = statement.executeQuery(sql);
				if(jdbc_connection != null)
				{
					getUser = jdbc_connection.prepareStatement(sql);
					getUser.setString(1, userName);
					getUser.setString(2, userName);
					ResultSet rs = getUser.executeQuery();
					if(rs.next()) {
						RegisteredUser supp = new RegisteredUser(rs.getString("userName"),rs.getString("password"), rs.getString("creditCard"), rs.getInt("startDate"),rs.getInt("endDate"));
						//item.linkSupplier(rs.getString("supplier"));
						RegisteredUser thisUser = new RegisteredUser(userName, password, creditCard, startDate, endDate);
						updateUser(thisUser);
						System.out.println("Found Customer");
						return thisUser;
					}
				}
			
			} catch (SQLException e) { e.printStackTrace(); }
			System.out.println("registeredUser NOT FOUND, creating new registeredUser.....");
			RegisteredUser thisUser = new RegisteredUser(userName, password, creditCard, startDate, endDate);
			addRegisteredUser(thisUser);
			return null;
		}
		
	
	/**
	 * Static Main
	 * @param args
	 */
		/**
	public static void main(String args[])
	{
		DBController dataBase = new DBController();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)


		System.out.println("Reading all offerings from the table:");
		dataBase.printTable();

		System.out.println("\nSearching table for tool 2: should return 'shawnacy theater - Freaky Movie'");
		movieOfferingAdam searchResult = dataBase.searchOfferings("Shawnacy Theater","Freaky","6:30 PM");
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + searchResult);
		else
			System.out.println("Search Result: " + searchResult.toString());


		System.out.println("\nSearching table for tool 9000: should fail to find a tool");
		toolID = 9000;
		searchResult = inventory.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());
		*/

		
		//TEST search for voucher in DB
		/**
		System.out.println("\nSearching voucher codes for voucher 53398");
		voucher myVoucher = dataBase.searchVouchers(53398);
		if(myVoucher == null)
			System.out.println("Search Failed to find a tool matching ID: " + 53398);
		else
			System.out.println("Search Result: " + myVoucher.toString());
		
		//test search for username and password combo in DB
		RegisteredUser myUser = dataBase.searchUsers("junwoo@123.com","123");
		if(myUser == null)
			System.out.println("Search Failed to a user with email junwoo@123.com and password 123");
		else
			System.out.println("Search Result: " + myUser.toString());
		
		movieOfferingAdam thisOffering = dataBase.searchOfferings("Shawnacy Theater","Freaky","6:30 PM");
		if(myUser == null)
			System.out.println("Search Failed find movie offering");
		else
			System.out.println("Search Result: " + thisOffering.toString());


		
		try {
			dataBase.statement.close();
			dataBase.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
		
		
	
		
	}*/
	
	

	
	
	//TODO: implement method
	public ArrayList<MovieOffering> loadMovies() {
		PreparedStatement getAllMovies = null;
		String getAllMoviesString = "select * from registeredusers";
		ArrayList<MovieOffering> temp = new ArrayList<MovieOffering>();
		try {
			if (jdbc_connection != null) {
				getAllMovies = jdbc_connection.prepareStatement(getAllMoviesString);
				ResultSet rs = getAllMovies.executeQuery();

				while (rs.next()) {
					for(char row = 'A'; row < 'E'; row++){
						 //ArrayList<Seats> seatRow = new ArrayList<Seats>();
						 for(int col = 1; col < 6; col++){
							 Seats mySeat = new Seats(row,col);
							 Movie thisMovie = new Movie(rs.getString("movieName"));
							 Theater thisTheater = new Theater(rs.getString("theaterName"));
							 MovieOffering t = new MovieOffering(rs.getString("theaterName"),thisMovie, rs.getString("movieTime"), mySeat, rs.getInt("offeringID"));
							 temp.add(t);
							 }
					    }
					
					
					
					//t.linkSupplier(rs.getString("supplier"));
					//t.display();
					temp.add(t);
				}
				return temp;
			}
		} catch ( SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	
	public ArrayList<RegisteredUser> loadUsers() {
		PreparedStatement getAllUsers = null;
		String getAllUsersString = "select * from registeredusers";
		ArrayList<RegisteredUser> temp = new ArrayList<RegisteredUser>();
		try {
			if (jdbc_connection != null) {
				getAllUsers = jdbc_connection.prepareStatement(getAllUsersString);
				ResultSet rs = getAllUsers.executeQuery();

				while (rs.next()) {
					RegisteredUser t = new RegisteredUser(rs.getString("userName"),rs.getString("password"), rs.getString("creditCard"), rs.getInt("startDate"),rs.getInt("endDate"));
					//t.linkSupplier(rs.getString("supplier"));
					//t.display();
					temp.add(t);
				}
				return temp;
			}
		} catch ( SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Hashtable<Integer, Voucher> loadVouchers() {
		PreparedStatement getAllVouchers = null;
		String getAllVoucherString = "select * from voucherlist";
		Hashtable<Integer, Voucher> temp = new Hashtable<Integer, Voucher>();
		try {
			if (jdbc_connection != null) {
				getAllVouchers = jdbc_connection.prepareStatement(getAllVoucherString);
				ResultSet rs = getAllVouchers.executeQuery();

				while (rs.next()) {
					Voucher t = new Voucher(13,rs.getInt("endDate"));
					//t.linkSupplier(rs.getString("supplier"));
					//t.display();
					temp.put(rs.getInt("voucherCode"),t);
				}
				return temp;
			}
		} catch ( SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	
	

}
