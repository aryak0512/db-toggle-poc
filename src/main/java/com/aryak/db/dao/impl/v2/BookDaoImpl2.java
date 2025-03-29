package com.aryak.db.dao.impl.v2;

import com.aryak.db.dao.GenericBookDao;
import com.aryak.db.domain.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * This is a cache impl
 */
@Component(value = "cacheImpl2")
@Slf4j
public class BookDaoImpl2 implements GenericBookDao<Book, Object> {

    @Override
    public void put(Book book) {
        log.info("Inside put of ignite cache");
    }

    @Override
    public Book get(Object o) {
        log.info("Inside get of ignite cache");
        return null;
    }
}
