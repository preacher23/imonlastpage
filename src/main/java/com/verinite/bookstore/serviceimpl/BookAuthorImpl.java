package com.verinite.bookstore.serviceimpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.BookAuthor;
import com.verinite.bookstore.repository.BookAuthorRepository;
import com.verinite.bookstore.service.BookAuthorService;

@Service
public class BookAuthorImpl implements BookAuthorService {

	private BookAuthorRepository bookAuthorRepo;

	@Autowired
	BookAuthorImpl(BookAuthorRepository bookAuthorRepo) {
		this.bookAuthorRepo = bookAuthorRepo;
	}

	@Override
	public BookAuthor saveBookAuthor(BookAuthor bookauthor) {
		bookauthor.setCreatedOn(new Date());
		bookauthor.setUpdatedOn(new Date());
		// to save entity in db
		BookAuthor a= bookAuthorRepo.save(bookauthor);
		return a;
	}

	@Override
	public List<BookAuthor> allBookAuthor() {
		// find is a custom query which shows all fields sorted by id in ascending order
		return bookAuthorRepo.find();
	}

	@Override
	public Object displayById(int id) {

		Optional<BookAuthor> bookauthor = bookAuthorRepo.findById(id);
		if (bookauthor.isPresent()) {
			return bookauthor.get();
		} else {
			return "record is not present to show with the id of " + id;
		}
	}

	@Override
	public Object updateBookAuthor(int id, BookAuthor bookauthor) {
		try {
			BookAuthor oldBookAuthorTable = (BookAuthor) bookAuthorRepo.findById(id).get();

			oldBookAuthorTable.setBookId(bookauthor.getBookId());
			oldBookAuthorTable.setAuthorId(bookauthor.getAuthorId());
			oldBookAuthorTable.setUpdatedOn(new Date());

			return bookAuthorRepo.save(oldBookAuthorTable);
		} catch (Exception e) {
			return "record is not present to update with id of " + id;
		}

	}
}
