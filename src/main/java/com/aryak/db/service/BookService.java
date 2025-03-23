package com.aryak.db.service;

import com.aryak.db.domain.Book;
import com.aryak.db.domain.BookRequest;

import java.util.List;

public interface BookService {

    void addBook(BookRequest bookRequest);

    Book findById(Integer bookId);

    List<Book> findAll();
}
