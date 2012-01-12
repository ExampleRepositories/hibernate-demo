package com.bulain.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.SeedDataSet;
import com.bulain.common.test.ServiceTestCase;

@SeedDataSet(file = "test-data/init_seed_dataset.xml")
public abstract class HibernateTestCase extends ServiceTestCase {
    @Autowired
    private SessionFactory sessionFactory;
    protected Session session;
    
    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }
    
    @After
    public void tearDown() {
        session.flush();
    }
}
