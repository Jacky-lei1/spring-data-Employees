package com.bjsxt.service;

import com.bjsxt.pojo.Position;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-18 10:59
 */
public interface EmpService {
    /**
     * 查询所有
     */
    List<Position> findAll();

    /**
     * 添加岗位信息
     */
    void addInfo(Position position);

    /**
     * 删除岗位信息
     */
    void deleteInfo(Integer pid);

    /**
     * 进行模糊查询
     */
    List<Position> findByKeyWorld(String keyWorlds);

    /**
     * 进行分页查询
     */
    List<Position> findByPaging(int p,int n);

}
