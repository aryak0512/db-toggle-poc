package com.aryak.db;

import com.aryak.db.domain.BookRequest;
import com.aryak.db.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class CacheToSqlApplication implements CommandLineRunner {


	BookService bookService;

	public CacheToSqlApplication(BookService bookService) {
		this.bookService = bookService;
	}

	public static void main(String[] args) {
		SpringApplication.run(CacheToSqlApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		BookRequest bookRequest = new BookRequest("My first book",745, LocalDateTime.now());
		bookService.addBook(bookRequest);
	}
}
