package com.aryak.db.dao.impl;


import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository
@ConditionalOnExpression("! ${cache.enabled}")
public class BookDaoJpaImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoJpaImpl() {
        log.info("JPA Impl was loaded.");
    }

    @Override
    public void save(Book book) {
        log.info("In SQL dao impl");
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return Optional.empty();
    }

}
