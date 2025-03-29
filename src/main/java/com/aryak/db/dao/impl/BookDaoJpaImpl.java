package com.aryak.db.dao.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import com.aryak.db.repositories.BookEntityRepository;
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

    private final BookEntityRepository bookEntityRepository;

    public BookDaoJpaImpl(BookEntityRepository bookEntityRepository) {
        this.bookEntityRepository = bookEntityRepository;
    }

    @Override
    public void put(BookEntity bookEntity) {
        log.info("Inside put of sql cache");
    }

    @Override
    public BookEntity findById(int id) {
        return bookEntityRepository.findById(id).orElse(null);
    }

    @Override
    public List<BookEntity> findAll() {
        return bookEntityRepository.findAll();
    }
}
