package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.BookCustomers;
import com.verinite.bookstore.repository.BookCustomersRepo;
import com.verinite.bookstore.service.BookCustomersService;

@Service
public class BookCustomersServiceImp  implements BookCustomersService {
	
	
	@Autowired
	BookCustomersRepo bookCustomersRepo;
	//To-Insert-Customer
	@Override
	public BookCustomers saveCustomer(BookCustomers bookCustomers) {
		return bookCustomersRepo.save(bookCustomers);
//		String mobile_number= bookCustomers.getMobileNumber();
//		boolean flag=mobile_number.matches("[0-9]+");
//		int mobile_number_length=mobile_number.length();
//		if(flag!=false && (mobile_number_length==10) && !mobile_number.startsWith("0")) {
//	    	return bookCustomersRepo.save(bookCustomers);}
//		else {
//			return null;
//		}
	}
	//To-Get-Customer-by-customerId
	@Override
	public Object getByCustomerId(int customerId) {
		try {
			return bookCustomersRepo.findById(customerId).get();
		} catch (Exception e) {
			String msg="Record is not present";
			return msg;
		}
	}
	//To-Get-All-Customers
	@Override
	public List<BookCustomers> allCustomers() {
	
		return bookCustomersRepo.getAllcustomers();
	}
	//To-Update-Customer
	@Override
	public Object updateCustomerById(int customerId,BookCustomers bookCustomers){
		try {
			BookCustomers oldBookCustomers=bookCustomersRepo.findById(customerId).get();
			if(bookCustomers.getFirstName()!=null)
				oldBookCustomers.setFirstName(bookCustomers.getFirstName());
			if(bookCustomers.getLastName()!=null)
				oldBookCustomers.setLastName(bookCustomers.getLastName());
			if(bookCustomers.getEmailAddress()!=null)
				oldBookCustomers.setEmailAddress(bookCustomers.getEmailAddress());
			if(bookCustomers.getMobileNumber()!=null)
				oldBookCustomers.setMobileNumber(bookCustomers.getMobileNumber());
			if(bookCustomers.getAddress()!=null)
				oldBookCustomers.setAddress(bookCustomers.getAddress());
			if(bookCustomers.getCity()!=null)
				oldBookCustomers.setCity(bookCustomers.getCity());
			if(bookCustomers.getState()!=null)
				oldBookCustomers.setState(bookCustomers.getState());
			if(bookCustomers.getPincode()!=null)
				oldBookCustomers.setPincode(bookCustomers.getPincode());
			if(bookCustomers.getRegId()!=0)
				oldBookCustomers.setRegId(bookCustomers.getRegId());
			
			final BookCustomers up=bookCustomersRepo.save(oldBookCustomers);
			
			return ResponseEntity.ok(up);
			
		} catch (Exception e) {
			String msg="Record is not present";
			return msg;
		}
		
	
	}
	//To-Get-Customer-by-firstName-lastName
	@Override
	public List<Object> getCustomerByFirstNameLastName(String firstName,String lastName) {
		if(bookCustomersRepo.findByFirstNameAndLastName( firstName, lastName).isEmpty()) {
			List<Object> error =new ArrayList<Object>();
			error.add("No records is present with the given Name");
			return error;
		}
		else {
		   return bookCustomersRepo.findByFirstNameAndLastName(firstName, lastName);
	}
	}
	//To-Update-Customer-Country
	@Override
	public Object updateCountry(int customerId, BookCustomers bookCustomers) {
		try {
			BookCustomers oldBookCustomers=bookCustomersRepo.findById(customerId).get();
			oldBookCustomers.setCountry(bookCustomers.isCountry());
		return	bookCustomersRepo.save(oldBookCustomers);
		
			
		} catch (Exception e) {
			String msg="Record is not present";
			return msg;
		}
		
	}
	//To-Get-Customer-By-State
	@Override
	public List<Object> getCustomerByState(String state) {
		if(bookCustomersRepo.findByState(state).isEmpty()) {
			List<Object> error=new ArrayList<Object>();
			error.add("No Record is present with the given State Name");
			return error;
		}
		else {
		return bookCustomersRepo.findByState(state);
		}
	}
	
	@Override
	public List<BookCustomers> searchText(Object temp) {
		if(((String) temp).matches("[0-9]+"))
		{
			int num=Integer.parseInt((String) temp);
			return bookCustomersRepo.findByCustomerId(num);
		}
		else
			return bookCustomersRepo.search(temp);
	}
}