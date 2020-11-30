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
		
		allSeats = new ArrayList<MovieOffering>();
		getAllSeats();
		selectedSeats = new ArrayList<MovieOffering>();
		disableUnavailableSeats();
	}
	
	public void getAllSeats() {
		for(MovieOffering o:model.viewAllOfferings()) {
			if(o.getMovie().getMovieName().equals(offering.getMovie().getMovieName())&&o.getTheater().getTheaterName().equals(offering.getTheater().getTheaterName())&&o.getTime().equals(offering.getTime())&&o.getMovieDate() == offering.getMovieDate()) {
				allSeats.add(o);
			}
		}

	}
	public void selectSeat(char row, int col) {
		for(MovieOffering o:allSeats) {
			if(o.getSeating().getColumn()==col &&o.getSeating().getRow()==row) {
				selectedSeats.add(o);
			}
		}
	}
	public boolean checkSeat(char row, int col) {
		for(MovieOffering o: allSeats) {
			if(o.getSeating().getColumn()==col &&o.getSeating().getRow()==row &&o.isBooked()==true) {
				return false;
			}
		}
		return true;
	}
	public void disableUnavailableSeats() {
		if(model.getUser()==null) {
			gui.dissableButton(gui.getA1());
			gui.dissableButton(gui.getA2());
		}
		if(!checkSeat('A',1))
			gui.dissableButton(gui.getA1());
		if(!checkSeat('A',2))
			gui.dissableButton(gui.getA2());
		if(!checkSeat('A',3))
			gui.dissableButton(gui.getA3());
		if(!checkSeat('A',4))
			gui.dissableButton(gui.getA4());
		if(!checkSeat('A',5))
			gui.dissableButton(gui.getA5());
		if(!checkSeat('B',1))
			gui.dissableButton(gui.getB1());
		if(!checkSeat('B',2))
			gui.dissableButton(gui.getB2());
		if(!checkSeat('B',3))
			gui.dissableButton(gui.getB3());
		if(!checkSeat('B',4))
			gui.dissableButton(gui.getB4());
		if(!checkSeat('B',5))
			gui.dissableButton(gui.getB5());
		if(!checkSeat('C',1))
			gui.dissableButton(gui.getC1());
		if(!checkSeat('C',2))
			gui.dissableButton(gui.getC2());
		if(!checkSeat('C',3))
			gui.dissableButton(gui.getC3());
		if(!checkSeat('C',4))
			gui.dissableButton(gui.getC4());
		if(!checkSeat('C',5))
			gui.dissableButton(gui.getC5());
		if(!checkSeat('D',1))
			gui.dissableButton(gui.getD1());
		if(!checkSeat('D',2))
			gui.dissableButton(gui.getD2());
		if(!checkSeat('D',3))
			gui.dissableButton(gui.getD3());
		if(!checkSeat('D',4))
			gui.dissableButton(gui.getD4());
		if(!checkSeat('D',5))
			gui.dissableButton(gui.getD5());
	}
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource() == gui.getCheckOutBtn()) {
		//start up next Payment GUI if clicked
		if(selectedSeats.size()>0) {
			model.checkoutSeats(selectedSeats);
			PaymentGUI paymentView = new PaymentGUI(gui.getTotalCost());
			PaymentGUIController paymentController = new PaymentGUIController(selectedSeats, paymentView, model);
			
			if (model.getUser() != null) {
				paymentView.getCreditCardTxt().setText(model.getUser().getCreditCard());
				paymentView.getEmailTxt().setText(model.getUser().getUserName());
			}
			
			paymentView.setVisible(true); 
			gui.dispose();
		}
	}
	
	if(e.getSource() == gui.getResetBtn()) {
		//start up next Payment GUI if clicked
		gui.resetAllButtons();
		selectedSeats.clear();
		disableUnavailableSeats();
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
