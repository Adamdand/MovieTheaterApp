package ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import Controller.ModelController;
import TicketReservationModel.MovieOffering;
import View.PaymentGUI;


public class PaymentGUIController implements ActionListener {
	
	private PaymentGUI gui;
	private ModelController model;
	private ArrayList<MovieOffering> selectedSeats;
	
	public PaymentGUIController(ArrayList<MovieOffering> selectedSeats,PaymentGUI gui, ModelController model) {
		this.setGui(gui);
		this.setModel(model);
		this.setSelectedSeats(selectedSeats);
		gui.getCancelBtn().addActionListener(this);
		gui.getRedeemBtn().addActionListener(this);
		gui.getCheckBox().addActionListener(this);
		gui.getPayBtn().addActionListener(this);
		
			
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == gui.getPayBtn()) {
			//TODO once payment is clicked:
			//make voucher no longer useable if used (delete from list of usable voucher codes)
			//print receipt
			//AND print ticket
			double price = gui.getTotalCost();
			String card = gui.getCreditCardTxt().getText();
			String email = gui.getEmailTxt().getText();
			boolean success = model.makeCardPayment(card, email, price);
			if(!success) {
				gui.displayMessage("Payment with card not fullfilled");
			}else {
				gui.displayMessage("Payment successful");
				gui.setTotalCost(0);
				gui.updateTotalCost(gui.getTotalCostLabel());
			}
		}
		
		if(e.getSource() == gui.getCancelBtn()) {
			//exit program, unless better idea
			System.exit(0);
			
			
		}
		
		if(e.getSource() == gui.getRedeemBtn()) {
			//give discount to totalcost (15%)
			//gui.setTotalCost(gui.getTotalCost()*0.85);
			//gui.updateTotalCost(gui.getTotalCostLabel());
			int voucherId = Integer.parseInt(gui.getvoucherTxt().getText());
			double price = gui.getTotalCost();
			String email = gui.getEmailTxt().getText();
			double remain = model.redeemVoucher(voucherId, email,price);
			
			if (!(price == remain)) {
				gui.changeTextFieldVisibility(gui.getvoucherTxt());
				gui.changeButtonVisibility(gui.getRedeemBtn());
				gui.getCheckBox().setEnabled(false);
			}
			
			gui.setTotalCost(remain);
			gui.updateTotalCost(gui.getTotalCostLabel());
			if(remain ==0) {
				gui.displayMessage("Payment successful");
			}
		}	

		if(e.getSource() == gui.getCheckBox()) {
			gui.changeTextFieldVisibility(gui.getvoucherTxt());
			gui.changeButtonVisibility(gui.getRedeemBtn());
		}
		
	}

	public void setModel(ModelController model) {
		this.model = model;
	}

	public PaymentGUI getGui() {
		return gui;
	}

	public void setGui(PaymentGUI gui) {
		this.gui = gui;
	}

	public ArrayList<MovieOffering> getSelectedSeats() {
		return selectedSeats;
	}

	public void setSelectedSeats(ArrayList<MovieOffering> selectedSeats) {
		this.selectedSeats = selectedSeats;
	}
}
