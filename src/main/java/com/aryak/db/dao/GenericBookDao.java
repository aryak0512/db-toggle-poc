package com.aryak.db.dao;

public interface GenericBookDao<K, V> {

    void put(K k);

    K get(V v);
}
