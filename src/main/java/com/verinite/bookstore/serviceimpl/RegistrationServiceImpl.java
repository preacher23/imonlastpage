package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Registration;
import com.verinite.bookstore.repository.RegistrationRepository;
import com.verinite.bookstore.service.RegistrationService;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationRepository registrationRepository;

	Registration registrationData;

//	@Override
//	public List<Registration> getRegistrations() {
//		List<Registration> registrationlist = new ArrayList<>();
//		registrationRepository.findAll().forEach(registrationlist::add);
//		return registrationlist;
//	}
	
	@Override
	public List<Registration> getRegistrations() {
        List<Registration> registrationlist = new ArrayList<>();
        registrationRepository.getAllUser(false).forEach(registrationlist::add);
        return registrationlist;
    }
	
	@Override
	public Object getRegistrationById(int registerId) {
		try {
			registrationRepository.findById(registerId).get();
			return registrationRepository.getById(registerId);
		} catch (Exception e) {
			return "Id not Found";
		}
	}

	@Override
	public Registration saveRegistration(Registration registration) {
		Registration reg=new Registration();
		reg.setEmailaddress(registration.getEmailaddress());
		reg.setMobileNumber(registration.getMobileNumber());
		reg.setCreatedOn(new Date());
		reg.setUpdatedOn(new Date());
		reg.setUserName(registration.getUserName());
		reg.setDelete(false);
		reg.setUserRole(registration.getUserRole());
		String password=registration.getPassword();
		Encoder encoder=Base64.getEncoder();
		String epassword=encoder.encodeToString(password.getBytes());
		reg.setPassword(epassword);
		String cpassword=registration.getConfirmPassword();
		String ec=encoder.encodeToString(cpassword.getBytes());
		reg.setConfirmPassword(ec);
		return registrationRepository.save(reg);
	}

	@Override
	public String deleteRegistration(int registerId) {
		Registration registration = new Registration();
		try {
			registration = registrationRepository.getById(registerId);
		} catch (Exception e) {
			return "Registration id " + registerId + " is not present";
		}
		if (0 != registration.getRegisterId() && !registration.isDelete()) {
			registration.setDelete(true);
			registrationRepository.save(registration);
			return "Deleted succuessfully";
		} else if (registration.isDelete()) {
			return "Data already deleted";
		} else {
			return "No such data found in database";
		}
	}

	@Override
	public Object updateRegistration(int registerId, Registration registration) {
		try {
			registrationData = registrationRepository.findById(registerId).get();

			if (registrationData.isDelete()) {
				return "Error : There is no Data with this id  " + registerId;
			}
			registrationData.setUserName(registration.getUserName());
			registrationData.setEmailaddress(registration.getEmailaddress());
			registrationData.setMobileNumber(registration.getMobileNumber());
			registrationData.setPassword(registration.getPassword());
			registrationData.setConfirmPassword(registration.getConfirmPassword());
			registrationData.setUpdatedOn(new Date());

			return registrationRepository.save(registrationData);
		} catch (Exception e) {

			return "Error:  no data is present ";
		}
	}
	
	@Override
	public Registration getRegistration(Registration registration) {
        List<Registration> registrationlist = new ArrayList<>();
        registrationlist=registrationRepository.findByUserNames(registration.getUserName());
        if(!registrationlist.isEmpty()) {
        	for(Registration reg :registrationlist ) {
        		String pass=reg.getPassword();
                Decoder decoder=Base64.getDecoder();
                byte[] bytes=decoder.decode(pass);
                registration.setConfirmPassword(reg.getConfirmPassword());
                registration.setUserName(reg.getUserName());
                registration.setUserRole(reg.getUserRole());
                registration.setRegisterId(reg.getRegisterId());
                registration.setEmailaddress(reg.getEmailaddress());
                registration.setPassword(new String(bytes));
        		registration.setConfirmPassword(reg.getConfirmPassword());
        		registration.setUserName(reg.getUserName());
        		registration.setRegisterId(reg.getRegisterId());
        		registration.setEmailaddress(reg.getEmailaddress());
        		//registration.setPassword(reg.getPassword());
        	}
        }
		return registration;
	}

//	@Override
//	public Object change1(Registration registration) {
////		String email=registration.getEmailaddress();
////			try {
////				registrationData = registrationRepository.findByEmail(email).get();
////				if (registrationData.isDelete()==true) {
////					return "Error : There is no Data with this id  " + email;
////					}
////				if(registration.getUserName()!=null)
////				{
////				registrationData.setUserName(registration.getUserName());
////				
////				}
////				if(registration.getEmailaddress()!=null)
////				{
////				registrationData.setEmailaddress(registration.getEmailaddress());
////				}
////				if(registration.getMobileNumber()!=null)
////				{
////				registrationData.setMobileNumber(registration.getMobileNumber());
////				}
////				if(registration.getRegisterId()!=0)
////				{
////				registrationData.setRegisterId(registration.getRegisterId());
////				}
////				registrationData.setPassword(registration.getPassword());
////				registrationData.setConfirmPassword(registration.getConfirmPassword());
////				registrationData.setUpdatedOn(new Date());
////				return registrationRepository.save(registrationData);
////			} catch (Exception e) {
////
////				
////			}
////	}
//		return "Error:  no data is present ";
//	}
	
	@Override
	public Object change(Registration registration) {
		String email=registration.getEmailaddress();
			try {
				registrationData = registrationRepository.findByEmail(email).get();
				if (registrationData.isDelete()==true) {
					return "Error : There is no Data with this id  " + email;
					}
				if(registration.getUserName()!=null)
				{
				registrationData.setUserName(registration.getUserName());
				
				}
				if(registration.getEmailaddress()!=null)
				{
				registrationData.setEmailaddress(registration.getEmailaddress());
				}
				if(registration.getMobileNumber()!=null)
				{
				registrationData.setMobileNumber(registration.getMobileNumber());
				}
				if(registration.getRegisterId()!=0)
				{
				registrationData.setRegisterId(registration.getRegisterId());
				}
				registrationData.setPassword(registration.getPassword());
				registrationData.setConfirmPassword(registration.getConfirmPassword());
				registrationData.setUpdatedOn(new Date());
				return registrationRepository.save(registrationData);
			} catch (Exception e) {

				return "Error:  no data is present ";
			}
	}

	@Override
	public Object getByEmail(String mail) {
		
		
			registrationData = registrationRepository.findByEmailaddress(mail).get();
			return registrationData;
		
		
	}

	@Override
	public Object getByUsername(String user) {
		System.out.println(user);
		registrationData = registrationRepository.findByUserName(user).get();
		System.out.println(registrationData);
		return registrationData;
	}
	@Override
	public List<Map<String, String>> getAllRecord(String username) {
		
		return registrationRepository.getAllRecord(username);
	}
}