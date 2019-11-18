package com.bjsxt.test;

import com.bjsxt.dao.EmpDao;
import com.bjsxt.pojo.Company;
import com.bjsxt.pojo.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-18 11:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-dao.xml")
public class EmpTest {
    @Autowired
    private EmpDao empDao;

    @Test
    public void test1(){
        List<Position> list = empDao.findAll();
        for(Position p:list){
            System.out.println(p);
        }
    }

    @Test
    public void test2(){

        //创建公司
        Company company = new Company();
        company.setCname("阿里巴巴");
        company.setLocation("杭州");

        //创建岗位
        Position position = new Position();
        position.setMaxsal(20000);
        position.setMinsal(10000);
        position.setPname("java开发工程师");
        position.setReleasedate(new Date());

        System.out.println("岗位"+position);
        System.out.println("公司"+company);

        //建立关系
        company.getPositions().add(position);
        position.setCompany(company);

        //保存数据
        this.empDao.save(position);
    }
    @Test
    public void test3(){
        List<Position> list = empDao.selectPositionByname("%开%");
        for (Position p:list){
            System.out.println(p);
        }

    }
}
