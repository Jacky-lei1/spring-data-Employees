package com.bjsxt.dao;

import com.bjsxt.pojo.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-18 10:57
 */

public interface EmpDao extends JpaRepository<Position,Integer>, JpaSpecificationExecutor<Position> {

    /**
     * 通过JPQL完成的Like查询
     * @param pname
     * @return
     */
    @Query("select p from Position p where p.pname like ?")
    List<Position> selectPositionByname(String pname);

}
