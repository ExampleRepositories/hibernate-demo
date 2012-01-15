package com.bulain.hibernate.core;

public interface BasicService<T> {
    T get(Integer id);
    void insert(T record);
    void update(T record);
    void delete(Integer id);
    long countByDuplicate(T record);
}
