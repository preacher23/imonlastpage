
package com.verinite.bookstore.test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.verinite.bookstore.entity.BookAuthor;
import com.verinite.bookstore.repository.BookAuthorRepository;
import com.verinite.bookstore.serviceimpl.BookAuthorImpl;




@SpringBootTest
public class BookAuthourTest {

	@Autowired
	BookAuthorImpl bookauthorimpl;
	@MockBean
	BookAuthorRepository repo;
	
	@Test
	public void test_saveBookAuthor()
	{
		BookAuthor bookauthor=new BookAuthor();
		bookauthor.setAuthorId(2);
		bookauthor.setBookId(1);
		bookauthor.setId(400);
		bookauthor.setCreatedOn(new Date());
		bookauthor.setUpdatedOn(new Date());
		when(repo.save(bookauthor)).thenReturn(bookauthor);
		BookAuthor response =bookauthorimpl.saveBookAuthor(bookauthor);
		assertNotNull(response);
		assertEquals(response,bookauthor);
		
	}
	// testing display all methods
	
	@Test
	public void test_allBookAuthor()
	{
		BookAuthor bookauthor=new BookAuthor();
		bookauthor.setAuthorId(2);
		bookauthor.setBookId(1);
		bookauthor.setId(400);
		bookauthor.setCreatedOn(new Date());
		bookauthor.setUpdatedOn(new Date());
		repo.save(bookauthor);
		List<BookAuthor> list = new ArrayList<>();
		
		when(repo.findAll()).thenReturn(list);
		List<BookAuthor> response =bookauthorimpl.allBookAuthor();
		assertNotNull(response);
		assertEquals(list.size(), response.size());
		
	}
	
	
	
	@Test
	public void test_displayById()
	{
		int id=1;
		repo.save(dummy());
		when(repo.getById(id)).thenReturn(dummy());
		Object res= bookauthorimpl.displayById(id);
		assertNotNull(res);
		
		assertEquals(res,"record is not present to show with the id of 1");
		
		
		
	}
	
	//testing for update
	@Test
	public void test_updateBookAuthor()
	{
		
		int id=1;
		
		when(repo.getById(id)).thenReturn(dummy());
		Object res=bookauthorimpl.updateBookAuthor(id, dummy());
		assertNotNull(res);		
		assertEquals(res,"record is not present to update with id of 1");
}
	BookAuthor dummy()
	{
		BookAuthor bookauthor=new BookAuthor();
		
		bookauthor.setAuthorId(2);
		bookauthor.setBookId(1);
		bookauthor.setId(1);
		bookauthor.setCreatedOn(new Date());
		bookauthor.setUpdatedOn(new Date());
		return bookauthor;
	}
}
