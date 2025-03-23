package com.aryak.db.service.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.Book;
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

        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setPrice(bookRequest.getPrice());
        book.setPublishedAt(bookRequest.getPublishedAt());
        bookDao.save(book);
    }

    @Override
    public Book findById(Integer bookId) {
        var bookOptional = bookDao.findById(bookId);
        return bookOptional.orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }
}
