package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.Stocks;


public interface StockService {

	Stocks saveStock(Stocks stock);

	List<Stocks> getAll();

	Stocks updaeStock(int id, Stocks st);

	Stocks getByBookId(int bookId);

	Stocks getByStockId(int stockId);

	Stocks saveStock1(int bookId);

	void decrease(int id, Book book);

}