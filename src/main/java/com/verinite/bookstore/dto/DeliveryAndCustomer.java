package com.verinite.bookstore.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class DeliveryAndCustomer {

	  private int id;

	    private String customername;
	    
	    private String address1;
	    
	    private String address2;
	    
	    private Date createdon;
	    
	    private Date updatedon;
	    
	    
	    private String city;
	    
	    
	    private String state;
	    
	    
	    private String country;
	    
	   
	    private String pincode;
	    
	    private int customerId;
	    
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getCustomername() {
			return customername;
		}

		public void setCustomername(String customername) {
			this.customername = customername;
		}

		public String getAddress1() {
			return address1;
		}

		public void setAddress1(String address1) {
			this.address1 = address1;
		}

		public String getAddress2() {
			return address2;
		}

		public void setAddress2(String address2) {
			this.address2 = address2;
		}

		public Date getCreatedon() {
			return createdon;
		}

		public void setCreatedon(Date createdon) {
			this.createdon = createdon;
		}

		public Date getUpdatedon() {
			return updatedon;
		}

		public void setUpdatedon(Date updatedon) {
			this.updatedon = updatedon;
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

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

		public String getPincode() {
			return pincode;
		}

		public void setPincode(String pincode) {
			this.pincode = pincode;
		}

		public Boolean getIsDeleted() {
			return isDeleted;
		}

		public void setIsDeleted(Boolean isDeleted) {
			this.isDeleted = isDeleted;
		}

		private Boolean isDeleted=false;
}
