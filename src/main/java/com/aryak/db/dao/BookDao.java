package com.aryak.db.dao;

import com.aryak.db.domain.BookEntity;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    void save(BookEntity bookEntity);

    Optional<BookEntity> findById(Integer id);

    List<BookEntity> findAll();

    void update(BookEntity bookEntity);

    void deleteById(Integer id);
}
