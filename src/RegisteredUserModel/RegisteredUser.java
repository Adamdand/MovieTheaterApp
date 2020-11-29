package RegisteredUserModel;

public class RegisteredUser {
	private String userName;
	private String password;
	private String creditCard;
	private int subStart;
	private int subEnd;
	
	public RegisteredUser(String userName, String password, String creditCard, int subStart, int subEnd) {
		setUserName(userName);
		setPassword(password);
		setCreditCard(creditCard);
		setSubStart(subStart);
		setSubEnd(subEnd);
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}

	public int getSubStart() {
		return subStart;
	}

	public void setSubStart(int subStart) {
		this.subStart = subStart;
	}

	public int getSubEnd() {
		return subEnd;
	}

	public void setSubEnd(int subEnd) {
		this.subEnd = subEnd;
	}
	
	public String toString() {
		String str = "";
		str += "welcome " +userName;
		return str;
	}

	

}
