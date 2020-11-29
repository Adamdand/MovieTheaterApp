package PaymentModel;

import java.util.Hashtable;

public class VoucherIdentifier {
	
	private Hashtable<Integer, Voucher> voucherMap;
	
	public VoucherIdentifier() {
		voucherMap=new Hashtable<Integer, Voucher>();
	}
	
	public VoucherIdentifier(Hashtable<Integer, Voucher> voucherList) {
		setVoucherMap(voucherList);
	}

	public boolean addVoucher(int id, double worth) {
		Voucher newVoucher = new Voucher(worth);
		boolean success = false;
		if(!voucherMap.containsKey(id)) {
			success = true;
			voucherMap.put(id, newVoucher);
		}
		return success;
	}
	
	public double getWorth(int id) {
		if(voucherMap.containsKey(id)) {
			return voucherMap.get(id).getWorth();
		}
		return 0;
	}
	public double useVoucher(int id, double price) {
		double remain = price;
		if(voucherMap.containsKey(id)) { 
			 remain = price - voucherMap.get(id).getWorth();
			 if(remain<0) {
				 voucherMap.get(id).setWorth(Math.abs(remain));
				 remain =0;
			 }
			 else {
				 voucherMap.remove(id); 
			 }
		}
		return remain;
	}
	public boolean removeVoucher(int id) {
		boolean success = false;
		if(voucherMap.containsKey(id)) { 
			 success = true;
			 voucherMap.remove(id);
		}
		return success;
	}
	public Hashtable<Integer, Voucher> getVoucherMap() {
		return voucherMap;
	}
	public void setVoucherMap(Hashtable<Integer, Voucher> voucherMap) {
		this.voucherMap = voucherMap;
	}
	

}
