package com.solvd.bdd_automation.myBatis.iMappers;


import com.solvd.bdd_automation.myBatis.idao.IDao;

public interface IMapper<T> extends IDao<T> {
    Long insert(T entity);
    Long change(T entity);

}
