package com.risk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mcs on 2016/11/8.
 */
@Controller
public class demoAction {
    @RequestMapping("/")
    private ModelAndView toDemo(ModelAndView mv){
        mv.setViewName("demo");
        mv.addObject("message","嘉奇是撒刁");
        return mv;
    }
}
