package com.bulain.hibernate.core;

import java.util.List;

public class PagedMapperImpl<S, T> extends BasicMapperImpl<T> implements PagedMapper<S, T> {

    public PagedMapperImpl(){
        super();
    }
    
    public PagedMapperImpl(Class<T> clazz){
        this.entityClass = clazz;
    }
    
    public List<T> find(S search) {
        return null;
    }

    public Long count(S search) {
        return null;
    }

    public List<T> page(S search) {
        return null;
    }

}
