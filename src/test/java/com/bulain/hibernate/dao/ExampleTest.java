package com.bulain.hibernate.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.test.ServiceTestCase;
import com.bulain.hibernate.entity.User;

@SuppressWarnings("unchecked")
@DataSet(file = "test-data/init_users.xml")
public class ExampleTest extends ServiceTestCase {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }

    @Test
    public void testExample() {
        User search = new User();
        search.setFirstName("first_name_page");
        search.setLastName("last_name_page");

        Example example = Example.create(search);
        
        Criteria criteria = session.createCriteria(User.class)
            .add(example);
        List<User> list = criteria.list();

        assertEquals(3, list.size());
    }

    @Test
    public void testPropertyExample() {
        User search = new User();
        search.setFirstName("first_name_page");
        search.setLastName("last_name_page");

        Example example = Example.create(search)
            //.excludeZeroes()
            //.excludeProperty("lastName")
            .ignoreCase()
            .enableLike(MatchMode.START);

        Criteria criteria = session.createCriteria(User.class)
            .add(example);

        List<User> list = criteria.list();

        assertEquals(3, list.size());
    }
}
