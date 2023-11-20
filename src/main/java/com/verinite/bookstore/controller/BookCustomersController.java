package com.verinite.bookstore.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.BookCustomers;
import com.verinite.bookstore.service.BookCustomersService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/customers")
public class BookCustomersController {
	@Autowired
	BookCustomersService bookCustomersService;
	
	//To-Insert-Customer-Into-Repo
	@PostMapping("/customers")
	public BookCustomers insertCustomer(@RequestBody BookCustomers bookCustomers) {
		return bookCustomersService.saveCustomer(bookCustomers);
	}
	//To-Get-All-Customers
	@GetMapping("/customersList")
	public List<BookCustomers> getAllcustomers(){
		return bookCustomersService.allCustomers();
	}
	//To-Get-Customer-by-customerId
	@GetMapping("/customers/{customerId}")
	public Object getByCustomerId(@PathVariable int customerId) {
		return bookCustomersService.getByCustomerId(customerId);
	}
	//To-Update-Customer-By-customerId
	@PutMapping("/customers/{customerId}")
	public Object updateCustomerById(@PathVariable int customerId,@RequestBody BookCustomers bookCustomers) {
		return bookCustomersService.updateCustomerById(customerId, bookCustomers);
	}
	//To-Get-Customer-by-fistName-lastName
	@GetMapping("/customers/{firstName}/{lastName}")
	public List<Object> getCustomerByFirstNameLastName(@PathVariable String firstName,@PathVariable String lastName){
		return bookCustomersService.getCustomerByFirstNameLastName(firstName,lastName);		
	}
	//To-Update-Customer-Country
	@PatchMapping("/customers/{customerId}")
	public Object updateCountry(@PathVariable int customerId,@RequestBody BookCustomers bookCustomers) {
		return bookCustomersService.updateCountry(customerId, bookCustomers);
	}
	//To-Get-Customer-by-State
	@GetMapping("/customers/state/{state}")
	public List<Object> getCustomerByState(@PathVariable String state){
		return bookCustomersService.getCustomerByState(state);
	}
	
	@GetMapping("/customers/search/{temp}")
	List<BookCustomers> searchText(@PathVariable Object temp){
		return bookCustomersService.searchText(temp);
	}
}
