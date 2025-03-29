package com.aryak.db.service;

import com.aryak.db.domain.BookEntity;
import com.aryak.db.domain.BookRequest;

import java.util.List;

public interface BookService {

    void addBook(BookRequest bookRequest);

    BookEntity findById(Integer bookId);

    List<BookEntity> findAll();
}
