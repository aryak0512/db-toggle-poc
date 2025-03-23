package com.aryak.db.dao.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@ConditionalOnExpression("${cache.enabled}")
public class BookDaoImpl implements BookDao {

    public BookDaoImpl() {
        log.info("Cache Impl was loaded.");
    }

    @Override
    public void save(Book book) {
        log.info("In cache dao impl");
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.empty();
    }
}
