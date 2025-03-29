package com.aryak.db.dao.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.Book;
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

    @Override
    public void put(Book book) {
        log.info("Inside put of ignite cache");
    }

    @Override
    public Book get(Object o) {
        log.info("Inside get of ignite cache");
        return null;
    }

    @Override
    public Optional<Book> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<Book> findAll() {
        return List.of();
    }
}
