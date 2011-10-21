package com.bulain.hibernate.core;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.impl.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;

import com.bulain.common.page.OrderBy;
import com.bulain.common.page.Page;
import com.bulain.hibernate.util.ReflectionUtils;

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
        Criteria criteria = dc.getExecutableCriteria(getSession());

        CriteriaImpl impl = (CriteriaImpl) criteria;

        // backup Projection, ResultTransformer, OrderBy
        Projection projection = impl.getProjection();
        ResultTransformer transformer = impl.getResultTransformer();
        List<CriteriaImpl.OrderEntry> orderEntries = (List<CriteriaImpl.OrderEntry>) ReflectionUtils.getFieldValue(impl, "orderEntries");
        ReflectionUtils.setFieldValue(impl, "orderEntries", new ArrayList<CriteriaImpl.OrderEntry>());

        // count
        Number cnt = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();
        long totalCount = cnt.longValue();

        // restore Projection, ResultTransformer, OrderBy
        criteria.setProjection(projection);
        if (projection == null) {
            criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
        }
        if (transformer != null) {
            criteria.setResultTransformer(transformer);
        }
        ReflectionUtils.setFieldValue(impl, "orderEntries", orderEntries);

        return totalCount;
    }

    public List<T> page(DetachedCriteria dc, Page page, OrderBy orderBy) {
        // set pagination
        Long cnt = count(dc);
        page.setCount(cnt);

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
