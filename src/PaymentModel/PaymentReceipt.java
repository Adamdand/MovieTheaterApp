package PaymentModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
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
				myWriter.write(m + " Ticket id: " + m.getTicketId() + ", Seat: " + m.getSeating().toString() +"\n");
			}
			
			DecimalFormat df = new DecimalFormat("####.##");
			myWriter.write("Paid: $"+ df.format(pricePaid));
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
		
		DecimalFormat df = new DecimalFormat("####.##");
		printReceipt+=("TOTAL: $ "+ df.format(pricePaid));
		
		return printReceipt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
