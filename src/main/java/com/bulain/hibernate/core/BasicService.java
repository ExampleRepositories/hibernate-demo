package com.bulain.hibernate.core;

import java.util.List;

public interface BasicService<T> {
    T get(Integer id, List<String> properties);
    void insert(T record);
    void update(T record);
    void delete(Integer id);
    long countByDuplicate(T record);
}
