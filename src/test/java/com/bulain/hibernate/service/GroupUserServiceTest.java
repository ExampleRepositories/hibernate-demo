package com.bulain.hibernate.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.dataset.SeedDataSet;
import com.bulain.common.test.ServiceTestCase;
import com.bulain.hibernate.entity.Group;
import com.bulain.hibernate.entity.GroupUser;
import com.bulain.hibernate.entity.User;

@SeedDataSet(file = "test-data/init_seed_dataset.xml")
@DataSet(file = "test-data/init_group_users.xml")
public class GroupUserServiceTest extends ServiceTestCase {
    @Autowired
    private GroupUserService groupUserService;
    
    @Test
    public void testDelete() {
        groupUserService.delete(Integer.valueOf(101));
    }
    
    @Test
    public void testInsert() {
        GroupUser record = new GroupUser();
        User user = new User();
        user.setId(105);
        record.setUser(user);
        Group group = new Group();
        group.setId(105);
        record.setGroup(group);
        groupUserService.insert(record);
        assertNotNull(record.getId());
    }
    
    @Test
    public void testGet() {
        GroupUser select = groupUserService.get(Integer.valueOf(102), Arrays.asList(new String[] { "group", "user" }));
        assertNotNull(select);
        assertEquals("first_name_102", select.getUser().getFirstName());
        assertEquals("last_name_102", select.getUser().getLastName());
        assertEquals("name_102", select.getGroup().getName());
    }
    
    @Test
    public void testUpdate() {
        GroupUser record = groupUserService.get(103, null);
        Group group = new Group();
        group.setId(105);
        record.setGroup(group);
        groupUserService.update(record);
    }
}
