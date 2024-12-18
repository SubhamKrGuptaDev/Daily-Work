package parking_lot.parking.com.model;

import java.time.LocalDateTime;

public class Payment extends BaseModel {

	private String paymentReferenceNumber;
	private Double amount;
	private LocalDateTime paymentTime;
	
	public String getPaymentReferenceNumber() {
		return paymentReferenceNumber;
	}
	public void setPaymentReferenceNumber(String paymentReferenceNumber) {
		this.paymentReferenceNumber = paymentReferenceNumber;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}
	
}
