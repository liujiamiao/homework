package com.risk.controller;

import com.risk.Repository.CauseDao;
import com.risk.Repository.RiskDao;
import com.risk.bean.CauseBean;
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
 * Created by mcs on 2016/11/9.
 */
@Controller
@RequestMapping("risk")
public class RiskAction {
    @Autowired
    CauseDao causeDao;

    @Autowired
    RiskDao riskDao;

    @RequestMapping("/getCauses")
    @ResponseBody
    public Map getCauses(Long id) {
        HashMap result = new HashMap();
        result.put("causes", ArrayUtil.toList(causeDao.findByRiskId(id).iterator()));
        return result;
    }

    @RequestMapping("/getAllCauses")
    @ResponseBody
    public Map getAllCauses() {
        HashMap result = new HashMap();
        result.put("causes", ArrayUtil.toList(causeDao.findAllCauses().iterator()));
        return result;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public void modify(RiskBean risk){
        risk.setTimestamp(System.currentTimeMillis());
        riskDao.save(risk);
    }

    @RequestMapping("/addCauses")
    @ResponseBody
    public void addCauses(@RequestParam(value = "riskId") Integer riskId,@RequestParam(value = "causes[]") ArrayList<String> causes){
        for(String name:causes){
            CauseBean causeBean=new CauseBean();
            System.out.println(name);
            causeBean.setName(name);
            causeBean.setRisk_id(riskId);
            causeBean.setDescription(null);
            causeDao.save(causeBean);
        }
    }
}
