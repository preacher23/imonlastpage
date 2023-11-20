package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.BookCustomers;

public interface BookCustomersService {
	public BookCustomers saveCustomer(BookCustomers bookCustomers);
	public Object getByCustomerId(int customerId);
	public List<BookCustomers> allCustomers();
	public List<Object> getCustomerByFirstNameLastName(String firstName,String lastName);
	Object updateCustomerById(int customerId, BookCustomers bookCustomers);	
	Object updateCountry(int customerId, BookCustomers bookCustomers);
	public List <Object> getCustomerByState(String state);
	public List<BookCustomers> searchText(Object temp) ;
}
