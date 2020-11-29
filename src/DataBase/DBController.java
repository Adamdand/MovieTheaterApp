package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BackEnd.movieOffering;
import BackEnd.registeredUser;
import BackEnd.voucher;

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
	public movieOffering searchOfferings(int offeringID)
	{
		PreparedStatement getOffering = null;
		String sql = "SELECT * FROM " + "movieOfferings" + " WHERE offeringID = ? OR offeringID = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
		try {
			//statement = jdbc_connection.createStatement();
			//tool = statement.executeQuery(sql);
			if(jdbc_connection != null)
			{
				getOffering = jdbc_connection.prepareStatement(sql);
				getOffering.setInt(1, offeringID);
				getOffering.setInt(2, offeringID);
				ResultSet rs = getOffering.executeQuery();
				if(rs.next()) {
					movieOffering offering = new movieOffering(rs.getInt("offeringID"), rs.getString("theaterName"), rs.getString("movieName"), rs.getString("movieTime"));
					//item.linkSupplier(rs.getString("supplier"));
					return offering;
				}
			}
		
		} catch (SQLException e) { e.printStackTrace(); }
		
		return null;
	}
	
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
	
	public registeredUser searchUsers(String email, String password)
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
					registeredUser thisUser = new registeredUser(rs.getInt("userID"),rs.getInt("startDate"), rs.getInt("endDate"), rs.getString("email"),rs.getString("password"));
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
		public void addRegisteredUser(registeredUser thisRegisteredUser)
		{
			PreparedStatement addUser = null;
			String sql = "INSERT INTO voucherlist" + " VALUES (?,?,?,?,?);"; 
					try {
						addUser = jdbc_connection.prepareStatement(sql);
						addUser.setInt(1, thisRegisteredUser.getuserID());
						addUser.setInt(2, thisRegisteredUser.getStartDate());
						addUser.setInt(2, thisRegisteredUser.getEndDate());
						addUser.setString(2, thisRegisteredUser.getEmail());
						addUser.setString(2, thisRegisteredUser.getPassword());

					}catch(SQLException ex) {
						ex.printStackTrace();
					}		
		}
		
		
		public void updateUser(registeredUser thisUser)
		{
			PreparedStatement renewUser = null;
			String sql = "UPDATE registeredusers SET " + 
					"userID =  ? ," +
					"startDate =  ? ," +
					"endDate =  ? ," +
					"email =  ? ," +
					"password =  ? ," +
					"WHERE email = " + thisUser.getEmail() + ";"; 
					try {
						renewUser = jdbc_connection.prepareStatement(sql);
						renewUser = jdbc_connection.prepareStatement(sql);
						renewUser.setInt(1, thisUser.getuserID());
						renewUser.setInt(2, thisUser.getStartDate());
						renewUser.setInt(2, thisUser.getEndDate());
						renewUser.setString(2, thisUser.getEmail());
						renewUser.setString(2, thisUser.getPassword());
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
		
		public registeredUser searchUsersforRenewalorAddition(int userID, int startDate, int endDate, String email, String password)
		{
			PreparedStatement getUser = null;
			String sql = "SELECT * FROM registeredusers " + " WHERE email = ? OR email = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
			try {
				//statement = jdbc_connection.createStatement();
				//tool = statement.executeQuery(sql);
				if(jdbc_connection != null)
				{
					getUser = jdbc_connection.prepareStatement(sql);
					getUser.setInt(1, userID);
					getUser.setInt(2, userID);
					ResultSet rs = getUser.executeQuery();
					if(rs.next()) {
						registeredUser supp = new registeredUser(rs.getInt("userID"),rs.getInt("startDate"), rs.getInt("endDate"), rs.getString("email"), rs.getString("password"));
						//item.linkSupplier(rs.getString("supplier"));
						registeredUser thisUser = new registeredUser(userID, startDate, endDate, email, password);
						updateUser(thisUser);
						System.out.println("Found Customer");
						return thisUser;
					}
				}
			
			} catch (SQLException e) { e.printStackTrace(); }
			System.out.println("registeredUser NOT FOUND, creating new registeredUser.....");
			registeredUser thisUser = new registeredUser(userID, startDate, endDate, email, password);
			addRegisteredUser(thisUser);
			return null;
		}
		
	
	/**
	 * Static Main
	 * @param args
	 */
	public static void main(String args[])
	{
		DBController dataBase = new DBController();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)


		System.out.println("Reading all offerings from the table:");
		dataBase.printTable();

		System.out.println("\nSearching table for tool 2: should return 'shawnacy theater - Freaky Movie'");
		int offeringID = 2;
		movieOffering searchResult = dataBase.searchOfferings(offeringID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + offeringID);
		else
			System.out.println("Search Result: " + searchResult.toString());

		/**
		System.out.println("\nSearching table for tool 9000: should fail to find a tool");
		toolID = 9000;
		searchResult = inventory.searchTool(toolID);
		if(searchResult == null)
			System.out.println("Search Failed to find a tool matching ID: " + toolID);
		else
			System.out.println("Search Result: " + searchResult.toString());
		*/

		
		//TEST search for voucher in DB
		System.out.println("\nSearching voucher codes for voucher 53398");
		voucher myVoucher = dataBase.searchVouchers(53398);
		if(myVoucher == null)
			System.out.println("Search Failed to find a tool matching ID: " + 53398);
		else
			System.out.println("Search Result: " + myVoucher.toString());
		
		//test search for username and password combo in DB
		registeredUser myUser = dataBase.searchUsers("junwoo@123.com","123");
		if(myUser == null)
			System.out.println("Search Failed to a user with email junwoo@123.com and password 123");
		else
			System.out.println("Search Result: " + myUser.toString());

		
		
		
		
		try {
			dataBase.statement.close();
			dataBase.jdbc_connection.close();
		} 
		catch (SQLException e) { e.printStackTrace(); }
		finally
		{
			System.out.println("\nThe program is finished running");
		}
		
		
		
		
		
	}
	
	

}
