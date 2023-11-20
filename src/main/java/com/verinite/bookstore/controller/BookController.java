package com.verinite.bookstore.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.BookStock;
import com.verinite.bookstore.repository.BookRepository;
import com.verinite.bookstore.service.BookService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/book")
public class BookController {
	
	private byte[] bytes;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/getAllBooks")
	public List<Book> getBooks() {
		return bookService.getbooks();
	}

	@GetMapping("/viewBook/{bookId}")
	public Object getById(@PathVariable("bookId") int bookId) {
		return bookService.getById(bookId);
	}

//	@PostMapping("/saveBooks")
//	public Book createBook(@RequestBody Book book) {
//		return bookService.createBook(book);
//	}

	@DeleteMapping("/deleteBook/{bookId}")
	public String deleteBookById(@PathVariable int bookId) {
		return bookService.deleteBookById(bookId);
	}
	
//	@DeleteMapping(path = { "/{id}" })
//	public Book deleteBook(@PathVariable("id") long id) {
//		Book book = bookRepository.getOne(id);
//		bookRepository.deleteById(id);
//		return book;
//	}

	@PutMapping("/updateBook/{bookId}")
	public Object updateBook(@PathVariable int bookId, @RequestBody Book books) {
		return bookService.updateBook(bookId, books);
	}
	
	
	//Updated-14-Dec-021
	@PostMapping("/upload")
	public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException {
		this.bytes = file.getBytes();
	}

	
	
	
	@GetMapping("/getBookwithStockDetails")
	public List<Map<String,String>> getAllDataOfBookWithStockDeatails()
	{
		return bookRepository.getAllDataOfBookWithStockDeatails();
	}
	@PutMapping("/updateTwotables/{bookId}")
	public BookStock updateTwoTables(@PathVariable int bookId,@RequestBody BookStock bs)
	{
		return bookService.updateTwoTablesData(bookId,bs);
	}

	@PostMapping("/saveBooks")
	public Object createBook(@RequestBody Book book) {
		book.setPicByte(this.bytes);
	Object a=	bookService.createBook(book);
		this.bytes = null;
		return a;
	}}
