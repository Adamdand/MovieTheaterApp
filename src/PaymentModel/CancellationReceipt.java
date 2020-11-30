package PaymentModel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class CancellationReceipt {
	private String receiptNumber;
	private double price;
	private int date;
	private int voucherId;
	private int ticketId;
	private String creditCard;
	
	public CancellationReceipt(double price, int ticketId, String creditCard) {
		String today = java.time.LocalDate.now().toString();
		int date = Integer.parseInt(today.replace("-",""));
		setPrice(price);
		setDate(date);
		setTicketId(ticketId);
		setCreditCard(creditCard);
		
		Random rand = new Random();
		
		//TODO: change random int to some sort of hashing function or something that is not repeatable
		int x = rand.nextInt(100);
		
		setReceiptNumber(today + "-" + x);
		generateReceipt();
	}
	
	public CancellationReceipt(double price, int ticketId, int voucherId) {
		String today = java.time.LocalDate.now().toString();
		int date = Integer.parseInt(today.replace("-",""));
		setPrice(price);
		setDate(date);
		setTicketId(ticketId);
		setVoucherId(voucherId);
		
		Random rand = new Random();
		
		//TODO: change random int to some sort of hashing function or something that is not repeatable
		int x = rand.nextInt(100);
		
		setReceiptNumber(today + "-" + x);
		generateReceipt();
	}
	
	@Override
	public String toString() {
		int currentDate = date;
		String year = Integer.toString(currentDate).substring(0, 4);
		String month = Integer.toString(currentDate).substring(4, 6);
		String day = Integer.toString(currentDate).substring(6, 8);
		String currentDateString = year + "-" + month + "-" + day;
		
		String endDate = java.time.LocalDate.now().plusDays(365).toString();
		
		if (voucherId == 0) {
			return "Receipt number: " + receiptNumber + "\n" + 
					   "Refunded/credit : " + price + "\n" + 
					   "Date: " + currentDateString + "\n" +
					   "Ticket id: " + ticketId + "\n" +
					   "Credit card: " + creditCard + "\n";
		} else {
			return "Receipt number: " + receiptNumber + "\n" + 
					   "Refunded/credit : " + price + "\n" + 
					   "Date: " + currentDateString + "\n" +
					   "Voucher code: " + voucherId + "\n" +
					   "Voucher expiration: " + endDate + "\n" +
					   "Ticket id: " + ticketId + "\n";
		}
		
	}
	
	private void generateReceipt() {
		try {
			File name = new File("Cancellation_Receipt.txt");
			FileWriter myWriter = new FileWriter(name);

			myWriter.write(toString());
			myWriter.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getReceiptNumber() {
		return receiptNumber;
	}
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getVoucherId() {
		return voucherId;
	}

	public void setVoucherId(int voucherId) {
		this.voucherId = voucherId;
	}

	public String getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	
	

}
