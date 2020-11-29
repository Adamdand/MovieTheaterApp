package BackEnd;

public class voucher {
	
	private int voucherCode;
	private int valid;
	
	public voucher(int voucherCode, int valid) {
		
		this.setVoucherCode(voucherCode);
		this.setValid(valid);
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

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

}
