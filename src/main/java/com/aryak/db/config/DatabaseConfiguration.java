package com.aryak.db.config;

import com.aryak.db.dao.BookDao;
import com.aryak.db.dao.impl.BookDaoImpl;
import com.aryak.db.dao.impl.BookDaoJpaImpl;
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

    /**
     * toggle the impl conditionally
     * @param cacheImpl - interacts with Ignite
     * @param sqlImpl - interacts with SQL
     * @return
     */
    @Bean(value = "bookDao")
    @SuppressWarnings("all")
    public BookDao<?, ?> bookDao(
            @Qualifier("cacheImpl") BookDaoImpl cacheImpl,
            @Qualifier("sqlImpl") BookDaoJpaImpl sqlImpl) {

        return cacheEnabled ? cacheImpl : sqlImpl;
    }


}
