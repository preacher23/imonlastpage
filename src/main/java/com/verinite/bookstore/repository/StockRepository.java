package com.verinite.bookstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.Stocks;

@Repository
public interface StockRepository extends JpaRepository<Stocks, Integer>{

	

	@Query(value = "select * from stock where book_id=?1",nativeQuery = true)
	Stocks find(int id);

	Stocks findByBookId(int bookId);


}
