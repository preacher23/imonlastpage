package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Author;
import com.verinite.bookstore.service.AuthorService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	// Post-Mapping-To-Insert-Author
	@PostMapping("/saveAuthors")
	public Author saveAuthor(@RequestBody Author author) {
		return authorService.saveAuthor(author);
	}

	// Get-Mapping-To-Get-All-The-Authors
	@GetMapping("/authorList")
	public List<Author> allAuthors() {
		return authorService.allAuthors();
	}

	// Get-Mapping-To-Get-The-Author-By-Id
	@GetMapping("/getAuthor/{authorId}")
	public Object getById(@PathVariable int authorId) {
		return authorService.getById(authorId);
	}

	// Delete-Mapping-To-Delete-The-Author-By-Id
	@DeleteMapping("/deleteAuthor/{authorId}")
	public String deleteAuthorById(@PathVariable int authorId) {
		return authorService.deleteAuthorById(authorId);

	}

	// Put-Mapping-To-Update-the-Author-FirstName-And-LastName
	@PutMapping("/updateAuthor/{authorId}")
	public Object updateAuthor(@PathVariable int authorId, @RequestBody Author author) {
		return authorService.updateAuthor(authorId, author);

	}
	
	//Get-Mapping By FirstName
		@GetMapping("/getAuthorByFirstName/{firstName}")
		public List<Author> getByFirstName(@PathVariable String firstName) {
			return authorService.getByFirstName(firstName);
		}

}