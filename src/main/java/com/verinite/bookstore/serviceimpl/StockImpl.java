package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.Stocks;
import com.verinite.bookstore.repository.BookRepository;
import com.verinite.bookstore.repository.StockRepository;
import com.verinite.bookstore.service.StockService;

@Service
public class StockImpl implements StockService {

	@Autowired
	BookRepository bookrepo;
	@Autowired
	StockRepository stockrepo;
	@Override
	public Stocks saveStock(Stocks stock) {
		
		return stockrepo.save(stock);
	}
	@Override
	public List<Stocks> getAll() {
		
		return stockrepo.findAll();
	}
	@Override
	public Stocks updaeStock(int id, Stocks st) {
		try {
			Stocks stock=stockrepo.find(id);
			int a=stock.getQuantity();
			int b=st.getQuantity();
			int sum=a+b;
			System.out.println(stock);
			stock.setQuantity(sum);
			return stockrepo.save(stock);
		}
		catch(Exception ex)
		{
			return null;
		}
		
	}
	@Override
	public Stocks getByBookId(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Stocks getByStockId(int stockId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Stocks saveStock1(int bookId) {
		Stocks st=new Stocks();
		st.setBookId(bookId);
		return stockrepo.save(st);
	}
	@Override
	public void decrease(int id, Book book) {
		try {
			Stocks stockEntity=stockrepo.findByBookId(id);
			int stock=stockEntity.getQuantity();
			System.out.println(stock);
			int booked=book.getBookQty();
			System.out.println(booked);
			int newStock=stock-booked;
			System.out.println(newStock);
			stockEntity.setQuantity(newStock);
			stockrepo.save(stockEntity);
			
			
		}catch (Exception e) {
		}
		
	}

	
}