package PaymentModel;

import java.util.ArrayList;

import BackEnd.MovieOffering;

public class ProcessPayment {
	private VoucherIdentifier voucherIdentifier;
	private PaymentReceipt receipt;
	public ProcessPayment(VoucherIdentifier v) {
		this.setVoucherIdentifier(v);
	}
	//return payment receipt if successful
	public double payCard(String cardNumber, double price) {
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
	//potentially want to overload and receive a string instead of movieoffering, pass individual strings
	public PaymentReceipt returnReceipt(ArrayList<MovieOffering> soldTickets, int pricePaid) {
		receipt = new PaymentReceipt(soldTickets, pricePaid);
		return receipt;
	}
	public void setVoucherIdentifier(VoucherIdentifier voucherIdentifier) {
		this.voucherIdentifier = voucherIdentifier;
	}

}
