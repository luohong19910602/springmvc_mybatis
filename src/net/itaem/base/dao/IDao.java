package net.itaem.base.dao;

import java.util.List;
import java.util.Map;

/**
 * 通用dao
 * @author luohong 846705189 2015-07-04
 * */
public interface IDao {
    public <T> void save(T t);
    public <T> void delete(T t);
    public <T> void Update(T t);
    public void delete(String id);
    
    /**
     * select * from xxx
     * where ${whereSql}
     * order by ${orderSql}
     * limit ${limitSql}
     * @param params 里面有三个参数，一个是whereSql，一个是oderSql，另外一个是limitSql参数
     * @return 查询到的对象集合
     * */
    public <T> List<T> list(Map<String, String> params);
}
