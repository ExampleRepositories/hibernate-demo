package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.bulain.hibernate.entity.Person;
import com.bulain.hibernate.test.HibernateTestCase;

public class VersionTest extends HibernateTestCase {
    private static Person person;
    
    @Test
    public void testInsert() {
        person = new Person();
        person.setFirstName("firstName");
        person.setLastName("lastName");
        session.save(person);
    }
    
    @Test
    public void testVersion() {
        Integer version = person.getVersion();
        
        person.setFirstName("firstName-updated");
        person.setLastName("lastName-updated");
        session.update(person);
        Integer versionUpdated = person.getVersion();
        
        assertEquals(version, versionUpdated);
    }
}
