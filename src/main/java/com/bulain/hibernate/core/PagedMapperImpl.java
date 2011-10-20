package com.bulain.hibernate.core;

import java.util.List;

import org.hibernate.Query;
import org.springframework.util.ClassUtils;

import com.bulain.common.page.Search;

@SuppressWarnings("unchecked")
public class PagedMapperImpl<T, S extends Search> extends BasicMapperImpl<T> implements PagedMapper<T, S> {

    public PagedMapperImpl() {
        super();
    }

    public PagedMapperImpl(Class<T> clazz) {
        super(clazz);
    }

    public List<T> find(S search) {
        String shortName = ClassUtils.getShortName(entityClass);
        Query namedQuery = getSession().getNamedQuery(String.format("%s_%s", shortName, "find"));
        namedQuery.setProperties(search);
        return namedQuery.list();
    }

    public Long count(S search) {
        String shortName = ClassUtils.getShortName(entityClass);
        Query namedQuery = getSession().getNamedQuery(String.format("%s_%s", shortName, "count"));
        namedQuery.setProperties(search);
        return (Long) namedQuery.uniqueResult();
    }

    public List<T> page(S search) {
        String shortName = ClassUtils.getShortName(entityClass);
        Query namedQuery = getSession().getNamedQuery(String.format("%s_%s", shortName, "find"));
        namedQuery.setFirstResult((int) search.getLow());
        namedQuery.setMaxResults((int) search.getHigh());
        namedQuery.setProperties(search);
        return namedQuery.list();
    }

}
