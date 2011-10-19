package com.bulain.hibernate.core;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bulain.hibernate.util.ReflectionUtils;

public class BasicMapperImpl<T> extends HibernateDaoSupport implements BasicMapper<T> {

    protected Class<T> entityClass;

    public BasicMapperImpl(){
        this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
    }
    
    public BasicMapperImpl(Class<T> clazz){
        this.entityClass = clazz;
    }

    public int deleteByPrimaryKey(Integer id) {
        T entity = (T) getHibernateTemplate().load(entityClass, id);
        getHibernateTemplate().delete(entity);
        return 1;
    }

    public int insert(T record) {
        getHibernateTemplate().save(record);
        return 1;
    }

    public T selectByPrimaryKey(Integer id) {
        T object = (T) getHibernateTemplate().get(entityClass, id);
        return object;
    }

    public int updateByPrimaryKey(T record) {
        getHibernateTemplate().update(record);
        return 1;
    }

}
