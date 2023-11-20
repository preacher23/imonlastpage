package com.verinite.bookstore.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository <BookCategory , Integer> {
	@Query(value = "SELECT b.book_id, b.book_price,b.book_title,b.description,bg.category_id,bg.id,c.category_title\n" +
	        "\tFROM tbl_book b inner join tbl_bookcategory bg on bg.book_id=b.book_id inner join tbl_category c on c.category_id=bg.category_id",nativeQuery = true)
	    List<Map<String, String>> getAllData();
	
}
