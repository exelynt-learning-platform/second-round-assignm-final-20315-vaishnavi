package com.example.demo.Entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    // One payment → one order
	    @OneToOne
	    @JoinColumn(name = "order_id")
	    private Order order;

	    private String paymentId; // Stripe/PayPal ID

	    private String paymentStatus; // SUCCESS, FAILED, PENDING

	    private String paymentMethod; // CARD, UPI, etc.

	    private LocalDateTime paymentDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public String getPaymentId() {
			return paymentId;
		}

		public void setPaymentId(String paymentId) {
			this.paymentId = paymentId;
		}

		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		public String getPaymentMethod() {
			return paymentMethod;
		}

		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}

		public LocalDateTime getPaymentDate() {
			return paymentDate;
		}

		public void setPaymentDate(LocalDateTime paymentDate) {
			this.paymentDate = paymentDate;
		}

		@Override
		public String toString() {
			return "Payment [id=" + id + ", order=" + order + ", paymentId=" + paymentId + ", paymentStatus="
					+ paymentStatus + ", paymentMethod=" + paymentMethod + ", paymentDate=" + paymentDate + "]";
		}

		public Payment(Long id, Order order, String paymentId, String paymentStatus, String paymentMethod,
				LocalDateTime paymentDate) {
			super();
			this.id = id;
			this.order = order;
			this.paymentId = paymentId;
			this.paymentStatus = paymentStatus;
			this.paymentMethod = paymentMethod;
			this.paymentDate = paymentDate;
		}

		public Payment() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
	    
}
