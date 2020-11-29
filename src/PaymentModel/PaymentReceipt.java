package PaymentModel;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PaymentReceipt {
	private ArrayList<MovieOffering> soldTickets;
	private double pricePaid;
	
	public PaymentReceipt(ArrayList<MovieOffering> soldTickets, double pricePaid) {
		this.setSoldTickets(soldTickets);
		this.setPricePaid(pricePaid)
		generateReceipt();
	}
	private void generateReceipt() {
		try {
			File name = new File("Receipt.txt");
			FileWriter myWriter = new FileWriter(name);
			for(MovieOffering m: soldTickets) {
				myWriter.write(m+"\n");
			}
			myWriter.write("Paid: $"+pricePaid);
			myWriter.close()
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
	@Override
	public String toString() {
		String printReceipt ="";
		for(MovieOffering m: soldTickets) {
			printReceipt+=(m+"\n");
		}
		printReceipt+=("TOTAL: $ "+pricePaid);
	}
}
