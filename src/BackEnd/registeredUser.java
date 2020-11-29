package BackEnd;

public class registeredUser {
	
	private int userID;
	private String startDate;
	private String endDate;
	private String email;
	private String password;
	
	public registeredUser(int ID, String startDate, String endDate, String email, String password) {
		
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
		userID = userID;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
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
