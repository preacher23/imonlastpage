package com.verinite.bookstore.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PdfEntity {
	 private double book_price;
     private String customer_name;
     private int book_id;
     private String address_1;
     private String city;
     private String country;
     private String state;
     private String pincode;
     private int payment_id;
     private int invoice_id;
     private String mobile_number;
     private String user_name;
     private int book_qty;
     private String book_title;
     private String order_id;
     private int customer_id;
     private double amount;
     private Date ordered_date;
}
