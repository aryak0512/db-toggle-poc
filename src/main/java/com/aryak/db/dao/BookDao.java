package com.aryak.db.dao;

import com.aryak.db.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Integer> {

}
