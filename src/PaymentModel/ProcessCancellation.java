package PaymentModel;

import java.util.ArrayList;
import java.util.Random;

import FinanceController.FinanceController;

public class ProcessCancellation {
	private ArrayList<CancellationReceipt> receiptList;
	private VoucherIdentifier voucherIdentifier;
	private FinanceController financeController;
	
	public ProcessCancellation(FinanceController finance, VoucherIdentifier v) {
		setFinanceController(finance);
		setVoucherIdentifier(v);
		receiptList = new ArrayList<CancellationReceipt>();
	}
	
	public String refundTicketRegistered(double price, int ticketId, String cardNumber) {
		
		//if finance controller is setup, use this
//		if (financeController.makeCancellation(cardNumber, price)) {
//			CancellationReceipt receipt = new CancellationReceipt(price, ticketId, cardNumber);
//			addReceipt(receipt);
//			return receipt.toString();
//		} else {
//			return "Invalid credit card number";
//		}
		
		//temporary method to accept all refunds (i.e. doesnt check credit card number)
		CancellationReceipt receipt = new CancellationReceipt(price, ticketId, cardNumber);
		addReceipt(receipt);
		return receipt.toString();
	}
	
	public String refundTicketRegular(double price, int ticketId) {
		Random rand = new Random();
		int x = -1;
		while (true) {
			x = rand.nextInt(89999) + 10000;
			if (voucherIdentifier.addVoucher(x, price)) {
				CancellationReceipt receipt = new CancellationReceipt(price, ticketId, x);
				addReceipt(receipt);
				return receipt.toString();
			}
		}
	}

	public FinanceController getFinanceController() {
		return financeController;
	}

	public void setFinanceController(FinanceController financeController) {
		this.financeController = financeController;
	}

	public ArrayList<CancellationReceipt> getReceiptList() {
		return receiptList;
	}

	public void setReceiptList(ArrayList<CancellationReceipt> receiptList) {
		this.receiptList = receiptList;
	}
	
	public void addReceipt(CancellationReceipt receipt) {
		receiptList.add(receipt);
	}

	public VoucherIdentifier getVoucherIdentifier() {
		return voucherIdentifier;
	}

	public void setVoucherIdentifier(VoucherIdentifier voucherIdentifier) {
		this.voucherIdentifier = voucherIdentifier;
	}
}
