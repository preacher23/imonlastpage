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

@Table(name = "tbl_bookauthor")
@Entity
public class BookAuthor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "book_id")
	private int bookId;

	@Column(name = "author_id")
	private int authorId;

	// @Basic(optional = false)
//	@Column(nullable=false ,insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on")
	private Date createdOn;

	// @Basic(optional = false)
//	@Column(insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_on")
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

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
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

	public BookAuthor(int id, int bookId, int authorId, Date createdOn, Date updatedOn) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.authorId = authorId;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public BookAuthor() {
		super();
	}

	@Override
	public String toString() {
		return "BookAuthor [id=" + id + ", bookId=" + bookId + ", authorId=" + authorId + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}

}