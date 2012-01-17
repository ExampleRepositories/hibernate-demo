package com.bulain.hibernate.core;

import java.util.List;

import org.hibernate.Hibernate;

import com.bulain.common.exception.NotFoundException;
import com.bulain.common.exception.ServiceException;
import com.bulain.hibernate.util.ReflectionUtils;

public abstract class BasicServiceImpl<T> implements BasicService<T> {
    protected abstract BasicMapper<T> getBasicMapper();
    
    public T get(Integer id, List<String> properties) {
        T entity = getBasicMapper().selectByPrimaryKey(id);
        if (entity == null) {
            throw new NotFoundException();
        }
        
        if (properties != null) {
            for (String propertyName : properties) {
                Object proxy = ReflectionUtils.getFieldValue(entity, propertyName);
                if (!Hibernate.isInitialized(proxy)) {
                    Hibernate.initialize(proxy);
                }
            }
        }
        
        return entity;
    }
    
    public void insert(T record) {
        int count = getBasicMapper().insert(record);
        if (count != 1) {
            throw new ServiceException();
        }
    }
    
    public void update(T record) {
        int count = 0;
        count = getBasicMapper().updateByPrimaryKey(record);
        if (count != 1) {
            throw new ServiceException();
        }
    }
    
    public void delete(Integer id) {
        int count = getBasicMapper().deleteByPrimaryKey(id);
        if (count != 1) {
            throw new ServiceException();
        }
    }
}
