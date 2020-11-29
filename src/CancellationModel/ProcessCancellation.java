package CancellationModel;

import java.util.ArrayList;
import java.util.Date;

public class ProcessCancellation {
	private ArrayList<CancellationReceipt> receiptList;
	//TODO: add voucher identifier
	//private VoucherIdentifier voucher;
	private FinanceController financeController;
	
	public ProcessCancellation(FinanceController finance) {
		setFinanceController(finance);
		//TODO: add setter for voucher identifier
		receiptList = new ArrayList<CancellationReceipt>();
	}
	
	public String refundTicketRegistered(double price, int time, String ticketId, String cardNumber) {
		if (financeController.makeCancellation(cardNumber, price)) {
			CancellationReceipt receipt = new CancellationReceipt(price, time, ticketId);
			addReceipt(receipt);
			return receipt.toString() + cardNumber + " refunded " + price;
		} else {
			return "Invalid credit card number";
		}
	}
	
	public String refundTicketRegular(double price, int time, String ticketId, String type) {
		CancellationReceipt receipt = new CancellationReceipt(price, time, ticketId);
		addReceipt(receipt);
		//TODO: create new voucher
		
		//TODO: add voucher string to return as well
		return receipt.toString();
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
}