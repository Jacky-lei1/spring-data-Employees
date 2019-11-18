package com.bjsxt.service.impl;

import com.bjsxt.dao.EmpDao;
import com.bjsxt.pojo.Position;
import com.bjsxt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-18 11:00
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Position> findAll() {
        List<Position> list = empDao.findAll();
        System.out.println("hibernate底层实现类查到的数据：");
        for(Position p:list){
            System.out.println(p);
        }
        return list;
    }

    @Override
    public void addInfo(Position position) {
        empDao.save(position);
    }

    @Override
    public void deleteInfo(Integer pid) {
        empDao.delete(pid);
    }

    @Override
    public List<Position> findByKeyWorld(String keyWorlds) {
        String str = "%"+keyWorlds+"%";
        List<Position> list = empDao.selectPositionByname(str);
        for(Position position:list){
            System.out.println("模糊查询结果："+position);
        }
        return list;
    }

    @Override
    public List<Position> findByPaging(int p, int n) {
        Sort sort = new Sort(Sort.Direction.DESC,"maxsal");
        Pageable pageable = new PageRequest(p,n,sort);
        Page<Position> all = empDao.findAll(pageable);
        List<Position> content = all.getContent();
        return content;
    }
}
