package com.solvd.bdd_automation.myBatis.service;

import com.solvd.bdd_automation.myBatis.idao.IDaoUserOrderItem;
import com.solvd.bdd_automation.myBatis.model.UserOrderItem;

import java.sql.SQLException;

public class UserOrderItemService {

    IDaoUserOrderItem daoUserOrderItem;

    public UserOrderItemService(IDaoUserOrderItem daoUserOrderItem) {
        this.daoUserOrderItem = daoUserOrderItem;
    }

    public UserOrderItem readUserOrderItem(Long id) throws SQLException, InterruptedException {
        return daoUserOrderItem.read(id);
    }
}
