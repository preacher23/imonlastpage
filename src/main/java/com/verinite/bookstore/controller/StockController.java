package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Book;
import com.verinite.bookstore.entity.Stocks;
import com.verinite.bookstore.service.StockService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

@RequestMapping("/stock")
public class StockController {
	@Autowired
	StockService service;
	@PostMapping("/saveStock")
	Stocks saveStock(@RequestBody Stocks stock)
	{
		return service.saveStock(stock);
	}
	@PostMapping("/saveStockWithbookId")
	Stocks saveStock1(@PathVariable int bookId)
	{
		return service.saveStock1(bookId);
	}
	@GetMapping("/getAll")
	List<Stocks> getStocks()
	{
		return service.getAll();
	}
	@PatchMapping("/addquantity/bookId/{id}")
	Stocks update(@PathVariable int id, @RequestBody Stocks st)
	{
		return service.updaeStock(id,st);
	}

	
	  @GetMapping("/getByBookId/{bookId}") Stocks getByBookId(@PathVariable int
	 bookId) { return service.getByBookId(bookId); }
	 
	@GetMapping("/getByStockId/{stockId}")
	Stocks getByStockId(@PathVariable int stockId)
	{
		return service.getByStockId(stockId);
	}
	@PatchMapping("/decrease/{id}")
	public void decrease(@PathVariable int id,@RequestBody Book book)
	{
		service.decrease(id,book);
	}
}