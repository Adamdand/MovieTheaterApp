package CancellationModel;

import java.util.Date;
import java.util.Random;

public class CancellationReceipt {
	private String receiptNumber;
	private double price;
	private Date time;
	private String ticketId;
	
	public CancellationReceipt(double price, Date time, String ticketId) {
		setPrice(price);
		setTime(time);
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
			   "Time: " + time + "\n";
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	
	

}
