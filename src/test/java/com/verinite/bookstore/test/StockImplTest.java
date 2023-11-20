package com.verinite.bookstore.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.BookAuthor;
import com.verinite.bookstore.entity.Stocks;
import com.verinite.bookstore.repository.StockRepository;
import com.verinite.bookstore.serviceimpl.StockImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StockImplTest {
	@InjectMocks
	StockImpl stockimpl;
	
	@Mock
	StockRepository stockrepo;
	
	@Test
	void saveStock()
	{
		Stocks stock=dummy();
		when(stockrepo.save(stock)).thenReturn(dummy());
		Stocks response=stockimpl.saveStock(stock);
		assertNotNull(response);
		assertEquals(response,stock);
		
	}
	@Test
	public void testgetAll()
	{
		Stocks stock=dummy();
		//repo.save(bookauthor);
		List<Stocks> list = new ArrayList<>();
		list.add(dummy());
		when(stockrepo.findAll()).thenReturn(list);
		List<Stocks> response =stockimpl.getAll();
		assertNotNull(response);
		assertEquals(list.size(), response.size());
		
	}
	@Test
	public void updaeStock()
	{
		 int id = 1;
	        Stocks stock = dummy();
	        Stocks response = dummy();
	        when(stockrepo.find(Mockito.anyInt())).thenReturn(stock);
	        when(stockrepo.save(stock)).thenReturn(stock);
	        //stockrepo.find(id);
	        Stocks res = stockimpl.updaeStock(id, response);
	        assertNotNull(res);
	}
	
	@Test
	public void decrease()
	{
		int id=1;
		when(stockrepo.findByBookId(Mockito.anyInt())).thenReturn(dummy());
		when(stockrepo.save(dummy())).thenReturn(dummy());
		stockimpl.decrease(id, dummybook());
	}
	
	Stocks dummy()
	{
		Stocks stock=new Stocks();
		stock.setBookId(1);
		stock.setBookTitle("java");
		stock.setQuantity(5);
		stock.setStockId(1);
		return stock;
	}
	Book dummybook()
	{
		Book book=new Book();
		book.setBookId(1);
		book.setBookPrice(10.00);
		book.setBookQty(2);
		book.setBookTitle("java");
		//book.set
		
		return book;
	}
	

}
