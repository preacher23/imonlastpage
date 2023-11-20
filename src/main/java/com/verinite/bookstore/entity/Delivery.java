package com.verinite.bookstore.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
@Data
@Entity
@Table(name ="tbl_delivery")
public class Delivery {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="customer_name")
    private String customername;
    
   
    private String mobile_number;
    
    @Column(name = "address_1")
    private String address1;
    
    @Column(name = "address_2")
    private String address2;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="created_on")
    private Date createdon;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name ="updated_on")
    private Date updatedon;
    
    @Column(name ="city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name ="country")
    private String country;
    
    @Column(name ="pincode")
    private String pincode;
    
    @Column(name = "is_deleted")
	private Boolean isDeleted=false;
    
    public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name="customer_id")
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

	public Delivery() {
		
	}

	@Override
	public String toString() {
		return "Delivery [id=" + id + ", customername=" + customername + ", address1=" + address1 + ", address2="
				+ address2 + ", createdon=" + createdon + ", updatedon=" + updatedon + ", city=" + city + ", state="
				+ state + ", country=" + country + ", pincode=" + pincode + ", isDeleted=" + isDeleted + "]";
	}

	public Delivery(int id, String customername, String address1, String address2, Date createdon, Date updatedon,
			String city, String state, String country, String pincode, Boolean isDeleted) {
		super();
		this.id = id;
		this.customername = customername;
		this.address1 = address1;
		this.address2 = address2;
		this.createdon = createdon;
		this.updatedon = updatedon;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.isDeleted = isDeleted;
	}


}
