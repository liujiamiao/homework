package com.risk.controller;

import com.risk.Repository.RiskDao;
import com.risk.Repository.UserDao;
import com.risk.bean.UserBean;
import com.risk.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;
import org.thymeleaf.util.ArrayUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mcs on 2016/11/8.
 */
@Controller
public class LoginAction {

    @Autowired
    UserDao userDao;

    @Autowired
    RiskDao riskDao;

    @RequestMapping("/")
    private ModelAndView toLogin(ModelAndView mv){
        mv.setViewName("login");
        mv.addObject("message","嘉奇是撒刁");
        return mv;
    }

    @RequestMapping("loginCheck")
    @ResponseBody
    public Map loginCheck(ModelAndView mv, String account, String password){
        HashMap<String,String> result=new HashMap<>();
        UserBean userBean=userDao.findByAccount(account);
        if(userBean!=null){
            result.put("result","success");
        }else {
            result.put("result","fail");
        }
        return result;
    }

    @RequestMapping("toMain")
    private ModelAndView toMain(ModelAndView mv,String account,String password){
        UserBean userBean=userDao.findByAccount(account);
        switch (userBean.getRole()){
            case 0:
                //admin
                break;
            case 1:
                //risk manager
                mv.setViewName("risk_manager");
                mv.addObject("riskList", ArrayUtil.toList(riskDao.findAll().iterator()));
                break;
            case 2:
                //control manager
                mv.setViewName("control_manager");
                break;
        }
        mv.addObject("user",userBean);
        return mv;
    }
}
