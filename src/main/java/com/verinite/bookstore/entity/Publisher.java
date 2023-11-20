package com.verinite.bookstore.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_publisher")
public class Publisher {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int publisherId;
    
    @Column(name = "publisher_name")
    private String publisherName;
    
    private String address;
    private String city;
    private String state;
    @Column(insertable = true, updatable = true,name= "updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateOn;
    
    @Column(name = "is_deleted")
    private Boolean isDeleted=false;
    
    private String country;
    private String pincode;
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
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
	public Date getUpdateOn() {
		return updateOn;
	}
	public void setUpdateOn(Date updateOn) {
		this.updateOn = updateOn;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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
	public Publisher(int publisherId, String publisherName, String address, String city, String state, Date updateOn,
			Boolean isDeleted, String country, String pincode) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.updateOn = updateOn;
		this.isDeleted = isDeleted;
		this.country = country;
		this.pincode = pincode;
	}
	public Publisher() {
		
	}
	@Override
	public String toString() {
		return "Publisher [publisherId=" + publisherId + ", publisherName=" + publisherName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", updateOn=" + updateOn + ", isDeleted=" + isDeleted
				+ ", country=" + country + ", pincode=" + pincode + "]";
	}
    
    
}
