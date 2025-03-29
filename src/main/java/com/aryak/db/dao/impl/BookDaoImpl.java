package com.aryak.db.dao.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component(value = "cacheImpl")
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoImpl() {
        log.info("Cache Impl was loaded.");
    }

    @Override
    public void save(BookEntity bookEntity) {
        log.info("Saving book to in memory database: {}", bookEntity);
        entityManager.persist(bookEntity); // Inserts the entity
        log.info("Saved book to in memory database: {}", bookEntity.getId());
    }

    @Override
    public Optional<BookEntity> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(BookEntity.class, id));
    }

    @Override
    public List<BookEntity> findAll() {
        // get from cache
        return List.of();
    }

    @Override
    public void update(BookEntity bookEntity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
