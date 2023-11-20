package com.verinite.bookstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
	 @Query(value="select * from tbl_orderbook where username=?1 Order by order_id ASC ",nativeQuery = true)
	List<OrderBook> find(String username);
	
	
	List<Object> findByBookId(int bookid);
	List<Object> findByBookTitle(String bookname);
	@Query(value="select * from tbl_orderbook where order_id=?1 OR book_id=?1",nativeQuery = true)
	List<OrderBook> findByIntegers(int num);

@Query(value="select * from tbl_orderbook where book_title=?1",nativeQuery = true)
	List<OrderBook> searchText(Object text);

}