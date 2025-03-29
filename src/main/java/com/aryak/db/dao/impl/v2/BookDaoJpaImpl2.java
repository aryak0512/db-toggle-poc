package com.aryak.db.dao.impl.v2;

import com.aryak.db.dao.GenericBookDao;
import com.aryak.db.domain.BookEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * This is a sql impl
 */
@Component(value = "sqlImpl2")
@Slf4j
public class BookDaoJpaImpl2 implements GenericBookDao<BookEntity, Integer> {

    @Override
    public void put(BookEntity bookEntity) {
        log.info("Inside put of sql cache");
    }

    @Override
    public BookEntity get(Integer o) {
        log.info("Inside get of sql cache");
        return null;
    }
}
