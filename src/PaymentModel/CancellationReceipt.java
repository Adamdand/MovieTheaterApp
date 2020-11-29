package PaymentModel;

import java.util.Random;

public class CancellationReceipt {
	private String receiptNumber;
	private double price;
	private int date;
	private String ticketId;
	
	public CancellationReceipt(double price, int date, String ticketId) {
		setPrice(price);
		setDate(date);
		setTicketId(ticketId);
		String today = java.time.LocalDate.now().toString();
		Random rand = new Random();
		
		//TODO: change random int to some sort of hashing function or something that is not repeatable
		int x = rand.nextInt(100);
		
		setReceiptNumber(today + "-" + x);
	}
	
	@Override
	public String toString() {
		return "Receipt number: " + receiptNumber + "\n" + 
			   "Refunded/credit : " + price + "\n" + 
			   "Date: " + date + "\n";
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

	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}
	
	

}
