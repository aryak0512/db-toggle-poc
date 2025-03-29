package com.aryak.db.dao.impl;


import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component(value = "sqlImpl")
public class BookDaoJpaImpl implements BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public BookDaoJpaImpl() {
        log.info("JPA Impl was loaded.");
    }

    @Override
    public void save(BookEntity bookEntity) {
        log.info("Saving book to SQL memory database: {}", bookEntity);
        entityManager.persist(bookEntity); // Inserts the entity
        log.info("Saved book to SQL memory database: {}", bookEntity.getId());
    }

    @Override
    public Optional<BookEntity> findById(Integer id) {
        log.info("Finding book with ID: {}", id);
        BookEntity bookEntity = entityManager.find(BookEntity.class, id); // Finds the book by primary key
        return Optional.ofNullable(bookEntity);
    }

    @Override
    public List<BookEntity> findAll() {
        log.info("Fetching all books from SQL database");
        TypedQuery<BookEntity> query = entityManager.createQuery("SELECT b FROM BookEntity b", BookEntity.class);
        return query.getResultList();
    }

    @Override
    public void update(BookEntity bookEntity) {
        log.info("Updating book with ID: {}", bookEntity.getId());
        entityManager.merge(bookEntity); // Updates the entity
    }

    @Override
    public void deleteById(Integer id) {
        log.info("Deleting book with ID: {}", id);
        BookEntity bookEntity = entityManager.find(BookEntity.class, id);
        if ( bookEntity != null) {
            entityManager.remove(bookEntity);
        }
    }

}
