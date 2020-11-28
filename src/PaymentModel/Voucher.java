package PaymentModel;
public class Voucher {
	
	private double worth;
	
	public Voucher(double worth) {
		this.setWorth(worth);
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
}
