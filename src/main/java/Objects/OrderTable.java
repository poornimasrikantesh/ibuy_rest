package Objects;

public class OrderTable {

	int orderid;	
	int Payment_transactionId;
	int CustomersTable_id;
	Long amount;
	String qrcode;
	boolean qrcodePrinted;
	
	
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getPaymentTable_transactionId() {
		return Payment_transactionId;
	}
	public void setPaymentTable_transactionId(int paymentTable_transactionId) {
		Payment_transactionId = paymentTable_transactionId;
	}
	public int getCustomersTable_id() {
		return CustomersTable_id;
	}
	public void setCustomersTable_id(int customersTable_id) {
		CustomersTable_id = customersTable_id;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String  getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public boolean isQrcodePrinted() {
		return qrcodePrinted;
	}
	public void setQrcodePrinted(boolean qrcodePrinted) {
		this.qrcodePrinted = qrcodePrinted;
	}
	
}
