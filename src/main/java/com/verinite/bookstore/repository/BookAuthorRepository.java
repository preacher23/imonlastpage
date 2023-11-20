package com.verinite.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.BookAuthor;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
	@Query(value = "select * from tbl_bookauthor Order by id ASC", nativeQuery = true)
	List<BookAuthor> find();

}