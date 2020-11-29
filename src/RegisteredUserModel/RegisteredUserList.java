package RegisteredUserModel;

import java.util.ArrayList;

public class RegisteredUserList {
	private ArrayList<RegisteredUser> userList;
	private String movieNews;
	
	public RegisteredUserList() {
		setMovieNews("Heres your weekly movie news: ");
		userList = new ArrayList<RegisteredUser>();
	}
	
	public RegisteredUserList(ArrayList<RegisteredUser> users) {
		setMovieNews("Heres your weekly movie news: ");
		setUserList(users);
	}
	
	public RegisteredUser verifyUser(String userName, String password) {
		for (RegisteredUser user: userList) {
			if (user.getPassword().equals(password) && user.getUserName().equals(userName)) {
				return user;
			}
		}
		
		return null;
	} 
	
	public void addUser(RegisteredUser user) {
		userList.add(user);
	}
	
	public void addUser(String userName, String password, String creditCard, int subStart, int subEnd) {
		RegisteredUser user = new RegisteredUser(userName, password, creditCard, subStart, subEnd);
		userList.add(user);
	}
	
	public ArrayList<RegisteredUser> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<RegisteredUser> userList) {
		this.userList = userList;
	}
	public String getMovieNews() {
		return movieNews;
	}
	public void setMovieNews(String movieNews) {
		this.movieNews = movieNews;
	}
	

}
