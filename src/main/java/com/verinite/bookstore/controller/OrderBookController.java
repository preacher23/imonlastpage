package com.verinite.bookstore.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.verinite.bookstore.entity.OrderBook;
import com.verinite.bookstore.entity.OrderDto;
import com.verinite.bookstore.entity.Payment;
import com.verinite.bookstore.service.OrderBookService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
public class OrderBookController {
	
	private OrderBookService service;
	@Autowired
	OrderBookController(OrderBookService service)
	{
		this.service=service;
	}
	
	@Autowired
	RestTemplate restTemplate;
//	//insert data to DB
//	@PostMapping("/Order-Book")
//public		List<OrderBook> saveOrderBook(@RequestBody List<OrderBook> orderbook)
//	{
//		System.out.println(orderbook);
//		List<OrderBook> ar=new ArrayList<>();
//		int size=orderbook.size();
//		for(int i=0;i<size;i++)
//		{
//			ar.add( service.saveOrderBook( orderbook.get(i)));
//		}
//		
//		
//		//return service.saveOrderBook( orderbook);
//		return ar;
//	}
	@PostMapping("/saveorder/{id}/{username}")
	public OrderBook save(@PathVariable int id,@PathVariable String username,@RequestBody OrderDto or)
	{
		or.setUsername(username);
		or.setPaymentId(id);
		System.out.println(or);
		return service.saveOrderBook(or);
	}
	
	//display all Data
	@GetMapping("/Order-Book/username/{username}")
public	List<OrderBook> displayAllRecords(@PathVariable String username)
	{
		return service.displayAllOrders(username);
	}
	//display by id
	@GetMapping("/Order-Book/{id}")
public	Object displayById(@PathVariable int id)  
	{
		return service.displayByOrderId(id);
	}
	//update by id
	@PutMapping("/Order-Book/{id}")
public	Object updateOrderRecord(@PathVariable int id,@RequestBody OrderBook  orderbook) 
	{
		return service.updateById(id,  orderbook);
	}
	//display by book name
//	@GetMapping("/Order-Book/bookName/{bookname}")
//public	List<Object> displayByBookName(@PathVariable String bookname) 
//	{
//		return service.searchByBookName(bookname);
//	}
//	//display by book id
//	@GetMapping("/Order-Book/bookId/{bookid}")
//public	List<Object> displayByBookId(@PathVariable int bookid) 
//	{
//		return service.searchByBookId(bookid);
//	}
	
//	@GetMapping("/Order-Book/search/{text}")
//	public List<OrderBook> search(@PathVariable Object text)
//	{
//		return service.searchText(text);
//	}
	
	@GetMapping("/payments/allList")
	List<Payment> getall()
	{
		return service.getAllPayment();
	}
	@PostMapping("/postpayment")
	public Payment post(@RequestBody Payment payment)
	{
		
		return service.savePayment(payment);
	}
	
	
}
