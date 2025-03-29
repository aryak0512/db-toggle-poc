package com.aryak.db.config;

import com.aryak.db.dao.BookDao;
import com.aryak.db.dao.GenericBookDao;
import com.aryak.db.dao.impl.BookDaoImpl;
import com.aryak.db.dao.impl.BookDaoJpaImpl;
import com.aryak.db.dao.impl.v2.BookDaoImpl2;
import com.aryak.db.dao.impl.v2.BookDaoJpaImpl2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author aryak
 * This config bean conditionally toggles the implementation of dao layer
 */
@Configuration
public class DatabaseConfiguration {

    @Value("${cache.enabled:false}")
    boolean cacheEnabled;

    @Bean(value = "bookDao")
    public BookDao bookDao(BookDaoImpl cacheImpl, BookDaoJpaImpl sqlImpl) {
        return cacheEnabled ? cacheImpl : sqlImpl;
    }

    @Bean(value = "bookDao2")
    public GenericBookDao<?, ?> bookDao2(
            @Qualifier(value = "cacheImpl2") BookDaoImpl2 cacheImpl,
            @Qualifier(value = "sqlImpl2") BookDaoJpaImpl2 sqlImpl) {
        return cacheEnabled ? cacheImpl : sqlImpl;
    }
}
