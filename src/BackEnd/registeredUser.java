package BackEnd;

public class registeredUser {
	
	private int userID;
	private int startDate;
	private int endDate;
	private String email;
	private String password;
	
	public registeredUser(int ID, int startDate, int endDate, String email, String password) {
		
		this.setuserID(ID);
		this.setStartDate(startDate);
		this.setEndDate(endDate);
		this.setEmail(email);
		this.setPassword(password);
		
	}

	public int getuserID() {
		return userID;
	}

	public void setuserID(int userID) {
		this.userID = userID;
	}

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toString() {
		String str = "";
		str += "ID =" +userID+ ", End of Subscription = " +endDate+ ", email = " +email+ ", password = " +password;
		return str;
	}

}
