package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.WindowConstants;

import View.LoginGUI;
import View.TheaterGUI;
import ViewModel.LoginGUIModel;


public class LoginGUIController implements ActionListener{
	private LoginGUI gui;
	private LoginGUIModel model;
	
	//make aggregation relationship
	public LoginGUIController(LoginGUI gui, LoginGUIModel model) {
		this.gui = gui;
		this.setModel(model);
		
		
		gui.getBrowseMovies().addActionListener(this);
		
		//gui.init();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == gui.getBrowseMovies()) {
			//start up next GUI if clicked
			TheaterGUI theaterView = new TheaterGUI();
			TheaterGUIController theaterController = new TheaterGUIController(theaterView, null);
			theaterView.setVisible(true);
		}
		
		if(e.getSource() == gui.getCreateLoginBtn()) {
			//createLogin for non reg user
		}
		
		if(e.getSource() == gui.getLoginBtn()) {
			//login if registered user. check username and password
		}
		
	
		if(e.getSource() == gui.getVoucherBtn()) {
			//return discount voucher

		}
		
		if(e.getSource() == gui.getRefundBtn()) {
			//return money
		}
		
	}

	public LoginGUIModel getModel() {
		return model;
	}

	public void setModel(LoginGUIModel model) {
		this.model = model;
	}
}
