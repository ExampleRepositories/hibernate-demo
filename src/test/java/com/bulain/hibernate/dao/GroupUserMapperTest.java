package com.bulain.hibernate.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.dataset.SeedDataSet;
import com.bulain.common.test.ServiceTestCase;
import com.bulain.hibernate.entity.GroupUser;

@SeedDataSet(file="test-data/init_seed_dataset.xml")
@DataSet(file = "test-data/init_group_users.xml")
public class GroupUserMapperTest extends ServiceTestCase {
    @Autowired
    private GroupUserMapper groupUserMapper;
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    @Before
    public void setUp() {
        session = sessionFactory.getCurrentSession();
    }

    @After
    public void tearDown() {
        session.flush();
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int deleteByPrimaryKey = groupUserMapper.deleteByPrimaryKey(Integer.valueOf(101));
        assertEquals(1, deleteByPrimaryKey);
    }

    @Test
    public void testInsert() {
        GroupUser record = new GroupUser();
        int insert = groupUserMapper.insert(record);
        assertEquals(1, insert);
    }

    @Test
    public void testSelectByPrimaryKey() {
        GroupUser select = groupUserMapper.selectByPrimaryKey(Integer.valueOf(102));
        assertNotNull(select);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        GroupUser record = new GroupUser();
        record.setId(Integer.valueOf(104));
        int updateByPrimaryKey = groupUserMapper.updateByPrimaryKey(record);
        assertEquals(1, updateByPrimaryKey);
    }

}
