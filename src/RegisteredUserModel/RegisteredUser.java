package RegisteredUserModel;

public class RegisteredUser {
	private String userName;
	private String password;
	private String creditCard;
	private String subStart;
	private String subEnd;
	
	public RegisteredUser(String userName, String password, String creditCard, String subStart, String subEnd) {
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

	public String getSubStart() {
		return subStart;
	}

	public void setSubStart(String subStart) {
		this.subStart = subStart;
	}

	public String getSubEnd() {
		return subEnd;
	}

	public void setSubEnd(String subEnd) {
		this.subEnd = subEnd;
	}

}
