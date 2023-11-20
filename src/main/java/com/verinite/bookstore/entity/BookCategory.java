package com.verinite.bookstore.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tbl_bookcategory")
public class BookCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    
    @Column(name="book_id")
    private int bookId;
    
    @Column(name="category_id")
    private int categoryId;
    
    @Column(name="created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdOn;
    
    @Column(name="updated_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedOn;
    
    
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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
	public BookCategory(int id, int bookId, int categoryId, Date createdOn, Date updatedOn) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.categoryId = categoryId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}
	
	public BookCategory() {
	}
	
	@Override
	public String toString() {
		return "BookCategory [id=" + id + ", bookId=" + bookId + ", categoryId=" + categoryId + ", createdOn="
				+ createdOn + ", updatedOn=" + updatedOn + "]";
	}
    
    
}
