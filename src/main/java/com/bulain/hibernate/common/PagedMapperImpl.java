package com.bulain.hibernate.common;

import java.util.List;

public abstract class PagedMapperImpl<S, T> extends BasicMapperImpl<T> implements PagedMapper<S, T> {

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
