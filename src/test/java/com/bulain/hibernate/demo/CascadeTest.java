package com.bulain.hibernate.demo;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;

import com.bulain.hibernate.entity.Group;
import com.bulain.hibernate.entity.GroupUser;
import com.bulain.hibernate.entity.User;
import com.bulain.hibernate.test.HibernateTestCase;

@SuppressWarnings("unchecked")
public class CascadeTest extends HibernateTestCase{
    @Test
    public void testCascade(){
        User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        
        Group group = new Group();
        group.setName("name");
        
        GroupUser gu = new GroupUser();
        gu.setUser(user);
        gu.setGroup(group);
        group.getGroupUserses().add(gu);
        session.save(gu);
        
        List<GroupUser> list = session.createCriteria(GroupUser.class).list();
        assertEquals(1, list.size());
        
        session.delete(group);
        
        list = session.createCriteria(GroupUser.class).list();
        assertEquals(0, list.size());

        
    }
}
