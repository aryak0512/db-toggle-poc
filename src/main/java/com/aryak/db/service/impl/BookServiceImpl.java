package com.aryak.db.service.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import com.aryak.db.domain.BookRequest;
import com.aryak.db.exceptions.InvalidBookRequestException;
import com.aryak.db.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
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
        bookDao.save(bookEntity);
    }

    @Override
    public BookEntity findById(Integer bookId) {
        var bookOptional = bookDao.findById(bookId);
        return bookOptional.orElse(null);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookDao.findAll();
    }
}
