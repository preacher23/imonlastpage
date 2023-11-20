package com.verinite.bookstore.service;

import java.util.List;

import com.verinite.bookstore.entity.BookCategory;

public interface BookCategoryService {
    List<BookCategory> getBookCategory();

    Object getBookCategoryId(int categoryid);

    BookCategory createBookCategory(BookCategory bookCategory);


    Object updateBookCategory(int id,BookCategory bookCategory);
}
