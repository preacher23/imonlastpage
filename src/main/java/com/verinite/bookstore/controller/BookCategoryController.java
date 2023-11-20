package com.verinite.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.BookCategory;
import com.verinite.bookstore.entity.BookCategoryDto;
import com.verinite.bookstore.entity.Category;
import com.verinite.bookstore.repository.BookCategoryRepository;
import com.verinite.bookstore.repository.BookRepository;
import com.verinite.bookstore.repository.CategoryRepository;
import com.verinite.bookstore.service.BookCategoryService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookCategoryController {
	@Autowired
	BookCategoryService bookCategoryService;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	BookCategoryRepository bookCategoryRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@GetMapping("/bookcategory")
	public List<BookCategory>getBookCategory(){
		return bookCategoryService.getBookCategory();
	}
	@GetMapping("/bookcategory/{id}")
	public Object getBookCategoryId(@PathVariable("id") int categoryid){
		return bookCategoryService.getBookCategoryId(categoryid);
	}
	@PostMapping("/bookcategory")
	public BookCategory createBookCategory(@RequestBody BookCategory bookCategory){
		return bookCategoryService.createBookCategory(bookCategory);
	}

	@PutMapping("/bookcategory/{id}")
	public Object updateBookCategory(@PathVariable int id, @RequestBody BookCategory bookCategory){
		return bookCategoryService.updateBookCategory(id,bookCategory);
	}

	@GetMapping("/getalldata")
	public List<Map<String,String>>getAllData(){
		return bookCategoryRepository.getAllData();
	}

	@PutMapping("/addalldata/{id}")
	public BookCategoryDto updateDto(@PathVariable("id")int id,@RequestBody BookCategoryDto bookCategoryDto){
		System.out.println("data" + bookCategoryDto);
		BookCategory bookCategory = bookCategoryRepository.getById(id);
		bookCategory.setCategoryId(2);
		bookCategory.setBookId(2);
		bookCategoryRepository.save(bookCategory);
		Category category = categoryRepository.getOne(bookCategory.getId());
		category.setCategoryTitle(bookCategoryDto.getCategoryTitle());
		categoryRepository.save(category);
		Book book= bookRepository.getOne(bookCategory.getId());
		book.setBookTitle(bookCategoryDto.getBookTitle());
		book.setDescription(bookCategoryDto.getDescription());
		bookRepository.save(book);
		return bookCategoryDto;
	}
}
