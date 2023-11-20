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

@Entity
@Table(name = "tbl_category")

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_title", nullable = false)
	private String categoryTitle;

	@Column(name = "created_on", insertable = true, nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name = "updated_on", insertable = true, updatable = true, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	@Column(name = "is_deleted", nullable = false)
	private boolean isDeleted;

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
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

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Category(int categoryId, String categoryTitle, Date createdOn, Date updatedOn, boolean isDeleted) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
		this.isDeleted = isDeleted;
	}

	public Category() {
		super();
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + ", isDeleted=" + isDeleted + "]";
	}

}
