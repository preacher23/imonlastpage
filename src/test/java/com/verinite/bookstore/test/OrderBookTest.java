package com.verinite.bookstore.test;


import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.verinite.bookstore.serviceimpl.OrderBookImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.verinite.bookstore.entity.BookAuthor;
import com.verinite.bookstore.entity.OrderBook;
import com.verinite.bookstore.entity.OrderDto;
import com.verinite.bookstore.entity.Payment;
import com.verinite.bookstore.repository.OrderBookRepository;
import com.verinite.bookstore.service.OrderBookService;

import junit.framework.Assert;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest

class OrderBookTest {

	@Autowired
	OrderBookImpl orderBookImpl;
	@MockBean
	OrderBookRepository orderBookRepository;
	@MockBean
	RestTemplate resttemplate;
	@Test
	 public void testsaveOrderBook()
	{
		OrderBook orderBook=dummyOrderBookEntity();
		OrderDto orderDto=dummyOrderDto();
	    when(orderBookRepository.save(Mockito.any(OrderBook.class))).thenReturn(orderBook);
		OrderBook response=orderBookImpl.saveOrderBook(orderDto);

		assertNotNull(response);

	}
	@Test
	void testSavePayment()
	{
		 when(resttemplate.postForObject(Mockito.anyString(),Mockito.any(),Mockito.any())).thenReturn(dummypayments());
		 Payment response=orderBookImpl.savePayment(dummypayments());
		 assertNotNull(response);
		
	}
	@Test
	void testGetAllPayments()
	{
		List<Payment> list = new ArrayList<>();
		list.add(dummypayments());

		 when(resttemplate.getForObject(Mockito.anyString(),Mockito.any())).thenReturn(Optional.ofNullable(Payment.class));
		 List<Payment> response=orderBookImpl.getAllPayment();
		 assertNotNull(response);
	}
	
	Payment dummypayments()
	{
		Payment pay=new Payment();
		pay.setAccountNumber("12345");
		pay.setAmount(10.00);
		pay.setCustomerName("pavi");
		pay.setIfsc("sbin001");
		pay.setPaymentId(1);
		pay.setPaymentStatus("success");
		pay.setTransactionId("12345");
		return pay;
		
		
	}

	OrderDto dummyOrderDto()
	{
		OrderDto orderDto=new OrderDto();
		orderDto.setBook_id(1);
		orderDto.setBook_title("title");
		orderDto.setBookQty(2);
		orderDto.setDiscription("saws");
		orderDto.setBook_price(234455);
		orderDto.setStockId(2);
		orderDto.setOrderId(1);
		return orderDto;
	}
	@Test
	 void testDisplayAllOrders()
	{
		List<OrderBook> orderBookList=orderBookRepository.findAll();
		List<OrderBook> response=orderBookImpl.displayAllOrders(null);
		assertNotNull(response);
		assertEquals(orderBookList.size(), response.size());
		
	}
	@Test
	 void testDisplayByOrderId()
	{
		int id=1;
		orderBookRepository.save(dummyOrderBookEntity());
		when(orderBookRepository.getById(id)).thenReturn(dummyOrderBookEntity());
		Object response=orderBookImpl.displayByOrderId(id);
		assertNotNull(response);
		assertEquals(response,"record is not present to show with the id of 1");
	}
	@Test
	 void testUpdateById()
	{
		int id=1;
		when(orderBookRepository.getById(id)).thenReturn(dummyOrderBookEntity());
		Object response=orderBookImpl.updateById(id,dummyOrderBookEntity());
		assertNotNull(response);
		assertEquals(response,"record is not present to update with id of 1");
		
	}
	
	
	OrderBook dummyOrderBookEntity()
	{
		OrderBook orderBook=new OrderBook();
		orderBook.setOrderId(1);
		orderBook.setBookId(1);
		orderBook.setBookQty(2);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE, 5);
		orderBook.setDelivarableDate(c);
		orderBook.setOrder_number("OD1");
		
		orderBook.setBookTitle("title");
		orderBook.setCreatedOn(new Date());
		orderBook.setOrderedDate(new Date());
		orderBook.setUpdatedOn(new Date());
		return orderBook;
		
	}
	
}
