package com.bjsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lvyelanshan
 * @create 2019-11-18 9:21
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String loadIndex(){
        return "forward:/findAll";
    }


    @RequestMapping("/{page}")
    public String showPage(String page){
        return page;
    }


}
