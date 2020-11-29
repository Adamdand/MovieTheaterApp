package DataBase;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileNotFoundException;

import java.util.Scanner;

import BackEnd.movieOffering;
import BackEnd.registeredUser;
import BackEnd.voucher;


public class DBEngine {
	
	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "movieTheaterDB", tableName = "movieOfferings", dataFile = "C:/Users/adamd/Desktop/ENSF 619/movieTheater/movieOfferings.txt";
	public String voucherListFile = "C:/Users/adamd/Desktop/ENSF 619/movieTheater/voucherList.txt";
	public String registeredUsers = "C:/Users/adamd/Desktop/ENSF 619/movieTheater/registeredUsers.txt";
	
	// Students should configure these variables for their own MySQL environment
	// If you have not created your first database in mySQL yet, you can leave the 
	// "[DATABASE NAME]" blank to get a connection and create one with the createDB() method.
	public String connectionInfo = "jdbc:mysql://localhost:3306",  
				  login          = "root",
				  password       = "password";

	/**
	 * connect to SQL
	 */
	public DBEngine()
	{
		try{
			// If this throws an error, make sure you have added the mySQL connector JAR to the project
			
			// If this fails make sure your connectionInfo and login/password are correct
			jdbc_connection = DriverManager.getConnection(connectionInfo, login, password);
			System.out.println("Connected to: " + connectionInfo + "\n");
		}
		catch(SQLException e) { e.printStackTrace(); }
		catch(Exception e) { e.printStackTrace(); }
	}
	
