package com.bulain.hibernate.dao;

import com.bulain.hibernate.common.PagedMapperImpl;
import com.bulain.hibernate.pojo.Users;

public class UserMapperImpl extends PagedMapperImpl<Users, Users> implements UserMapper {
    protected Class<Users> getEntityClass() {
        return Users.class;
    }
}
