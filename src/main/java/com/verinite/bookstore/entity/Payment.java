package com.verinite.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")
	private int paymentId;
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="ifsc")
	private String ifsc;
	
	
	
	@Column(name="amount")
	private double amount;
	
	
	private String paymentStatus;
	
    private String transactionId;

	
}
