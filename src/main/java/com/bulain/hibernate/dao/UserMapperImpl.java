package com.bulain.hibernate.dao;

import com.bulain.hibernate.core.PagedMapperImpl;
import com.bulain.hibernate.entity.Users;

public class UserMapperImpl extends PagedMapperImpl<Users, Users> implements UserMapper {
    protected Class<Users> getEntityClass() {
        return Users.class;
    }
}
