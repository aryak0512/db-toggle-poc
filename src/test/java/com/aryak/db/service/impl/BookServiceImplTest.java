package com.aryak.db.service.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.Book;
import com.aryak.db.domain.BookRequest;
import com.aryak.db.exceptions.InvalidBookRequestException;
import com.aryak.db.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceImplTest {

    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookDao bookDao;

    @Test
    void testAddBookWithValidParams() {

        BookRequest bookRequest = new BookRequest("",745, LocalDateTime.now());
        when(bookDao.save(any())).thenReturn(any());
        bookService.addBook(bookRequest);
        verify(bookDao, times(1)).save(any());
    }

    @Test
    void testAddBookWithInvalidParams() {

        BookRequest bookRequest = null;
        assertThrows(InvalidBookRequestException.class, () -> bookService.addBook(bookRequest));
    }

    @Test
    void findByIdWithValidBookId() {

        Integer id = 724;
        doReturn(Optional.of(new Book())).when(bookDao).findById(id);
        Book book = bookService.findById(id);
        assertThat(book).isNotNull();
    }

    @Test
    void findByIdWithInvalidBookId() {

        Integer id = null;
        doReturn(Optional.empty()).when(bookDao).findById(id);
        Book book = bookService.findById(id);
        assertThat(book).isNull();
    }

    @Test
    void findAll() {
    }
}