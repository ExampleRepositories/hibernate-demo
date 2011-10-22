package com.bulain.hibernate.dao;

import static org.junit.Assert.assertEquals;

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
public class GroupMapperTest extends HibernateTestCase {
    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void testDeleteByPrimaryKey() {
        int deleteByPrimaryKey = groupMapper.deleteByPrimaryKey(Integer.valueOf(101));
        assertEquals(1, deleteByPrimaryKey);
    }

    @Test
    public void testInsert() {
        Group record = new Group();
        record.setName("name");
        record.setNote("note");
        int insert = groupMapper.insert(record);
        assertEquals(1, insert);
    }

    @Test
    public void testSelectByPrimaryKey() {
        Group select = groupMapper.selectByPrimaryKey(Integer.valueOf(102));
        assertEquals("name_102", select.getName());
        assertEquals("note_102", select.getNote());
    }

    @Test
    public void testUpdateByPrimaryKey() {
        Group record = groupMapper.selectByPrimaryKey(103);
        record.setName("name");
        record.setNote("note");
        int updateByPrimaryKey = groupMapper.updateByPrimaryKey(record);
        assertEquals(1, updateByPrimaryKey);
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

        List<Group> find = groupMapper.find(dc, orderBy);
        assertEquals(3, find.size());
    }

    @Test
    public void testCount() {
        GroupSearch search = new GroupSearch();
        search.setName("name_page");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).add(example);

        Long count = groupMapper.count(dc);
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

        List<Group> page2 = groupMapper.page(dc, page, orderBy);
        assertEquals(3, page2.size());
    }

}