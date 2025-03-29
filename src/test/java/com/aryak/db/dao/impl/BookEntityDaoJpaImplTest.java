package com.aryak.db.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@ExtendWith(SpringExtension.class)
@Transactional
@SpringBootTest// Runs with an in-memory database
@Profile("test")
class BookEntityDaoJpaImplTest {

    @Autowired
    private BookDao bookDao; // Uses the actual DAO bean

    @PersistenceContext
    EntityManager entityManager;

    @Test
    void testSaveAndFindById() {
        // Given
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("Spring Boot Testing");
        bookEntity.setPrice(999);
        bookEntity.setPublishedAt(LocalDateTime.now());

        // When
        bookDao.save(bookEntity);

        // Then
        Optional<BookEntity> retrievedBook = bookDao.findById(bookEntity.getId()); // Use actual ID
        assertThat(retrievedBook).isPresent();
        assertThat(retrievedBook.get().getName()).isEqualTo("Spring Boot Testing");
    }
}
