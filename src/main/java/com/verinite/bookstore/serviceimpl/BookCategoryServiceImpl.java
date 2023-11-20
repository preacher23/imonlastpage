package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.BookCategory;
import com.verinite.bookstore.repository.BookCategoryRepository;
import com.verinite.bookstore.service.BookCategoryService;
@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> getBookCategory() {
        List<BookCategory>booklist = new ArrayList<BookCategory>();
        bookCategoryRepository.findAll().forEach(bookCategory -> booklist.add(bookCategory));
        return booklist;
    }

    @Override
    public Object getBookCategoryId(int categoryid) {
        try {
            return bookCategoryRepository.findById(categoryid).get();
        } catch (Exception e) {
            return "id not present" + categoryid;
        }
    }

    @Override
    public BookCategory createBookCategory(BookCategory bookCategory) {
        bookCategory.setCreatedOn(new Date());
        bookCategory.setUpdatedOn(new Date());
        return bookCategoryRepository.save(bookCategory);
    }


    @Override
    public Object updateBookCategory(int id,BookCategory bookCategory) {
        try {
            BookCategory oldbookCategory = (BookCategory)bookCategoryRepository.findById(id).get();
            oldbookCategory.setUpdatedOn(new Date());
            oldbookCategory.setCategoryId(bookCategory.getCategoryId());
            oldbookCategory.setBookId(bookCategory.getBookId());

            return bookCategoryRepository.save(oldbookCategory);
        } catch (Exception c) {
            return  "id not present"  + id ;

        }

    }
}
