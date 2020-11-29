package FinanceController;

public class CreditCard {
	private String cardNumber;
	private double funds;
	
	public CreditCard(String cardNumber, double funds) {
		setCardNumber(cardNumber);
		setFunds(funds);
	}
	

	public double getFunds() {
		return funds;
	}
	
	public void setFunds(double funds) {
		this.funds = funds;
	}
	
	public String getCardNumber() {
		return cardNumber;
	}
	
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	

}
