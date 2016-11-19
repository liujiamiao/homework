package com.risk.controller;
import com.risk.Repository.CauseDao;
import com.risk.Repository.ControlPointDao;
import com.risk.Repository.RiskDao;
import com.risk.bean.CauseBean;
import com.risk.bean.ControlPointBean;
import com.risk.bean.RiskBean;
import com.risk.util.ArrayUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
/**
 * Created by Administrator on 2016/11/13.
 */

@Controller
@RequestMapping("riskmanager/control")
public class ControlAction {
    @Autowired
    CauseDao causeDao;

    @Autowired
    RiskDao riskDao;

    @Autowired
    ControlPointDao controlPointDao;

    @RequestMapping("/getControls")
    @ResponseBody
    public Map getControls(Long id) {
        HashMap result = new HashMap();
        result.put("controls", ArrayUtil.toList(controlPointDao.findByOwnerId(id).iterator()));
        return result;
    }

    @RequestMapping("/check")
    @ResponseBody
    public void check(Long id){
        RiskBean riskBean=riskDao.findOne(id);
        riskBean.setState(1);
        riskDao.save(riskBean);
    }
}
