package com.bulain.hibernate.core;

public interface BasicMapper<T> {
    int deleteByPrimaryKey(Integer id);
    int insert(T record);
    T selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(T record);
}
