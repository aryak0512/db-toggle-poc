package com.aryak.db.dao.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.Book;
import com.aryak.db.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This is a cache impl
 */
@Component(value = "cacheImpl")
@Slf4j
public class BookDaoImpl implements BookDao<Book, Object> {

    private final BookRepository bookRepository;

    public BookDaoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void put(Book book) {
        bookRepository.save(book);
        log.info("Inside put of ignite cache");
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
