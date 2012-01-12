package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.test.SpringTestCase;
import com.bulain.hibernate.entity.Person;

public class VersionTest extends SpringTestCase{
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
