package com.aryak.db.dao;

import com.aryak.db.domain.Book;

import java.util.Optional;

public interface BookDao {

    void save(Book book);

    Optional<Book> findById(Integer id);
}
