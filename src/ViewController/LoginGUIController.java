package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.WindowConstants;

import Controller.ModelController;
import RegisteredUserModel.RegisteredUser;
import RegisteredUserModel.RegisteredUserList;
import View.LoginGUI;
import View.TheaterGUI;


public class LoginGUIController implements ActionListener{
	private LoginGUI gui;
	private ModelController model;
	private RegisteredUserList userList;
	
	//make aggregation relationship
	public LoginGUIController(LoginGUI gui, ModelController model) {
		this.gui = gui;
		this.setModel(model);
		
		
		gui.getBrowseMovies().addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == gui.getBrowseMovies()) {
			//start up next GUI if clicked
			TheaterGUI theaterView = new TheaterGUI();
			TheaterGUIController theaterController = new TheaterGUIController(theaterView, model);
			theaterView.setVisible(true);
		}
		
		if(e.getSource() == gui.getCreateLoginBtn()) {
			//createLogin for non reg user
			String userName = gui.getCreateUserNameInput().getText();
			String password = gui.getCreatePasswordInput().getText();
			String creditCard = gui.getCreditCardInput().getText();
			createNewUser(userName,password,creditCard);
		}
		
		if(e.getSource() == gui.getLoginBtn()) {
			//login if registered user. check username and password
			gui.getUserNameInput();
			gui.getPasswordInput();
		}
		
	
		if(e.getSource() == gui.getVoucherBtn()) {
			//return discount voucher
			//we either need to connect to SQL here and add it to SQL, or make a voucherList in java to add to *****
			gui.getVoucherCodeInput();

		}
		
		if(e.getSource() == gui.getRefundBtn()) {
			//return money
			gui.getRegisteredVoucherCodeInput();
		}
		
	}

	public ModelController getModel() {
		return model;
	}

	public void setModel(ModelController model) {
		this.model = model;
	}
	
	public void createNewUser(String email, String password, String creditCard) {
		LocalDate today = LocalDate.now();
		
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		
		//System.out.println(year+ "" +month+""+day);
		String subStart = year+""+month+""+day;
		int subStartInt = Integer.parseInt(subStart);
		
		int year2 = today.getYear()+1;
		String subEnd = year2+""+month+""+day;
		int subEndInt = Integer.parseInt(subEnd);

		RegisteredUser newUser = new RegisteredUser(email, password, creditCard,subStartInt, subEndInt);
		userList.addUser(newUser);	//not sure if I can do it this way ******

	}
}
