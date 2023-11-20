package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.BookAuthor;

public interface BookAuthorService {
	public BookAuthor saveBookAuthor(BookAuthor bookauthor);

	// display all records
	public List<BookAuthor> allBookAuthor();

	// display record by Id
	public Object displayById(int id);

	// update by id
	public Object updateBookAuthor(int id, BookAuthor bookauthor);
}
