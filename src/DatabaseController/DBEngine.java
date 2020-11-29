package DatabaseController;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileNotFoundException;

import java.util.Scanner;

import TicketReservationModel.movieOfferingAdam;
import RegisteredUserModel.RegisteredUser;
import TicketReservationModel.voucher;


public class DBEngine {
	
	public Connection jdbc_connection;
	public Statement statement;
	public String databaseName = "movieTheaterDB", tableName = "movieOfferings", dataFile = "movieOfferings.txt";
	public String voucherListFile = "voucherList.txt";
	public String registeredUsers = "registeredUsers.txt";
	
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
				"email VARCHAR(20) NOT NULL, "+
				"password VARCHAR(30) NOT NULL, "+
					"creditCard VARCHAR(16) NOT NULL, "+
					"startDate INT(8) NOT NULL, " + 
				     "endDate INT(8) NOT NULL, "+ 
				     "PRIMARY KEY ( email ))";
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
		String insertStatement = "INSERT INTO registeredUsers (email,password,creditCard,startDate,endDate) VALUES(?,?,?,?,?);";
		
			try{
				Scanner sc = new Scanner(new FileReader(registeredUsers));
				while(sc.hasNext())
				{
					String userInfo[] = sc.nextLine().split(";");
					insertData = jdbc_connection.prepareStatement(insertStatement);
					insertData.setString(1,(userInfo[0]));
					insertData.setString(2,(userInfo[1]));
					insertData.setString(3,(userInfo[2]));
					insertData.setInt(4,Integer.parseInt(userInfo[3]));
					insertData.setInt(5,Integer.parseInt(userInfo[4]));
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
	 * @param offeringID
	 * @return
	 */
	public movieOfferingAdam searchOfferings(int offeringID)
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
					movieOfferingAdam offering = new movieOfferingAdam(rs.getInt("offeringID"), rs.getString("theaterName"), rs.getString("movieName"), rs.getString("movieTime"));
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
	
	public RegisteredUser searchUsers(String userName, String password)
	{
		PreparedStatement getVoucher = null;
		String sql = "SELECT * FROM registeredusers"  + " WHERE userName = ? AND password = ?"; //dont worry, this is set up to take a String in the future, so it can search for toolID or toolName
		try {
			//statement = jdbc_connection.createStatement();
			//tool = statement.executeQuery(sql);
			if(jdbc_connection != null)
			{
				getVoucher = jdbc_connection.prepareStatement(sql);
				getVoucher.setString(1, userName);
				getVoucher.setString(2, password);
				ResultSet rs = getVoucher.executeQuery();
				if(rs.next()) {
					RegisteredUser thisUser = new RegisteredUser(rs.getString("userName"),rs.getString("password"), rs.getString("creditCard"), rs.getInt("startDate"),rs.getInt("endDate"));
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
	
	public static void main(String[] args) {
		DBEngine db = new DBEngine();
		db.createDB();
		db.createTable();
		db.createRegisteredUsers();
		db.createVoucherList();
		db.fillTable();
		db.fillRegisteredUsersList();
		db.fillVoucherList();
		
	}
	
}