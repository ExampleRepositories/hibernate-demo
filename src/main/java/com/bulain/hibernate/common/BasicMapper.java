package com.bulain.hibernate.common;

public interface BasicMapper<T> {
    int deleteByPrimaryKey(Integer id);
    int insert(T record);
    T selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(T record);
}
