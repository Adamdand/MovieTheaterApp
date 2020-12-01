package PaymentModel;

import java.util.ArrayList;

import FinanceController.FinanceController;
import TicketReservationModel.MovieOffering;

public class ProcessPayment {
	private VoucherIdentifier voucherIdentifier;
	private FinanceController financeController;
	private PaymentReceipt receipt;
	private PaymentReceiptFee receiptFee;
	
	public ProcessPayment(FinanceController finance, VoucherIdentifier v) {
		this.setFinanceController(finance);
		this.setVoucherIdentifier(v);
	}
	//return payment receipt if successful
	public boolean payCard(String cardNumber, double price) {
		//May change later but assuming always have enough to cover balance
		double remain = 0;
		return remain ==0? true:false;
	}
	public double payVoucher(int id, double price) {
		return voucherIdentifier.useVoucher(id, price);
	}
	public boolean fullfilledAmount(int id, double price) {
		return payVoucher(id,price)<=0?true:false;
	}

	public void generateReceipt(ArrayList<MovieOffering> soldTickets,String email, double pricePaid) {
		receipt = new PaymentReceipt(soldTickets, email, pricePaid);
	}
	
	public void generateReceiptFee(double pricePaid, int endDate, String userName) {
		setReceiptFee(new PaymentReceiptFee(pricePaid, endDate, userName));
	}
	public VoucherIdentifier getVoucherIdentifier() {
		return voucherIdentifier;
	}
	public void setVoucherIdentifier(VoucherIdentifier voucherIdentifier) {
		this.voucherIdentifier = voucherIdentifier;
	}
	public FinanceController getFinanceController() {
		return financeController;
	}
	public void setFinanceController(FinanceController financeController) {
		this.financeController = financeController;
	}
	public PaymentReceipt getReceipt() {
		return receipt;
	}
	public PaymentReceiptFee getReceiptFee() {
		return receiptFee;
	}
	public void setReceiptFee(PaymentReceiptFee receiptFee) {
		this.receiptFee = receiptFee;
	}

}
