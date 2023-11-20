package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Author;

public interface AuthorService {
	public Author saveAuthor(Author author);

	public List<Author> allAuthors();

	public Object getById(int authorId);

	public String deleteAuthorById(int authorId);

	public Object updateAuthor(int authorId, Author author);
	
	public List<Author> getByFirstName(String firstName);

}
