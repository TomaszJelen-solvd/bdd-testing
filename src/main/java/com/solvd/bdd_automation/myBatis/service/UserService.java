package com.solvd.bdd_automation.myBatis.service;

import com.solvd.bdd_automation.myBatis.idao.IDaoUser;
import com.solvd.bdd_automation.myBatis.idao.IDaoUserOrderItem;
import com.solvd.bdd_automation.myBatis.model.User;
import com.solvd.bdd_automation.myBatis.model.UserOrderItem;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {

    IDaoUser daoUser;

    IDaoUserOrderItem daoUserOrderItem;

    public UserService(IDaoUser daoUser, IDaoUserOrderItem daoUserOrderItem) {
        this.daoUser = daoUser;
        this.daoUserOrderItem = daoUserOrderItem;
    }

    public Long createUser(User entity) throws SQLException, InterruptedException {
        return daoUser.create(entity).getId();
    }

    public User readUser(Long id) throws SQLException, InterruptedException {
        User user = daoUser.read(id);
        user.setUserOrder(new ArrayList<UserOrderItem>());
        for (UserOrderItem orderItem : daoUserOrderItem.readByUser(user.getId())) {
            user.getUserOrder().add(orderItem);
        }
        return user;
    }
}
