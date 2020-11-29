package TicketReservationModel;

import View.LoginGUI;
import ViewController.LoginGUIController;
import ViewController.TheaterGUIController;

public class runGUIApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginGUI theView = new LoginGUI();
		
		LoginGUIController loginStart = new LoginGUIController(theView, null);
		//TheaterGUIController theaterStart = new TheaterGUIController(theView, null);
		theView.setVisible(true);

	}

}
