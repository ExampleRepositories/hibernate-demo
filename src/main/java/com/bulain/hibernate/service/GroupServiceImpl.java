package com.bulain.hibernate.service;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;

import com.bulain.hibernate.core.PagedMapper;
import com.bulain.hibernate.core.PagedServiceImpl;
import com.bulain.hibernate.dao.GroupMapper;
import com.bulain.hibernate.entity.Group;

public class GroupServiceImpl extends PagedServiceImpl<Group> implements GroupService {
    private GroupMapper groupMapper;

    @Override
    protected PagedMapper<Group> getPagedMapper() {
        return groupMapper;
    }

    public long countByDuplicate(Group record) {
        Group grp = new Group();
        grp.setId(record.getId());
        grp.setName(record.getName());
        DetachedCriteria dc = DetachedCriteria.forClass(Group.class).add(Example.create(grp));
        return groupMapper.count(dc);
    }

    public void setGroupMapper(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }
}