	/**
	 * Create a new SQL DataBase
	 */
	public void createDB()
	{
		try {
			statement = jdbc_connection.createStatement();
			statement.executeUpdate("CREATE DATABASE " + databaseName);
			statement.executeUpdate("USE " + databaseName);
			System.out.println("Created Database " + databaseName);
		} 
		catch( SQLException e)
		{
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create a new dataTable inside of SQL
	 * This example creates the table "ToolTable"
	 */
	public void createTable()
	{
		String sql = "CREATE TABLE " + tableName + "(" +
				     "offeringID INT(4) NOT NULL, " +
				     "theaterName VARCHAR(30) NOT NULL, " + 
				     "movieName VARCHAR(30) NOT NULL, " + 
				     "movieTime VARCHAR(10) NOT NULL, " + 
				     "PRIMARY KEY ( offeringID ))";
		try{
			//create prepareStatement
			statement = jdbc_connection.prepareStatement(sql);
			statement.executeUpdate(sql);
			System.out.println("Created Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void createRegisteredUsers()
	{
		String sql = "CREATE TABLE registeredUsers" + "(" +
				     "userID INT(4) NOT NULL, " +
				     "startDate INT(8) NOT NULL, " + 
				     "endDate INT(8) NOT NULL, "+ 
				     "email VARCHAR(20) NOT NULL, "+
				     "password VARCHAR(30) NOT NULL, "+
				     "PRIMARY KEY ( userID ))";
		try{
			//create prepareStatement
			statement = jdbc_connection.prepareStatement(sql);
			statement.executeUpdate(sql);
			System.out.println("Created Table registeredUsers");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void createVoucherList()
	{
		String sql = "CREATE TABLE voucherList" + "(" +
				     "voucherCode INT(5) NOT NULL, " +
				     "endDate INT(8) NOT NULL, " +
				     "PRIMARY KEY ( voucherCode ))";
		try{
			//create prepareStatement
			statement = jdbc_connection.prepareStatement(sql);
			statement.executeUpdate(sql);
			System.out.println("Created Table voucherList");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * function used to remove the table "ToolTable"
	 */
	/**
	public void removeTable()
	{
		String sql = "DROP TABLE " + tableName;
		try{
			statement = jdbc_connection.prepareStatement(sql);
			statement.executeUpdate(sql);
			System.out.println("Removed Table " + tableName);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}*/

	/**
	 * Fills ToolTable with data from text file
	 */
	public void fillTable() {
	
	PreparedStatement insertData = null;
	String insertStatement = "INSERT INTO movieOfferings (offeringID,theaterName,movieName,movieTime) VALUES(?,?,?,?);";
	
		try{
			Scanner sc = new Scanner(new FileReader(dataFile));
			while(sc.hasNext())
			{
				String offeringInfo[] = sc.nextLine().split(";");
				insertData = jdbc_connection.prepareStatement(insertStatement);
				insertData.setInt(1,Integer.parseInt(offeringInfo[0]));
				insertData.setString(2,offeringInfo[1]);
				insertData.setString(3,(offeringInfo[2]));
				insertData.setString(4,(offeringInfo[3]));
				insertData.executeUpdate();
				//jdbc_connection.commit();
			}
			sc.close();
			insertData.close();
		}
		catch(FileNotFoundException e)
		{
			System.err.println("File " + dataFile + " Not Found!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void fillRegisteredUsersList() {
		
		PreparedStatement insertData = null;
		String insertStatement = "INSERT INTO registeredUsers (userID,startDate,endDate,email,password) VALUES(?,?,?,?,?);";
		
			try{
				Scanner sc = new Scanner(new FileReader(registeredUsers));
				while(sc.hasNext())
				{
					String userInfo[] = sc.nextLine().split(";");
					insertData = jdbc_connection.prepareStatement(insertStatement);
					insertData.setInt(1,Integer.parseInt(userInfo[0]));
					insertData.setInt(2,Integer.parseInt(userInfo[1]));
					insertData.setInt(3,Integer.parseInt(userInfo[2]));
					insertData.setString(4,(userInfo[3]));
					insertData.setString(5,(userInfo[4]));
					insertData.executeUpdate();
					//jdbc_connection.commit();
				}
				sc.close();
				insertData.close();
			}
			catch(FileNotFoundException e)
			{
				System.err.println("File registeredUswersd" + " Not Found!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	
public void fillVoucherList() {
		
		PreparedStatement insertData = null;
		String insertStatement = "INSERT INTO voucherList (voucherCode, endDate) VALUES(?,?);";
		
			try{
				Scanner sc = new Scanner(new FileReader(voucherListFile));
				while(sc.hasNext())
				{
					String userInfo[] = sc.nextLine().split(";");
					insertData = jdbc_connection.prepareStatement(insertStatement);
					insertData.setInt(1,Integer.parseInt(userInfo[0]));
					insertData.setInt(2,Integer.parseInt(userInfo[1]));
					insertData.executeUpdate();
					//jdbc_connection.commit();
				}
				sc.close();
				insertData.close();
			}
			catch(FileNotFoundException e)
			{
				System.err.println("File vouchers" + " Not Found!");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}


	/**
	 * Add an tool to the ToolTable
	 * must be in correct format: ID, Name, Quantity, Price, supplierID
	 * @param tool
	 */
	/**
	public void addItem(Items tool)
	{
		PreparedStatement addTool = null;
		String sql = "INSERT INTO " + tableName + " VALUES (?,?,?,?,?);"; 
				try {
					addTool = jdbc_connection.prepareStatement(sql);
					addTool.setInt(1, tool.getItemID());
					addTool.setString(2, tool.getItemName());
					addTool.setInt(3, tool.getItemQuantity());
					addTool.setDouble(4, tool.getItemPrice());
					addTool.setInt(5, tool.getItemSupplierID());
				}catch(SQLException ex) {
					ex.printStackTrace();
				}		
	}*/
	



	/**
	 * Search for a movieOffering from the SQL DataBase given its IDNumber
	 * @param toolID
	 * @return
	 */
	public movieOffering searchOfferings(int offeringID)
	{
		PreparedStatement getOffering = null;
		String sql = "SELECT * FROM " + tableName + " WHERE offeringID = ? OR offeringID = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
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
			String sql = "SELECT * FROM " + tableName;
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
	
	/**
	 * Static Main
	 * @param args
	 */
	public static void main(String args[])
	{
		DBEngine dataBase = new DBEngine();
		
		// You should comment this line out once the first database is created (either here or in MySQL workbench)
		dataBase.createDB();
		dataBase.createTable();
		
		System.out.println("\nFilling the table with movieOfferings");
		dataBase.fillTable();

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
		//System.out.println("\nTrying to remove the table");
		//dataBase.removeTable();
		
		System.out.println("\ncreating RegisteredUser List");
		dataBase.createRegisteredUsers();
		System.out.println("\nfilling RegisteredUser List");
		dataBase.fillRegisteredUsersList();
		
		System.out.println("\ncreating voucher List");
		dataBase.createVoucherList();
		System.out.println("\nfilling voucher List");
		dataBase.fillVoucherList();
		
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