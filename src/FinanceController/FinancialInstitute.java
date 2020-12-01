package FinanceController;

import java.util.ArrayList;

public class FinancialInstitute {
	private ArrayList<CreditCard> creditCards;


	
	//dummy constructor which creates 2 different credit cards
	public FinancialInstitute() {
		CreditCard a = new CreditCard("0000111122223333",52.62);
		CreditCard b = new CreditCard("4444555566667777",12.22);
		creditCards = new ArrayList<CreditCard>();
		creditCards.add(a);
		creditCards.add(b);
	}
	
	public CreditCard searchCard(String cardNumber) {
		for (CreditCard card: creditCards) {
			if (card.getCardNumber().equals(cardNumber)) {
				return card;
			}
		}
		
		return null;
	}
	
	public boolean refund(String cardNumber, double amount) {
		CreditCard card = searchCard(cardNumber);
		
		if (card != null) {
			card.setFunds(card.getFunds() + amount);
			return true;
		} else {
			return false;
		}
	}
	
	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(ArrayList<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}
	
}
