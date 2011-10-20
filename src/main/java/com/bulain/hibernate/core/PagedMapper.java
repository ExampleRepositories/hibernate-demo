package com.bulain.hibernate.core;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.bulain.common.page.OrderBy;
import com.bulain.common.page.Page;

public interface PagedMapper<T> extends BasicMapper<T> {
    List<T> find(DetachedCriteria dc, OrderBy orderBy);
    Long count(DetachedCriteria dc);
    List<T> page(DetachedCriteria dc, Page page, OrderBy orderBy);
}
