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
 * Created by mcs on 2016/11/9.
 */
@Controller
@RequestMapping("riskmanager/risk")
public class RiskAction {
    @Autowired
    CauseDao causeDao;

    @Autowired
    RiskDao riskDao;

    @Autowired
    ControlPointDao controlPointDao;

    @RequestMapping("/getCauses")
    @ResponseBody
    public Map getCauses(Long id) {
        HashMap result = new HashMap();
        result.put("causes", ArrayUtil.toList(causeDao.findByRiskId(id).iterator()));
        return result;
    }

    @RequestMapping("/getAllControls")
    @ResponseBody
    public Map getAllControls() {
        HashMap result = new HashMap();
        result.put("controls", ArrayUtil.toList(controlPointDao.findAll().iterator()));
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
    public Map modify(RiskBean risk){
        HashMap result = new HashMap();
        risk.setTimestamp(System.currentTimeMillis());
        riskDao.save(risk);
        result.put("riskId",risk.getId());
        return result;
    }

    @RequestMapping("/addCause")
    @ResponseBody
    public void addCause(@RequestParam(value = "riskId") Integer riskId,String cause){
            CauseBean causeBean=new CauseBean();
            System.out.println(cause);
            causeBean.setName(cause);
            causeBean.setRisk_id(riskId);
            causeBean.setDescription(null);
            causeDao.save(causeBean);
    }
    @RequestMapping("/check")
    @ResponseBody
    public void check(Long id){
        RiskBean riskBean=riskDao.findOne(id);
        riskBean.setState(1);
        riskDao.save(riskBean);
    }
}
