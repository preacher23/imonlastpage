package com.verinite.bookstore.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="tbl_customer")
public class BookCustomers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private int customerId;
	
	@Column(name="first_name" , nullable = false, length = 128)
	private String firstName;
	
	@Column(name="last_name",nullable = false, length = 128)
	private String lastName;
	
	@Column(name="mobile_number",nullable = false, length = 128)
	private String mobileNumber;
	
	@Column(name="email_address",nullable = false, length = 128)
	private String emailAddress;
	
	@Column(nullable = false, length = 128)
	private String address;
	
	@Column(nullable = false, length = 128)
	private String city;
	
	@Column(nullable = false, length = 128)
	private String state;
	
	@Column(nullable=false)
	private boolean country;
	
	@Column(nullable = false, length = 128)
	private String pincode;
	
	@Column(name="reg_id",nullable = false)
	private int regId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isCountry() {
		return country;
	}

	public void setCountry(boolean country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public int getRegId() {
		return regId;
	}

	public void setRegId(int regId) {
		this.regId = regId;
	}

	@Override
	public String toString() {
		return "BookCustomers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", emailAddress=" + emailAddress + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", pincode=" + pincode + ", regId="
				+ regId + "]";
	}

	public BookCustomers() {
		
	}
	
	
}
