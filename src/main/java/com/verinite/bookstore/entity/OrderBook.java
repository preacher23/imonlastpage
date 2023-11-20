package com.verinite.bookstore.entity;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Setter
@Entity
@Getter
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name="tbl_orderbook")
public class OrderBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;

	private String order_number; 
	
	private double book_price;
	@Column(name="ordered_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderedDate=new Date();
	
	
	private int paymentId;
	
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="book_Title",length = 128)
	private String bookTitle;
	
	@Column(name="created_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn=new Date();
	
	@Column(name="updated_on")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn=new Date();
	
	private int bookQty;
	
	private String username;
	
	private Calendar delivarableDate;

	
}
