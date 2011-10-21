package com.bulain.hibernate.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.test.ServiceTestCase;
import com.bulain.hibernate.entity.User;

@SuppressWarnings("unchecked")
@DataSet(file = "test-data/init_users.xml")
public class NamedQueryTest extends ServiceTestCase {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }

    @Test
    public void testNamedQueryFind() {
        User search = new User();
        search.setFirstName("first_name_page");
        search.setLastName("last_name_page");

        List<User> list = session.getNamedQuery("User_find").setProperties(search).list();
        assertEquals(3, list.size());
    }

    @Test
    public void testNamedQueryCount() {
        User search = new User();
        search.setFirstName("first_name_page");
        search.setLastName("last_name_page");

        Number cnt = (Number) session.getNamedQuery("User_count").setProperties(search).uniqueResult();
        assertEquals(3, cnt.intValue());
    }

    @Test
    public void testNamedQueryPage() {
        User search = new User();
        search.setFirstName("first_name_page");
        search.setLastName("last_name_page");

        List<User> list = session.getNamedQuery("User_find").setProperties(search).setFirstResult(0).setMaxResults(10)
                .list();
        assertEquals(3, list.size());
    }
}
