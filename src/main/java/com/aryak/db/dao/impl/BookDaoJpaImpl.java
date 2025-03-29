package com.aryak.db.dao.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * This is a sql impl
 */
@Component(value = "sqlImpl")
@Slf4j
public class BookDaoJpaImpl implements BookDao<BookEntity, Integer> {

    @Override
    public void put(BookEntity bookEntity) {
        log.info("Inside put of sql cache");
    }

    @Override
    public BookEntity get(Integer o) {
        log.info("Inside get of sql cache");
        return null;
    }

    @Override
    public Optional<BookEntity> findById(int id) {
        return Optional.empty();
    }

    @Override
    public List<BookEntity> findAll() {
        return List.of();
    }
}
