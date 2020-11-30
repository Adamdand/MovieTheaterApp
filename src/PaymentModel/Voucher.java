package PaymentModel;
import java.time.*;

public class Voucher {
	
	private double worth = 13.5;
	private int voucherCode;
	private int expirationDate;
	
	public Voucher(double worth) {
		this.setWorth(worth);
		calculateExpiration();
	}
	
	public Voucher(int voucherCode , int expirationDate) {
		this.voucherCode = voucherCode;
		this.setWorth(worth);
		this.expirationDate = expirationDate;
	}
	
	private void calculateExpiration() {
		String today = LocalDate.now()+"";
		today = today.replaceAll("-","");
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

	public int getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(int voucherCode) {
		this.voucherCode = voucherCode;
	}
}
