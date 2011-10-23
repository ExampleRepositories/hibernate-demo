package com.bulain.hibernate.demo;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.bulain.common.dataset.DataSet;
import com.bulain.hibernate.entity.User;
import com.bulain.hibernate.test.HibernateTestCase;

@SuppressWarnings("unchecked")
@DataSet(file = "test-data/init_users.xml")
public class FetchModeTest extends HibernateTestCase {
    @Test
    public void testFetchModeStart() {
        List<User> list = session.createCriteria(User.class)
                .add(Restrictions.like("firstName", "first_name", MatchMode.START).ignoreCase()).list();
        assertEquals(7, list.size());
    }
    
    @Test
    public void testFetchModeAnywhere() {
        List<User> list = session.createCriteria(User.class)
                .add(Restrictions.like("firstName", "first_name", MatchMode.ANYWHERE).ignoreCase()).list();
        assertEquals(7, list.size());
    }
    
    @Test
    public void testFetchModeEnd() {
        List<User> list = session.createCriteria(User.class)
                .add(Restrictions.like("firstName", "page", MatchMode.END)).list();
        assertEquals(3, list.size());
    }
    
    @Test
    public void testFetchModeExact() {
        List<User> list = session.createCriteria(User.class)
                .add(Restrictions.like("firstName", "first_name_page", MatchMode.EXACT)).list();
        assertEquals(3, list.size());
    }
}
