package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Category;

public interface CategoryService {
	public Object saveCategory(Category category);

	public List<Category> getAllCategorys();

	public Object updateCategory(int category_id, Category category);

	public String deleteCategory(int category_id);

	public Object getCategoryById(int category_id);

}
