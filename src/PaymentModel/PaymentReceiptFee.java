package PaymentModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

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
		int end = endDate;
		String year = Integer.toString(end).substring(0, 4);
		String month = Integer.toString(end).substring(4, 6);
		String day = Integer.toString(end).substring(6, 8);
		String endString = year + "-" + month + "-" + day;
		
		
		return userName + " subscription extended until: " + endString + "\n" +
				"Paid: $" +  pricePaid;
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
		double myNumber = pricePaid;
		DecimalFormat df = new DecimalFormat("####.##");
		
		String numberString = df.format(myNumber);
		Double myNumber2 = Double.parseDouble(numberString);
		
		this.pricePaid = myNumber2;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


}
