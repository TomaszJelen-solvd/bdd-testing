package com.solvd.bdd_automation.myBatis.dao;

import com.solvd.bdd_automation.myBatis.iMappers.IMapperUser;
import com.solvd.bdd_automation.myBatis.idao.IDaoUser;
import com.solvd.bdd_automation.myBatis.model.User;

public class MyBatisDaoUser extends MyBatisDao<User, IMapperUser> implements IDaoUser {
    public MyBatisDaoUser() {
        this.clazz = IMapperUser.class;
    }
}
