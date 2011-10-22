package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.bulain.common.dataset.DataSet;
import com.bulain.hibernate.entity.User;
import com.bulain.hibernate.test.HibernateTestCase;

@SuppressWarnings("unchecked")
@DataSet(file = "test-data/init_users.xml")
public class CriteriaTest extends HibernateTestCase{

    @Test
    public void testCriteria() {
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("firstName", "first_name_page"));
        criteria.add(Restrictions.eq("lastName", "last_name_page"));
        List<User> list = criteria.list();
        
        assertEquals(3, list.size());
    }
}
