package com.bulain.hibernate.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.page.OrderBy;
import com.bulain.common.page.Page;
import com.bulain.hibernate.entity.Group;
import com.bulain.hibernate.pojo.GroupSearch;
import com.bulain.hibernate.test.HibernateTestCase;

@DataSet(file = "test-data/init_groups.xml")
public class GroupServiceTest extends HibernateTestCase {
    @Autowired
    private GroupService groupService;
    
    @Test
    public void testDelete() {
        groupService.delete(Integer.valueOf(101));
    }

    @Test
    public void testInsert() {
        Group record = new Group();
        record.setName("name");
        record.setNote("note");
        groupService.insert(record);
        assertNotNull(record.getId());
    }

    @Test
    public void testSelectByPrimaryKey() {
        Group select = groupService.get(Integer.valueOf(102));
        assertEquals("name_102", select.getName());
        assertEquals("note_102", select.getNote());
    }

    @Test
    public void testUpdateByPrimaryKey() {
        Group record = groupService.get(103);
        record.setName("name");
        record.setNote("note");
        groupService.update(record);
    }

    @Test
    public void testFind() {
        GroupSearch search = new GroupSearch();
        search.setName("name_page");
        OrderBy orderBy = new OrderBy();
        orderBy.setOrderBy("name");
        orderBy.setSequance("asc");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).add(example);

        List<Group> find = groupService.find(dc, orderBy);
        assertEquals(3, find.size());
    }

    @Test
    public void testCount() {
        GroupSearch search = new GroupSearch();
        search.setName("name_page");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).add(example);

        Long count = groupService.count(dc);
        assertEquals(Long.valueOf(3), count);
    }

    @Test
    public void testPage() {
        GroupSearch search = new GroupSearch();
        search.setName("name_page");
        Page page = new Page();
        page.setCount(10);
        OrderBy orderBy = new OrderBy();
        orderBy.setOrderBy("name");
        orderBy.setSequance("asc");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).add(example);

        List<Group> page2 = groupService.page(dc, page, orderBy);
        assertEquals(3, page2.size());
    }
}
