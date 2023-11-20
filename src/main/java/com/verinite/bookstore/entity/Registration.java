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

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tbl_registration")
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "register_id")
	private int registerId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_role")
	private String userRole;
	private String emailaddress;
	@Column(name = "mobile_number")
	private String mobileNumber;
	private String password;
	@Column(name = "confirm_password")
	private String confirmPassword;
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn=new Date(System.currentTimeMillis());
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
	private Date updatedOn=new Date(System.currentTimeMillis());
	@Column(name = "is_delete")
	private boolean isDelete;
	
	
	
	public int getRegisterId() {
		return registerId;
	}

	public void setRegisterId(int registerId) {
		this.registerId = registerId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public boolean isDelete() {
		return isDelete;
	}

	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Registration(int registerId, String userName, String emailaddress, String mobileNumber, String password,
			String confirmPassword, Date createdOn, Date updatedOn, boolean isDelete) {
		super();
		this.registerId = registerId;
		this.userName = userName;
		this.emailaddress = emailaddress;
		this.mobileNumber = mobileNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.isDelete = isDelete;
	}

	public Registration() {
		super();
	}

	@Override
	public String toString() {
		return "Registration [registerId=" + registerId + ", userName=" + userName + ", emailaddress=" + emailaddress
				+ ", mobileNumber=" + mobileNumber + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", isDelete=" + isDelete + "]";
	}

	
	

}
