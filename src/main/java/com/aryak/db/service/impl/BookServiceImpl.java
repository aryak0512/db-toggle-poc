package com.aryak.db.service.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import com.aryak.db.domain.BookRequest;
import com.aryak.db.exceptions.InvalidBookRequestException;
import com.aryak.db.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao<BookEntity, Integer> bookDao;

    @SuppressWarnings(value = "unchecked")
    public BookServiceImpl(ApplicationContext context) {
        this.bookDao = (BookDao<BookEntity, Integer>) context.getBean("bookDao");
    }

    @Override
    public void addBook(BookRequest bookRequest) {

        if ( bookRequest == null ) {
            throw new InvalidBookRequestException();
        }

        BookEntity bookEntity = new BookEntity();
        bookEntity.setName(bookRequest.getName());
        bookEntity.setPrice(bookRequest.getPrice());
        bookEntity.setPublishedAt(bookRequest.getPublishedAt());
        bookDao.put(bookEntity);
    }

    @Override
    public BookEntity findById(Integer bookId) {
        return bookDao.findById(bookId).orElse(null);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookDao.findAll();
    }
}
