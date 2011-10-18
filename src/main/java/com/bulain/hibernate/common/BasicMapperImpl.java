package com.bulain.hibernate.common;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class BasicMapperImpl<T> extends HibernateDaoSupport implements BasicMapper<T> {

    protected abstract Class<T> getEntityClass();

    public int deleteByPrimaryKey(Integer id) {
        Class<T> entityClass = getEntityClass();
        T entity = (T) getHibernateTemplate().load(entityClass, id);
        getHibernateTemplate().delete(entity);
        return 1;
    }

    public int insert(T record) {
        getHibernateTemplate().save(record);
        return 1;
    }

    public T selectByPrimaryKey(Integer id) {
        Class<T> entityClass = getEntityClass();
        T object = (T) getHibernateTemplate().get(entityClass, id);
        return object;
    }

    public int updateByPrimaryKey(T record) {
        getHibernateTemplate().update(record);
        return 1;
    }

}
