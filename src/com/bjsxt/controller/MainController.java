package com.bjsxt.controller;

import com.bjsxt.pojo.Company;
import com.bjsxt.pojo.Position;
import com.bjsxt.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * @author lvyelanshan
 * @create 2019-11-18 10:59
 */
@Controller
public class MainController {

    @Autowired
    private EmpService empService;

    /**
     * 查询所有岗位信息
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Position> positions = empService.findAll();
        System.out.println("企业岗位信息："+positions);
        model.addAttribute("positions",positions);
        return "main";
    }

    /**
     * 添加岗位信息
     * @param position
     * @param company
     * @return
     */
    @RequestMapping("/addInfo")
    public String addInfo(Position position,Company company){
        position.setReleasedate(new Date());
        position.setCompany(company);
        empService.addInfo(position);
        return "redirect:/findAll";
    }

    /**
     * 删除岗位信息
     * @param pid
     * @return
     */
    @RequestMapping("/delete")
    public String delete(Integer pid){
        empService.deleteInfo(pid);
        return "redirect:/findAll";
    }

    /**
     * 按照岗位名称进行模糊查询
     */
    @RequestMapping("/findByKeyWorlds")
    public String findPname(String keyWorlds,Model model){
        List<Position> list = empService.findByKeyWorld(keyWorlds);
        model.addAttribute("positions",list);
        return "main";
    }

    /**
     * 分页查询+排序
     */
    @RequestMapping("findByPaging")
    public String findByPaging(@RequestParam(defaultValue = "1")String page,@RequestParam(defaultValue = "3")String num,Model model){
        //当前页，hibernate中的分页从第0页开始算第一页
        int p = Integer.parseInt(page);
        p-=1;
        //每页显示第几条
        int n = Integer.parseInt(num);
        List<Position> positions = empService.findByPaging(p,n);
        model.addAttribute("positions",positions);
        model.addAttribute("page",p+1);
        model.addAttribute("num",num);
        return "main";
    }
}
