package com.verinite.bookstore.test;

import com.verinite.bookstore.entity.Registration;
import com.verinite.bookstore.serviceimpl.RegistrationServiceImpl;
import com.verinite.bookstore.repository.RegistrationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RegistrationServiceTest {
	
	@InjectMocks
	RegistrationServiceImpl registrationServiceImpl;

	@Mock
	RegistrationRepository registrationRepository;
	
	@Test
	public void test_register() {
		Registration registration = dummyRegistration();
		when(registrationRepository.save(registration)).thenReturn(registration);
		Registration response = registrationServiceImpl.saveRegistration(registration);
		assertNotNull(response);
		assertEquals(registrationServiceImpl.saveRegistration(registration),registration);
	}

	@Test
	public void test_getAll() {
		Registration registration = dummyRegistration();
		registrationRepository.save(registration);
		List<Registration> list = new ArrayList<Registration>();
		list.add(registration);
		when(registrationRepository.findAll()).thenReturn(list);
		List<Registration> response = registrationServiceImpl.getRegistrations();
		assertNotNull(response);
		assertEquals(list.size(),response.size() );
	}

	@Test
	public void test_getById() {
		int registerId = 1;
		Registration registration = dummyRegistration();
		registrationRepository.save(registration);
		when(registrationRepository.getById(registerId)).thenReturn(registration);
		Object response = registrationServiceImpl.getRegistrationById(registerId);
		assertNotNull(response);
		assertEquals("Id not Found",response);

	}

	@Test
	public void test_update() {
		int registerId = 1;
		when(registrationRepository.getById(registerId)).thenReturn(dummyRegistration());
		Object response = registrationServiceImpl.updateRegistration(registerId, dummyRegistration());
		assertNotNull(response);
		System.out.println(response);
		assertEquals("Error:  no data is present ",response);
	}

	@Test
	public void test_delete() {
		int regId = 1;
		when(registrationRepository.getById(regId)).thenReturn(dummyRegistration());
		Object response = registrationServiceImpl.deleteRegistration(regId);
		assertNotNull(response);
		assertEquals("Deleted succuessfully",response);
	}

	@Test
	public void test_deleteFailure1() {

		int regId = 1;
		Registration registration = new Registration();
		registration.setRegisterId(1);
		registration.setUserName("Ahalya");
		registration.setMobileNumber("1234567890");
		registration.setEmailaddress("ahalya@gmail.com");
		registration.setPassword("pass");
		registration.setConfirmPassword("pass");
		registration.setCreatedOn(new Date());
		registration.setUpdatedOn(new Date());
		registration.setDelete(true);
		when(registrationRepository.getById(regId)).thenReturn(registration);
		Object response = registrationServiceImpl.deleteRegistration(regId);
		assertNotNull(response);
		assertEquals("Data already deleted",response);
	}

	@Test
	public void test_deleteFailure2() {

		int regId=1;
		Registration registration = new Registration();
		when(registrationRepository.getById(regId)).thenReturn(registration);
		Object response = registrationServiceImpl.deleteRegistration(regId);
		assertNotNull(response);
		assertEquals("No such data found in database",response);
	}


	private Registration dummyRegistration() {
		Registration registration = new Registration();
		registration.setRegisterId(1);
		registration.setUserName("Ahalya");
		registration.setMobileNumber("1234567890");
		registration.setEmailaddress("ahalya@gmail.com");
		registration.setPassword("pass");
		registration.setConfirmPassword("pass");
		registration.setCreatedOn(new Date());
		registration.setUpdatedOn(new Date());
		registration.setDelete(false);
		return registration;
		
	}

}