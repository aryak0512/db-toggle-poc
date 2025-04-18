package com.aryak.db;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import com.aryak.db.domain.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CacheToSqlApplication implements CommandLineRunner {

    @Value("${cache.enabled:false}")
    boolean cacheEnabled;

    private final ApplicationContext context;

    public CacheToSqlApplication(ApplicationContext context) {
        this.context = context;
    }

    public static void main(String[] args) {
        SpringApplication.run(CacheToSqlApplication.class, args);
    }

    @SuppressWarnings(value = "unchecked")
    @Override
    public void run(String... args) throws Exception {

        Book book = getBook(); // ignite
        BookEntity bookEntity = getBookEntity(); // sql

        if ( cacheEnabled ) {
            BookDao<Book, Object> dao = (BookDao<Book, Object>) context.getBean("bookDao2");
            dao.put(book);
        } else {
            BookDao<BookEntity, Integer> dao = (BookDao<BookEntity, Integer>) context.getBean("bookDao2");
            dao.put(bookEntity);
        }
    }

    private Book getBook() {
        return Book.builder()
                .id(7)
                .name("Test")
                .price(5637)
                .build();
    }

    private BookEntity getBookEntity() {
        return BookEntity.builder()
                .id(7)
                .name("Test")
                .price(5637)
                .build();
    }
}
