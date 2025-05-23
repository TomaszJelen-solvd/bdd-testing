package com.solvd.bdd_automation.myBatis.idao;

import com.solvd.bdd_automation.myBatis.model.UserOrderItem;

import java.util.List;

public interface IDaoUserOrderItem extends IDao<UserOrderItem>{
    List<UserOrderItem> readByUser(Long userId);
}
