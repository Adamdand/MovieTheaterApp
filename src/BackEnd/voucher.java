package BackEnd;

public class voucher {
	
	private int voucherCode;
	private int endDate;
	
	public voucher(int voucherCode, int endDate) {
		
		this.setVoucherCode(voucherCode);
		this.setEndDate(endDate);
	}

	public int getVoucherCode() {
		return voucherCode;
	}

	public void setVoucherCode(int voucherCode) {
		this.voucherCode = voucherCode;
	}
	
	public String toString() {
		String str = "";
		str += voucherCode;
		str += " Was Found!";
		
		return str;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

}
