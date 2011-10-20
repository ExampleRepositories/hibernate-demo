package com.bulain.hibernate.core;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.bulain.common.page.OrderBy;
import com.bulain.common.page.Page;

@SuppressWarnings("unchecked")
public class PagedMapperImpl<T> extends BasicMapperImpl<T> implements PagedMapper<T> {

    private static final String ORDER_DESC = "desc";

    public PagedMapperImpl() {
        super();
    }

    public PagedMapperImpl(Class<T> clazz) {
        super(clazz);
    }

    public List<T> find(DetachedCriteria dc, OrderBy orderBy) {
        if (ORDER_DESC.equals(orderBy.getSequance())) {
            dc.addOrder(Order.desc(orderBy.getOrderBy()));
        } else {
            dc.addOrder(Order.asc(orderBy.getOrderBy()));
        }
        Criteria criteria = dc.getExecutableCriteria(getSession());
        return criteria.list();
    }

    public Long count(DetachedCriteria dc) {
        Criteria criteria = dc.getExecutableCriteria(getSession()).setProjection(Projections.rowCount());
        Integer cnt = (Integer)criteria.uniqueResult();
        return Long.valueOf(cnt.longValue());
    }

    public List<T> page(DetachedCriteria dc, Page page, OrderBy orderBy) {
        // set pagination
        Long cnt = count(dc);
        page.setCount(cnt);
        dc.setProjection(null);

        // add page info and order info
        if (ORDER_DESC.equals(orderBy.getSequance())) {
            dc.addOrder(Order.desc(orderBy.getOrderBy()));
        } else {
            dc.addOrder(Order.asc(orderBy.getOrderBy()));
        }
        Criteria criteria = dc.getExecutableCriteria(getSession());
        criteria.setFirstResult((int) page.getLow());
        criteria.setMaxResults((int) page.getPageSize());

        return criteria.list();
    }

}
