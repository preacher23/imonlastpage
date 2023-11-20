package com.verinite.bookstore.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Getter
@Setter
@Data
public class OrderDto {
	private int book_id;
	private int orderId;
	private int stockId;
	private String book_title;
	private String discription;
	private double book_price;
	private int bookQty;
	private int paymentId;
	private String username;

}
