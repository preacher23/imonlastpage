package com.verinite.bookstore.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.verinite.bookstore.entity.Payment;
import com.verinite.bookstore.entity.Registration;
import com.verinite.bookstore.service.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/getAllRegistration")
	public List<Registration> getAllRegistrations() {
		return registrationService.getRegistrations();
	}

	@GetMapping("/getRegistration/{registerId}")
	public Object getRegistrationById(@PathVariable("registerId") int registerId) {
		return registrationService.getRegistrationById(registerId);
	}
	
	
	@PostMapping("/saveRegistrations")
	public Registration saveRegistration(@RequestBody Registration registration) {
		System.out.println(registration);
		
		return registrationService.saveRegistration(registration);
	}

	@DeleteMapping("/deleteRegistration/{registerId}")
	public String deleteRegistration(@PathVariable int registerId) {
		return registrationService.deleteRegistration(registerId);
	}

	@PutMapping("/updateRegistration/{registerId}")
	public Object updateRegistration(@PathVariable int registerId, @RequestBody Registration registration) {
		return registrationService.updateRegistration(registerId, registration);
	}
	
//	@GetMapping("/login/{userName}")
//	public Object login(@PathVariable("userName") String username ) {
//		Registration registration = new Registration();
//		registration.setUserName(username);
//		registration = registrationService.getRegistration(registration);
//		return registration;
//	} 
//	
	@PatchMapping("/changepasword")
	public Object change(@RequestBody Registration reg)
	{
		return registrationService.change(reg);
	}
	
	@GetMapping("/login/{userName}")
	public Object login(@PathVariable("userName") String username ) {
		Registration registration = new Registration();
		registration.setUserName(username);
		registration = registrationService.getRegistration(registration);
		return registration;
	}
	@GetMapping("/check-mail/{mail}")
	public Object getUserbyEmail(@PathVariable String mail)
	{
		System.out.println(mail);
		Object ob= registrationService.getByEmail(mail);
		System.out.println(ob);
		return ob;
	}
	
	@GetMapping("/check-username/{user}")
	public Object getByUsername(@PathVariable String user)
	{
		return registrationService.getByUsername(user);
	}
	
	@GetMapping("/payment")
	public Payment[] getAll(){
		ResponseEntity<Payment[]> response =
				  restTemplate.getForEntity(
				  "http://payment/payment/getpay",
				  Payment[].class);
		Payment[] payment = response.getBody();
		
		return payment;
	}
	  @GetMapping("/getAll/{username}")
	   public List<Map<String,String>> getCustomerIdWithUsername(@PathVariable String username){
		   return registrationService.getAllRecord(username);
	  }
//	@PatchMapping("/changepasword")
//	public Object change(@RequestBody Registration reg)
//	{
//		return registrationService.change(reg);
//	}

}
