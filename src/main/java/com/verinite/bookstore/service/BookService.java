package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.BookStock;

public interface BookService {
	public List<Book> getbooks();

	public Object getById(int bookId);

	public Book createBook(Book books);

	public String deleteBookById(int bookId);

	public Object updateBook(int bookId,Book books);
	
	public BookStock updateTwoTablesData(int bookId, BookStock bs);



}
