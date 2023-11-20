package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.verinite.bookstore.entity.BookStock;
import com.verinite.bookstore.entity.OrderBook;
import com.verinite.bookstore.entity.OrderDto;
import com.verinite.bookstore.entity.Payment;
import com.verinite.bookstore.repository.OrderBookRepository;
import com.verinite.bookstore.service.OrderBookService;

@Service
public class OrderBookImpl implements OrderBookService{
	
	private OrderBookRepository orderBookRepository;
	@Autowired
	OrderBookImpl(OrderBookRepository orderBookRepository)
	{
		this.orderBookRepository=orderBookRepository;
		
	}

	@Autowired
	RestTemplate restTemplate;
//	@Override
//	public OrderBook saveOrderBook(OrderBook  orderbook) {
//		 orderbook.setCreatedOn(new Date());
//		 orderbook.setOrderedDate(new Date());
//		 orderbook.setUpdatedOn(new Date());
//		 orderbook.setOrder_number("");
//		// DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		 Calendar c = Calendar.getInstance();
//		 c.add(Calendar.DATE, 5);
//		 orderbook.setDelivarableDate(c);
//		 OrderBook or=orderBookRepository.save( orderbook);
//		 int id=or.getOrderId();
//			String s="OD"+id;
//			//int number=Integer.parseInt(s);
//			or.setOrder_number(s);
//		return orderBookRepository.save(or);
//	}


	@Override
	public List<OrderBook> displayAllOrders(String username) {
		
		return orderBookRepository.find(username);
	}

	@Override
	public Object displayByOrderId(int orderId) {
		Optional<OrderBook> orderbook=orderBookRepository.findById(orderId);
		if(orderbook.isPresent())
		{
			return orderbook.get();
		}
		else
		{
			return "record is not present to show with the id of "+orderId;
		}
		
	}
	

	@Override
	public Object updateById(int orderId, OrderBook orderbook) {
		
		
		try
		{
			 OrderBook oldOrderBookTable=orderBookRepository.findById(orderId).get();
			if(orderbook.getBookId()!=0 || orderbook.getBookTitle()!=null)
			{
				 oldOrderBookTable.setUpdatedOn(new Date());
				 if(orderbook.getBookId()!=0)
				 {
				 oldOrderBookTable.setBookId(orderbook.getBookId());
				 }
				 if(orderbook.getBookTitle()!=null)
				 oldOrderBookTable.setBookTitle(orderbook.getBookTitle());
				 return orderBookRepository.save(oldOrderBookTable);
				
		
			}
			else
			{
				return "please give atleast one parameter to update";
				
			}

			
	}
		catch(Exception e)
		{
			return "record is not present to update with id of "+orderId;
		}
	}

//	@Override
//	public List<Object> searchByBookName(String bookname) {
//		List<Object> orderbook=orderBookRepository.findByBookTitle(bookname);
//		if(orderbook.isEmpty())
//		{
//			List<Object> error =new ArrayList<Object>();
//		error.add("record is not present to show");
//			return error ;
//		}
//		else
//			return orderBookRepository.findByBookTitle(bookname);
//	
//	}
//
//	@Override
//	public List<Object> searchByBookId(int bookid) {
//		List<Object> orderbook=orderBookRepository.findByBookId(bookid);
//		if(orderbook.isEmpty())
//		{
//			List<Object> error =new ArrayList<Object>();
//			error.add(" record is not present to show");
//			return error ;
//		}
//		else
//			return orderBookRepository.findByBookId(bookid);
//	}
//
//	@Override
//	public List<OrderBook> searchText(Object text) {
//		if(((String) text).matches("[0-9]+"))
//		{
//			int num=Integer.parseInt((String) text);
//			return orderBookRepository.findByIntegers(num);
//		}
//		else
//			
//		return orderBookRepository.searchText(text);
//	}

	
	@Override
	public Payment savePayment(Payment payment) {
		//HttpEntity<Payment> entity=new HttpEntity<>(payment);
		return restTemplate.postForObject("http://payments/payment/save",payment,Payment.class);
		
		//return restTemplate.exchange("http://payments/payment/save", HttpMethod.POST, entity, Payment.class).getBody();
	}


	@Override
	public OrderBook saveOrderBook(OrderDto or) {
		
		OrderBook orderbook=new OrderBook();
		 orderbook.setCreatedOn(new Date());
		 orderbook.setOrderedDate(new Date());
		 orderbook.setUpdatedOn(new Date());
		 orderbook.setBookId(or.getBook_id());
		 orderbook.setBookTitle(or.getBook_title());
		 orderbook.setBookQty(or.getBookQty());
		 orderbook.setBook_price(or.getBook_price());
		 orderbook.setUsername(or.getUsername());
		 orderbook.setPaymentId(or.getPaymentId());
		 orderbook.setOrder_number("");
		
		 Calendar c = Calendar.getInstance();
		 c.add(Calendar.DATE, 5);
		 orderbook.setDelivarableDate(c);
		 
		 OrderBook order=orderBookRepository.save(orderbook);
		 if(order!=null)
		 {
			 int id=order.getOrderId();
				String s="OD"+id;
				
				order.setOrder_number(s);
				 OrderBook order1= orderBookRepository.save(order);
				 System.out.println(order1);
				 return order1;
		 }
		return null;
	}

	@Override
	public List<Payment> getAllPayment() {
		String url="http://payments/payment/allList";
		Payment[] obj=restTemplate.getForObject(url,Payment[].class);
		return Arrays.asList(obj);
	}


	
}



