package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.BookAuthor;
import com.verinite.bookstore.service.BookAuthorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookauthor")

public class BookAuthorController {
	private BookAuthorService authorService;

	public BookAuthorController(BookAuthorService authorService) {
		this.authorService = authorService;
	}

	// uses for to insert data to DB
	@PostMapping("/saveBookAuthor")
	public BookAuthor saveBookAuthor(@RequestBody BookAuthor bookauthor) {
		return authorService.saveBookAuthor(bookauthor);
	}

	// uses for to show the data From DB
	@GetMapping("/bookAuthorsList")
	public List<BookAuthor> allBookAuthor() {
		return authorService.allBookAuthor();
	}

	// uses for to show data by id
	@GetMapping("/getBookAuthor/{id}")
	public Object displayById(@PathVariable int id) {
		return authorService.displayById(id);
	}

	// for to update
	@PutMapping("/updateBookAuthor/{id}")
	public Object updateBookAuthor(@PathVariable int id, @RequestBody BookAuthor bookauthor) {
		return authorService.updateBookAuthor(id, bookauthor);

	}
}
