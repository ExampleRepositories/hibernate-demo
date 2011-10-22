package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.bulain.common.dataset.DataSet;
import com.bulain.hibernate.entity.User;
import com.bulain.hibernate.test.HibernateTestCase;

@SuppressWarnings("unchecked")
@DataSet(file = "test-data/init_users.xml")
public class DetachedCriteriaTest extends HibernateTestCase{

    @Test
    public void testDetachedCriteria() {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("firstName", "first_name_page"));
        criteria.add(Restrictions.eq("lastName", "last_name_page"));
        List<User> list = criteria.getExecutableCriteria(session).list();
        
        assertEquals(3, list.size());
    }
    
    @Test
    public void testDetachedCriteriaForExample() {
        User search = new User();
        search.setFirstName("first_name_page");
        search.setLastName("last_name_page");

        Example example = Example.create(search);
        
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(example);
        List<User> list = criteria.getExecutableCriteria(session).list();
        
        assertEquals(3, list.size());
    }
}
