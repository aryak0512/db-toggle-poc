package com.aryak.db.dao;

import java.util.List;
import java.util.Optional;

public interface BookDao<K, V> {

    void put(K k);

    K get(V v);

    Optional<K> findById(int id);

    List<K> findAll();
}
