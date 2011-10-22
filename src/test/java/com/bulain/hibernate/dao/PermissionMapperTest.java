package com.bulain.hibernate.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.dataset.SeedDataSet;
import com.bulain.common.page.OrderBy;
import com.bulain.common.page.Page;
import com.bulain.common.test.ServiceTestCase;
import com.bulain.hibernate.entity.Permission;
import com.bulain.hibernate.pojo.PermissionSearch;

@SeedDataSet(file="test-data/init_seed_dataset.xml")
@DataSet(file = "test-data/init_permissions.xml")
public class PermissionMapperTest extends ServiceTestCase {
    @Autowired
    private PermissionMapper permissionMapper;

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
        int deleteByPrimaryKey = permissionMapper.deleteByPrimaryKey(Integer.valueOf(101));
        assertEquals(1, deleteByPrimaryKey);
    }

    @Test
    public void testInsert() {
        Permission record = new Permission();
        record.setPermission("permission");
        int insert = permissionMapper.insert(record);
        assertEquals(1, insert);
    }

    @Test
    public void testSelectByPrimaryKey() {
        Permission selectByPrimaryKey = permissionMapper.selectByPrimaryKey(Integer.valueOf(102));
        assertNotNull(selectByPrimaryKey);

        assertEquals("permission_102", selectByPrimaryKey.getPermission());
    }

    @Test
    public void testUpdateByPrimaryKey() {
        Permission record = new Permission();
        record.setId(Integer.valueOf(104));
        record.setPermission("permission-updated");
        int updateByPrimaryKey = permissionMapper.updateByPrimaryKey(record);
        assertEquals(1, updateByPrimaryKey);
    }

    @Test
    public void testFind() {
        PermissionSearch search = new PermissionSearch();
        search.setPermission("permission_page");
        OrderBy orderBy = new OrderBy();
        orderBy.setOrderBy("permission");
        orderBy.setSequance("asc");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Permission.class).add(example);

        List<Permission> find = permissionMapper.find(dc, orderBy);
        assertEquals(3, find.size());
    }

    @Test
    public void testCount() {
        PermissionSearch search = new PermissionSearch();
        search.setPermission("permission_page");
        
        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Permission.class).add(example);
        
        Long count = permissionMapper.count(dc);
        assertEquals(Long.valueOf(3), count);
    }

    @Test
    public void testPage() {
        PermissionSearch search = new PermissionSearch();
        search.setPermission("permission_page");
        Page page = new Page();
        page.setCount(10);
        OrderBy orderBy = new OrderBy();
        orderBy.setOrderBy("permission");
        orderBy.setSequance("asc");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Permission.class).add(example);
        
        List<Permission> listPermission = permissionMapper.page(dc, page, orderBy);
        assertEquals(3, listPermission.size());
    }
}
