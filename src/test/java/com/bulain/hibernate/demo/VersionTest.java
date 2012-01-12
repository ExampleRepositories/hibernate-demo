package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.bulain.common.dataset.DataSetTestExecutionListener;
import com.bulain.hibernate.entity.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(value = { DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class, DataSetTestExecutionListener.class })
@ContextConfiguration(locations = { "classpath*:spring/applicationContext*.xml",
        "classpath*:spring/propertyConfigurer-test.xml" })
public class VersionTest {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Test
    public void testVersion() {
        Session session = sessionFactory.openSession();
        Person person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        Transaction tx = session.beginTransaction();
        session.save(person);
        tx.commit();
        Integer version = person.getVersion();
        assertEquals(Integer.valueOf(0), version);
        
        person = (Person) session.get(Person.class, person.getId());
        person.setFirstName("firstName-updated");
        person.setLastName("lastName-updated");
        tx = session.beginTransaction();
        session.update(person);
        tx.commit();
        version = person.getVersion();
        assertEquals(Integer.valueOf(1), version);
        
        person = (Person) session.get(Person.class, person.getId());
        person.setFirstName("firstName-again");
        person.setLastName("lastName-again");
        tx = session.beginTransaction();
        session.update(person);
        tx.commit();
        version = person.getVersion();
        assertEquals(Integer.valueOf(2), version);
    }
}
