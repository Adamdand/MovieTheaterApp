package PaymentModel;
import java.time.*;

public class Voucher {
	
	private double worth;
	private int expirationDate;
	
	public Voucher(double worth) {
		this.setWorth(worth);
		calculateExpiration();
	}
	
	public Voucher(double worth, int expirationDate) {
		this.setWorth(worth);
		this.expirationDate = expirationDate;
	}
	
	private void calculateExpiration() {
		String today = LocalDate.now()+"";
		today.replaceAll("-","");
		expirationDate = Integer.parseInt(today);
	}
	public double getWorth() {
		return worth;
	}

	public void setWorth(double worth) {
		this.worth = worth;
	}
	
	public String toString() {
		return "$"+worth;
	}

	public int getExpirationDate() {
		return expirationDate;
	}
}
