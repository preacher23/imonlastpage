package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.verinite.bookstore.entity.Category;
import com.verinite.bookstore.repository.CategoryRepository;
import com.verinite.bookstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

//Method for insert values in to table
	@Override
	public Object saveCategory(Category category) {
		category.setCreatedOn(new Date(System.currentTimeMillis()));
		category.setUpdatedOn(new Date(System.currentTimeMillis()));
		categoryRepository.save(category);
		return "message:Category " + category.getCategoryTitle() + " successfully saved";

	}
//Method for retrieving all data from Table

	@Override
	public List<Category> getAllCategorys() {
		List<Category> temproryList = new ArrayList<Category>();
//		for (Category category : categoryRepository.findAll()) {
//			if(!category.isDeleted())
//				temproryList.add(category);
//		}
		categoryRepository.findAll().forEach(a -> {
			if (!a.isDeleted())
				
				temproryList.add(a);
		});
		return temproryList;

	}

	// Entity Object to hold a temporary entity Objects
	Category categoryData;

	// Delete a record by using id
	// actually this method does not delete anything in Database instead of deleting
	// it makes is_deleted column as true
	@Override
	public String deleteCategory(int category_id) {
		try {
			categoryData = categoryRepository.findById(category_id).get();
		} catch (Exception e) {
			return "message:no data is present with this categoryId " + category_id;
		}
		if (!categoryData.isDeleted()) {
			categoryData.setDeleted(true);
			categoryRepository.save(categoryData);
			return "Successfully Deleted";
		} else if (categoryData.isDeleted()) {
			return "message:no data is present with this categoryId " + category_id;
		} else {
			return "message:no data is present with this categoryId " + category_id;
		}

	}

	// update category Records by using a CategoryId
	@Override
	public Object updateCategory(int category_id, Category category) {
		try {
			categoryData = categoryRepository.findById(category_id).get();

			if (categoryData.isDeleted()) {
				return "Error : There is no Data with this id  " + category_id;
			}
			categoryData.setCategoryTitle(category.getCategoryTitle());
			categoryData.setUpdatedOn(new Date());

			return categoryRepository.save(categoryData);
		} catch (Exception e) {

			return "no data is present with this categoryId " + category_id;
		}

	}

	// Get a one particular Record from table by using categoryId
	@Override
	public Object getCategoryById(int category_id) {
		try {
			categoryData = categoryRepository.findById(category_id).get();
			if (categoryData.isDeleted()) {
				return "Error : There is no Data with this category_id  " + category_id;
			} else {
				return categoryData;
			}

		} catch (Exception e) {
			return "no data is present with this categoryId " + category_id;
		}

	}

	public Object getCategoryByName(String category_name) {

		return categoryRepository.findByCategoryTitle(category_name);
	}

}