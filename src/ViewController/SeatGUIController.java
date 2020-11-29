package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.PaymentGUI;
import View.SeatSelectionGUI;
import ViewModel.SeatGUIModel;

public class SeatGUIController implements ActionListener {
	
	private SeatSelectionGUI gui;
	private SeatGUIModel model;
	
	public SeatGUIController (SeatSelectionGUI gui, SeatGUIModel model) {
		
		this.setGui(gui);
		this.setModel(model);
		
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
	
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource() == gui.getCheckOutBtn()) {
		//start up next Payment GUI if clicked
		PaymentGUI paymentView = new PaymentGUI(gui.getTotalCost());
		PaymentGUIController paymentController = new PaymentGUIController(paymentView, null);
		paymentView.setVisible(true); 
		
	}
	
	if(e.getSource() == gui.getResetBtn()) {
		//start up next Payment GUI if clicked
		gui.resetAllButtons();
		
	}
	

		
		if(e.getSource() == gui.getA1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA1());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getA2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA2());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getA3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA3());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getA4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA4());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getA5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getA5());
			gui.updateBalance(gui.getBalance());
		}
		
		
		
		if(e.getSource() == gui.getB1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB1());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getB2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB2());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getB3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB3());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getB4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB4());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getB5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getB5());
			gui.updateBalance(gui.getBalance());
		}
		
		if(e.getSource() == gui.getC1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC1());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getC2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC2());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getC3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC3());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getC4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC4());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getC5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getC5());
			gui.updateBalance(gui.getBalance());
		}
		
		if(e.getSource() == gui.getD1()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD1());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getD2()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD2());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getD3()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD3());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getD4()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD4());
			gui.updateBalance(gui.getBalance());
		}
		if(e.getSource() == gui.getD5()) {
			//start up next GUI if clicked
			gui.dissableButton(gui.getD5());
			gui.updateBalance(gui.getBalance());
		}
		

}

	public SeatGUIModel getModel() {
		return model;
	}

	public void setModel(SeatGUIModel model) {
		this.model = model;
	}

	public SeatSelectionGUI getGui() {
		return gui;
	}

	public void setGui(SeatSelectionGUI gui) {
		this.gui = gui;
	}

}
