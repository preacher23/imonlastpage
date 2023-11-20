package com.verinite.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Entity
@Table(name = "invoice_pdf")
public class InvoiceDatabaseEntity {
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	int id;
	int payment_id;
	String encodedPdf;
}
