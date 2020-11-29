package PaymentModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PaymentReceiptFee {
	
	private double pricePaid;
	private int endDate;
	private String userName;
	
	public PaymentReceiptFee(double pricePaid, int endDate, String userName) {
		setPricePaid(pricePaid);
		setEndDate(endDate);
		setUserName(userName);
		
		generateReceipt();
	}
	
	@Override
	public String toString() {
		return userName + " subscription extended until: " + endDate + "\n" +
				"Paid: $" + pricePaid;
	}
	
	private void generateReceipt() {
		try {
			File name = new File("Receipt_Annual_Fee.txt");
			FileWriter myWriter = new FileWriter(name);

			myWriter.write(toString());
			myWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public double getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(double pricePaid) {
		this.pricePaid = pricePaid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
