package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controller.ModelController;
import TicketReservationModel.MovieOffering;
import View.PaymentGUI;
import View.SeatSelectionGUI;

public class SeatGUIController implements ActionListener {
	
	private SeatSelectionGUI gui;
	private ModelController model;
	private MovieOffering offering;
	private ArrayList<MovieOffering> allSeats;
	private ArrayList<MovieOffering> selectedSeats;
	
	public SeatGUIController (MovieOffering offering, SeatSelectionGUI gui, ModelController model) {
		
		this.setGui(gui);
		this.setModel(model);
		this.setOffering(offering);
		
		gui.getA1().addActionListener(this);
		gui.getA2().addActionListener(this);
		gui.getA3().addActionListener(this);
		gui.getA4().addActionListener(this);
		gui.getA5().addActionListener(this);
		
		gui.getB1().addActionListener(this);
		gui.getB2().addActionListener(this);
		gui.getB3().addActionListener(this);
		gui.getB4().addActionListener(this);
		gui.getB5().addActionListener(this);
		
		gui.getC1().addActionListener(this);
		gui.getC2().addActionListener(this);
		gui.getC3().addActionListener(this);
		gui.getC4().addActionListener(this);
		gui.getC5().addActionListener(this);
		
		gui.getD1().addActionListener(this);
		gui.getD2().addActionListener(this);
		gui.getD3().addActionListener(this);
		gui.getD4().addActionListener(this);
		gui.getD5().addActionListener(this);
		
		gui.getCheckOutBtn().addActionListener(this);
		gui.getResetBtn().addActionListener(this);
		
		
		
	}
	
	public void getAllSeats() {
		for(MovieOffering o:model.viewAllOfferings()) {
			if(o.getMovie().equals(offering.getMovie())&&o.getTheater().equals(offering.getTheater())&&o.getTime().equals(offering.getTime()))
				allSeats.add(o);
		}
	}
	public void selectSeat(char row, int col) {
		for(MovieOffering o:allSeats) {
			if(o.getSeating().getColumn()==col &&o.getSeating().getRow()==row) {
				selectedSeats.add(o);
			}
		}
	}
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource() == gui.getCheckOutBtn()) {
		//start up next Payment GUI if clicked
		if(selectedSeats.size()>0) {
			model.checkoutSeats(selectedSeats);
			PaymentGUI paymentView = new PaymentGUI(gui.getTotalCost());
			PaymentGUIController paymentController = new PaymentGUIController(selectedSeats, paymentView, model);
			paymentView.setVisible(true); 
		}
	}
	
	if(e.getSource() == gui.getResetBtn()) {
		//start up next Payment GUI if clicked
		gui.resetAllButtons();
		
	}
	

		
		if(e.getSource() == gui.getA1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA1());
			gui.updateBalance(gui.getBalance());
			selectSeat('A',1);
		}
		if(e.getSource() == gui.getA2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA2());
			gui.updateBalance(gui.getBalance());
			selectSeat('A',2);
		}
		if(e.getSource() == gui.getA3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA3());
			gui.updateBalance(gui.getBalance());
			selectSeat('A',3);
		}
		if(e.getSource() == gui.getA4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA4());
			gui.updateBalance(gui.getBalance());
			selectSeat('A',4);
		}
		if(e.getSource() == gui.getA5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA5());
			gui.updateBalance(gui.getBalance());
			selectSeat('A',5);
		}
		
		
		
		if(e.getSource() == gui.getB1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB1());
			gui.updateBalance(gui.getBalance());
			selectSeat('B',1);
		}
		if(e.getSource() == gui.getB2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB2());
			gui.updateBalance(gui.getBalance());
			selectSeat('B',2);
		}
		if(e.getSource() == gui.getB3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB3());
			gui.updateBalance(gui.getBalance());
			selectSeat('B',3);
		}
		if(e.getSource() == gui.getB4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB4());
			gui.updateBalance(gui.getBalance());
			selectSeat('B',4);
		}
		if(e.getSource() == gui.getB5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB5());
			gui.updateBalance(gui.getBalance());
			selectSeat('B',5);
		}
		
		if(e.getSource() == gui.getC1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC1());
			gui.updateBalance(gui.getBalance());
			selectSeat('C',1);
		}
		if(e.getSource() == gui.getC2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC2());
			gui.updateBalance(gui.getBalance());
			selectSeat('C',2);
		}
		if(e.getSource() == gui.getC3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC3());
			gui.updateBalance(gui.getBalance());
			selectSeat('C',3);
		}
		if(e.getSource() == gui.getC4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC4());
			gui.updateBalance(gui.getBalance());
			selectSeat('C',4);
		}
		if(e.getSource() == gui.getC5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC5());
			gui.updateBalance(gui.getBalance());
			selectSeat('C',5);
		}
		
		if(e.getSource() == gui.getD1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD1());
			gui.updateBalance(gui.getBalance());
			selectSeat('D',1);
		}
		if(e.getSource() == gui.getD2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD2());
			gui.updateBalance(gui.getBalance());
			selectSeat('D',2);
		}
		if(e.getSource() == gui.getD3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD3());
			gui.updateBalance(gui.getBalance());
			selectSeat('D',3);
		}
		if(e.getSource() == gui.getD4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD4());
			gui.updateBalance(gui.getBalance());
			selectSeat('D',4);
		}
		if(e.getSource() == gui.getD5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD5());
			gui.updateBalance(gui.getBalance());
			selectSeat('D',5);
		}
		

}

	public ModelController getModel() {
		return model;
	}

	public void setModel(ModelController model) {
		this.model = model;
	}

	public SeatSelectionGUI getGui() {
		return gui;
	}

	public void setGui(SeatSelectionGUI gui) {
		this.gui = gui;
	}

	public MovieOffering getOffering() {
		return offering;
	}

	public void setOffering(MovieOffering offering) {
		this.offering = offering;
	}

	public void setAllSeats(ArrayList<MovieOffering> allSeats) {
		this.allSeats = allSeats;
	}

	public ArrayList<MovieOffering> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(ArrayList<MovieOffering> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}

}
