package com.bulain.hibernate.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.test.ServiceTestCase;
import com.bulain.hibernate.entity.User;

@SuppressWarnings("unchecked")
@DataSet(file = "test-data/init_users.xml")
public class CriteriaTest extends ServiceTestCase{

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }

    @Test
    public void testCriteria() {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("firstName", "first_name_page"));
        criteria.add(Restrictions.eq("lastName", "last_name_page"));
        List<User> list = criteria.list();
        
        assertEquals(3, list.size());
    }
}
