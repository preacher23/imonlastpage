package com.verinite.bookstore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class BookStock {
	private int bookId;
	private int stockId;
	private String bookTitle;
	private String discription;
	private double book_price;
	private int quantity;
	
		
	

}