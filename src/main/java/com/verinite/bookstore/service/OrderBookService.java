package com.verinite.bookstore.service;
import java.util.List;

import com.verinite.bookstore.entity.BookStock;
import com.verinite.bookstore.entity.OrderBook;
import com.verinite.bookstore.entity.OrderDto;
import com.verinite.bookstore.entity.Payment;



public interface OrderBookService {
	//insert
	//OrderBook saveOrderBook(OrderBook  orderbook);
	//display all data
	List<OrderBook> displayAllOrders(String username);
	//display by order id
	Object displayByOrderId(int orderId);
	//update by id
	Object updateById(int orderId,OrderBook  orderbook);
	// search by book name
//	List<Object> searchByBookName(String bookname);
//	//search by book id
//	List<Object> searchByBookId(int bookid);
//	/*
//	 * //delete order id String deleteByOrderId(int orderId);
//	 */
//	
//	//search by all text
//		List<OrderBook> searchText(Object text);
//		
		Payment savePayment(Payment payment);
		OrderBook saveOrderBook(OrderDto or);
		List<Payment> getAllPayment();
}