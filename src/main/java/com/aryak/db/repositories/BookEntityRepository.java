package com.aryak.db.repositories;

import com.aryak.db.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookEntityRepository extends JpaRepository<BookEntity, Integer> {
}
