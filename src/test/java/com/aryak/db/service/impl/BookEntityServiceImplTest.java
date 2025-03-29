package com.aryak.db.service.impl;

import com.aryak.db.dao.BookDao;
import com.aryak.db.domain.BookEntity;
import com.aryak.db.domain.BookRequest;
import com.aryak.db.exceptions.InvalidBookRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookEntityServiceImplTest {

    @InjectMocks
    BookServiceImpl bookService;

    @Mock
    BookDao bookDao;

    @Test
    void testAddBookWithValidParams() {

        BookRequest bookRequest = new BookRequest("",745, LocalDateTime.now());
        doNothing().when(bookDao).put(any());
        bookService.addBook(bookRequest);
        verify(bookDao, times(1)).put(any());
    }

    @Test
    void testAddBookWithInvalidParams() {

        BookRequest bookRequest = null;
        assertThrows(InvalidBookRequestException.class, () -> bookService.addBook(bookRequest));
    }

    @Test
    void findByIdWithValidBookId() {

        Integer id = 724;
        doReturn(Optional.of(new BookEntity())).when(bookDao).findById(id);
        BookEntity bookEntity = bookService.findById(id);
        assertThat(bookEntity).isNotNull();
    }

    @Test
    void findByIdWithInvalidBookId() {

        Integer id = null;
        doReturn(Optional.empty()).when(bookDao).findById(id);
        BookEntity bookEntity = bookService.findById(id);
        assertThat(bookEntity).isNull();
    }

    @Test
    void findAll() {

        // given
        BookEntity bookEntity = new BookEntity();
        bookEntity.setName("test");
        bookEntity.setPrice(43758);
        bookEntity.setPublishedAt(LocalDateTime.now());
        var books = List.of(bookEntity);

        // when
        doReturn(books).when(bookDao).findAll();
        var returnedBooks = bookService.findAll();

        // then
        assertThat(returnedBooks).isNotNull();
        assertThat(returnedBooks).isNotEmpty();
        assertThat(returnedBooks).hasSize(1);
    }

    @Test
    void addBook() {

        // Given
        BookRequest bookRequest = new BookRequest("", 745, LocalDateTime.now());

        // When
        bookService.addBook(bookRequest);

        // Then - Capture the argument passed to bookDao.save()
        ArgumentCaptor<BookEntity> bookCaptor = ArgumentCaptor.forClass(BookEntity.class);
        verify(bookDao, times(1)).put(bookCaptor.capture());

        // Assert that the book saved has correct properties
        BookEntity savedBookEntity = bookCaptor.getValue();
        assertEquals(bookRequest.getName(), savedBookEntity.getName());
        assertEquals(bookRequest.getPrice(), savedBookEntity.getPrice());
        assertEquals(bookRequest.getPublishedAt(), savedBookEntity.getPublishedAt());
    }
}