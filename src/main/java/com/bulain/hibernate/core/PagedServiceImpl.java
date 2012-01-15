package com.bulain.hibernate.core;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.bulain.common.page.OrderBy;
import com.bulain.common.page.Page;

public abstract class PagedServiceImpl<T> extends BasicServiceImpl<T> implements PagedService<T> {
    protected abstract PagedMapper<T> getPagedMapper();

    protected BasicMapper<T> getBasicMapper() {
        return getPagedMapper();
    }

    public List<T> find(DetachedCriteria dc, OrderBy orderBy) {
        return getPagedMapper().find(dc, orderBy);
    }

    public Long count(DetachedCriteria dc) {
        return getPagedMapper().count(dc);
    }

    public List<T> page(DetachedCriteria dc, Page page, OrderBy orderBy) {
        return getPagedMapper().page(dc, page, orderBy);
    }
}
