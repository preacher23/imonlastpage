package com.verinite.bookstore.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity()
@Table(name="invoice_t")
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceId;
    private int paymentId;
  private String customer_name;
  private String  address_1;
  private String  city;
  private String  state;
  private String  country;
  private String  pincode;
  private String  mobile_number;
  private int customer_id;
  @Column(name = "encoded_pdf", length = 1000)
  private byte[] encodedPdf;


}
