package PaymentModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import TicketReservationModel.MovieOffering;

public class PaymentReceipt {
	private ArrayList<MovieOffering> soldTickets;
	private double pricePaid;
	private String email;
	
	public PaymentReceipt(ArrayList<MovieOffering> soldTickets,String email, double pricePaid) {
		this.setSoldTickets(soldTickets);
		this.setPricePaid(pricePaid);
		this.setEmail(email);
		generateReceipt();
		emailReceipt();
	}
	private void generateReceipt() {
		try {
			File name = new File("Receipt.txt");
			FileWriter myWriter = new FileWriter(name);
			for(MovieOffering m: soldTickets) {
				myWriter.write(m + " Ticket id: " + m.getTicketId() +"\n");
			}
			myWriter.write("Paid: $"+pricePaid);
			myWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setSoldTickets(ArrayList<MovieOffering> soldTickets) {
		this.soldTickets = soldTickets;
	}
	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}
	//Method to send receipt to user's email
	public void emailReceipt() {}
	@Override
	public String toString() {
		String printReceipt ="";
		for(MovieOffering m: soldTickets) {
			printReceipt+=(m+"\n");
		}
		printReceipt+=("TOTAL: $ "+pricePaid);
		
		return printReceipt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
