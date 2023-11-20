package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.BookStock;
import com.verinite.bookstore.entity.Stocks;
import com.verinite.bookstore.repository.BookRepository;
import com.verinite.bookstore.repository.StockRepository;
import com.verinite.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	StockRepository stockrepo;

	@Override
	public List<Book> getbooks() {
		List<Book> booklist = new ArrayList<>();
		bookRepo.getAllBook(false).forEach(booklist::add);
		return booklist;
	}

	@Override
	public Object getById(int bookId) {
		try {
			bookRepo.findById(bookId).get();
			return bookRepo.getById(bookId);
		} catch (Exception e) {
			return "Id not Found";
		}
	}

	@Override
	public Book createBook(Book books) {
		books.setCreatedOn(new Date());
		books.setUpdatedOn(new Date());
		books.setDeleted(false);
		return bookRepo.save(books);
	}

	@Override
	public String deleteBookById(int bookId) {
		try {
			Book book = bookRepo.findById(bookId).get();
			if (!book.isDeleted()) {
				book.setDeleted(true);
				bookRepo.save(book);

				return "record Successfully deleted";
			} else {
				return "Given ID is already deleted";
			}
		} catch (Exception e) {
			return "Id not Found";
		}
	}

	@Override
	public Object updateBook(int bookId, Book books) {

		try {
			Book book = bookRepo.findById(bookId).get();
			if (book.isDeleted()) {
				return "Error : There is no Data with this id  " + bookId;
			}
			book.setBookTitle(books.getBookTitle());
			book.setBookPrice(books.getBookPrice());
			book.setDescription(books.getDescription());
			book.setPublisherId(books.getPublisherId());
			book.setUpdatedOn(new Date());

			return bookRepo.save(book);
		} catch (Exception e) {
			return "id is not present";

		}
	}
	
	@Override
	public BookStock updateTwoTablesData(int bookId, BookStock bs) {
		try
		{
			Book book=bookRepo.findById(bookId).get();
			book.setBookPrice(bs.getBook_price());
			book.setBookTitle(bs.getBookTitle());
			book.setDescription(bs.getDiscription());
			book.setUpdatedOn(new Date());
			bookRepo.save(book);
			Stocks stock=stockrepo.findByBookId(book.getBookId());
			stock.setBookTitle(bs.getBookTitle());
			int a=stock.getQuantity();
			int b=bs.getQuantity();
			int sum=a+b;
			stock.setQuantity(sum);
			stockrepo.save(stock);
			if(book!=null)
				bs.setBookId(bookId);
			if(stock!=null)
				bs.setStockId(stock.getStockId());
			return bs;
		}
		catch(Exception ex)
		{
			return null;
		}
		
		
		
	}

}
