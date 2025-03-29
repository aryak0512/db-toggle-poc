package com.aryak.db.dao;

import java.util.List;
import java.util.Optional;

public interface BookDao<K, V> {

    void put(K k);

    K findById(int id);

    List<K> findAll();
}
