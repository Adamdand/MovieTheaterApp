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
		gui.getCreateLoginBtn().addActionListener(this);
		gui.getVoucherBtn().addActionListener(this);
		gui.getRefundBtn().addActionListener(this);
		gui.getLoginBtn().addActionListener(this);
		gui.getLogoutBtn().addActionListener(this);
		gui.getRenewBtn().addActionListener(this);
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
			String response = model.register(userName, password, creditCard);
			gui.displayMessage(response);
			
			if (response.contains("successfully")) {
				gui.getCreateUserNameInput().setText("");
				gui.getCreatePasswordInput().setText("");
				gui.getCreditCardInput().setText("");
			}
		}
		
		if(e.getSource() == gui.getLoginBtn()) {
			//login if registered user. check username and password
			String userName = gui.getUserNameInput().getText();
			String password = gui.getPasswordInput().getText();
			String response = model.verifyLogin(userName, password);
			
			if (response.contains("Welcome")) {
				gui.getUserNameInput().setEditable(false);
				gui.getPasswordInput().setEditable(false);
				gui.getLoginBtn().setEnabled(false);
				gui.getRefundBtn().setEnabled(true);
				gui.getRenewBtn().setEnabled(true);
				
				int endDate = model.getUser().getSubEnd();
				String year = Integer.toString(endDate).substring(0, 4);
				String month = Integer.toString(endDate).substring(4, 6);
				String day = Integer.toString(endDate).substring(6, 8);
				String date = year + "-" + month + "-" + day;
				
				gui.getMembershipEndDate().setText("Membership Expires: " + date);
			}
			
			gui.displayMessage(response);
		}
		
	
		if(e.getSource() == gui.getVoucherBtn()) {
			String ticketId = gui.getVoucherCodeInput().getText();
			String response = "";
			if (!ticketId.matches("[0-9]+")) {
				response = "Please input digits only";
			} else {
				int ticketIdInt = Integer.parseInt(ticketId);
				response = model.makeCancellationRegular(ticketIdInt);
			}

			gui.displayMessage(response);
		}
		
		if(e.getSource() == gui.getRefundBtn()) {
			String ticketId = gui.getRegisteredVoucherCodeInput().getText();
			String response = "";
			if (!ticketId.matches("[0-9]+")) {
				response = "Please input digits only";
			} else {
				int ticketIdInt = Integer.parseInt(ticketId);
				response = model.makeCancellationRegistered(ticketIdInt, model.getUser().getCreditCard());
			}

			gui.displayMessage(response);
		}
		
		if(e.getSource() == gui.getLogoutBtn()) {
			gui.getUserNameInput().setEditable(true);
			gui.getPasswordInput().setEditable(true);
			gui.getLoginBtn().setEnabled(true);
			gui.getRefundBtn().setEnabled(false);
			gui.getRenewBtn().setEnabled(false);;
			gui.getMembershipEndDate().setText("Membership Expires: YYYY/MM/DD");
			model.setUser(null);
		}
		
	}

	public ModelController getModel() {
		return model;
	}

	public void setModel(ModelController model) {
		this.model = model;
	}
	
//	public void createNewUser(String email, String password, String creditCard) {
//		LocalDate today = LocalDate.now();
//		
//		int year = today.getYear();
//		int month = today.getMonthValue();
//		int day = today.getDayOfMonth();
//		
//		//System.out.println(year+ "" +month+""+day);
//		String subStart = year+""+month+""+day;
//		int subStartInt = Integer.parseInt(subStart);
//		
//		int year2 = today.getYear()+1;
//		String subEnd = year2+""+month+""+day;
//		int subEndInt = Integer.parseInt(subEnd);
//
//		RegisteredUser newUser = new RegisteredUser(email, password, creditCard,subStartInt, subEndInt);
//		userList.addUser(newUser);	//not sure if I can do it this way ******
//
//	}
}
