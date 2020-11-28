package PaymentModel;

import java.util.ArrayList;

public class ProcessPayment {
	private VoucherIdentifier voucherIdentifier;
	private PaymentReceipt receipt;
	public ProcessPayment(VoucherIdentifier v) {
		this.setVoucherIdentifier(v);
	}
	public double payCard(String method, double price) {
		//May change later but assuming always have enough to cover balance
		double remain = 0;
		return remain;
	}
	public double payVoucher(int id, double price) {
		return voucherIdentifier.useVoucher(id, price);
	}
	public boolean fullfilledAmount(int id, double price) {
		return payVoucher(id,price)<=0?true:false;
	}
	public PaymentReceipt returnReceipt(ArrayList<MovieOffering> soldTickets, int pricePaid) {
		receipt = new PaymentReceipt(soldTickets, pricePaid);
		return receipt;
	}
	public void setVoucherIdentifier(VoucherIdentifier voucherIdentifier) {
		this.voucherIdentifier = voucherIdentifier;
	}

}
