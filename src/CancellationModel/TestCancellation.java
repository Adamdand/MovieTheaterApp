package CancellationModel;

import java.util.Date;

public class TestCancellation {

	public static void main(String[] args) {
		FinancialInstitute f = new FinancialInstitute();
		FinanceController fc = new FinanceController(f);
		ProcessCancellation pc = new ProcessCancellation(fc);
		
		Date time = new Date();
		//test for registered user cancellation with valid credit card
		String response = pc.refundTicketRegistered(10, time, "123abc", "0000111122223333");
		System.out.println(response);
		
		System.out.println("checking if financial institute updated card funds");
		double funds = f.getCreditCards().get(0).getFunds();
		System.out.println("Should be 62.62: " + funds);
		System.out.println("----");
		
		//test for registered user cancellation with invalid credit card
		response = pc.refundTicketRegistered(10, time, "123abc", "1111222233334444");
		System.out.println(response);
	}

}
