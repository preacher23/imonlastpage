package com.verinite.bookstore.entity;

import java.util.Arrays;
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
@Table(name = "tbl_book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "book_id")
	private int bookId;

	@Column(name = "book_title", nullable = false, length = 200)
	private String bookTitle;

	private String description;

	@Column(name = "book_price")
	private Double bookPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
	private Date updatedOn;

	@Column(name = "publisher_id")
	private int publisherId;

	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	@Column(name = "pic_byte", length = 1000)
	private byte[] picByte;
	
	private int bookQty;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
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

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}

	public Book() {
		super();
	}

	public Book(int bookId, String bookTitle, String description, Double bookPrice, Date createdOn, Date updatedOn,
			int publisherId, boolean isDeleted, byte[] picByte) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.description = description;
		this.bookPrice = bookPrice;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.publisherId = publisherId;
		this.isDeleted = isDeleted;
		this.picByte = picByte;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookTitle=" + bookTitle + ", description=" + description + ", bookPrice="
				+ bookPrice + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + ", publisherId=" + publisherId
				+ ", isDeleted=" + isDeleted + ", picByte=" + Arrays.toString(picByte) + "]";
	}

	

	
}
