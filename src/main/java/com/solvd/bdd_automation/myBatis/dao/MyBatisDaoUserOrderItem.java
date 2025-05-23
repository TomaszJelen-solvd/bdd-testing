package com.solvd.bdd_automation.myBatis.dao;

import com.solvd.bdd_automation.myBatis.iMappers.IMapperUserOrderItem;
import com.solvd.bdd_automation.myBatis.idao.IDaoUserOrderItem;
import com.solvd.bdd_automation.myBatis.model.UserOrderItem;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDaoUserOrderItem extends MyBatisDao<UserOrderItem, IMapperUserOrderItem> implements IDaoUserOrderItem {

    public MyBatisDaoUserOrderItem() {
        this.clazz = IMapperUserOrderItem.class;
    }

    @Override
    public List<UserOrderItem> readByUser(Long userId) {
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")){
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
            try (SqlSession session = build.openSession()) {
                IMapperUserOrderItem iDaoUserOrderItem = session.getMapper(IMapperUserOrderItem.class);
                return iDaoUserOrderItem.readByUser(userId);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
