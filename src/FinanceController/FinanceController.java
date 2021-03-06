package FinanceController;

public class FinanceController {
	private FinancialInstitute institute;
	
	public FinanceController(FinancialInstitute institute) {
		setInstitute(institute);
	}
	
	public boolean makeCancellation(String cardNumber, double amount) {
		return institute.refund(cardNumber, amount);
	}

	public FinancialInstitute getInstitute() {
		return institute;
	}

	public void setInstitute(FinancialInstitute institute) {
		this.institute = institute;
	}

}
