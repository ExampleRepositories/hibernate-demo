package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.bulain.hibernate.entity.Apple;
import com.bulain.hibernate.entity.Fruit;
import com.bulain.hibernate.entity.Pear;
import com.bulain.hibernate.test.HibernateTestCase;

@SuppressWarnings("unchecked")
public class TableSubclassTest extends HibernateTestCase {
    @Test
    public void testTableConcreteClass() {
        Fruit fruit = new Fruit("fruit");
        Apple apple = new Apple("apple", "appleInfo");
        Pear pear = new Pear("pear", "pearInfo");

        session.save(fruit);
        session.save(apple);
        session.save(pear);
        
        List<Fruit> listFruit = session.createCriteria(Fruit.class).list();
        assertEquals(3, listFruit.size());
        
        List<Apple> listApple = session.createCriteria(Apple.class).list();
        assertEquals(1, listApple.size());
        
        List<Pear> listPear = session.createCriteria(Pear.class).list();
        assertEquals(1, listPear.size());
    }

}
