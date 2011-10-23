package com.bulain.hibernate.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bulain.common.dataset.DataSet;
import com.bulain.common.page.OrderBy;
import com.bulain.hibernate.entity.Group;
import com.bulain.hibernate.pojo.GroupSearch;
import com.bulain.hibernate.test.HibernateTestCase;

@DataSet(file = "test-data/init_groups.xml")
public class FetchModeTest extends HibernateTestCase {
    @Autowired
    private GroupMapper groupMapper;

    @Test
    public void testFetchModeDefault() {
        GroupSearch search = new GroupSearch();
        search.setName("name_page");
        OrderBy orderBy = new OrderBy();
        orderBy.setOrderBy("name");
        orderBy.setSequance("asc");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).setFetchMode("groupUserses", FetchMode.DEFAULT)
                .add(example);

        List<Group> find = groupMapper.find(dc, orderBy);
        for (Group grp : find) {
            Hibernate.initialize(grp.getGroupPermissionses());
            Hibernate.initialize(grp.getGroupUserses());
        }
        assertEquals(3, find.size());
    }

    @Test
    public void testFetchModeJoin() {
        GroupSearch search = new GroupSearch();
        search.setName("name_page");
        OrderBy orderBy = new OrderBy();
        orderBy.setOrderBy("name");
        orderBy.setSequance("asc");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).setFetchMode("groupUserses", FetchMode.JOIN)
                .add(example);

        List<Group> find = groupMapper.find(dc, orderBy);
        for (Group grp : find) {
            Hibernate.initialize(grp.getGroupPermissionses());
            Hibernate.initialize(grp.getGroupUserses());
        }
        assertEquals(3, find.size());
    }

    @Test
    public void testFetchModeSelect() {
        GroupSearch search = new GroupSearch();
        search.setName("name_page");
        OrderBy orderBy = new OrderBy();
        orderBy.setOrderBy("name");
        orderBy.setSequance("asc");

        Example example = Example.create(search);
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).setFetchMode("groupUserses", FetchMode.SELECT)
                .add(example);

        List<Group> find = groupMapper.find(dc, orderBy);
        for (Group grp : find) {
            Hibernate.initialize(grp.getGroupPermissionses());
            Hibernate.initialize(grp.getGroupUserses());
        }
        assertEquals(3, find.size());
    }
}
