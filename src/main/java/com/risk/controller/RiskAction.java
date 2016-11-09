package com.risk.controller;

import com.risk.Repository.CauseDao;
import com.risk.Repository.RiskDao;
import com.risk.bean.CauseBean;
import com.risk.bean.RiskBean;
import com.risk.util.ArrayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        result.put("causes", ArrayUtil.toList(causeDao.findByriskId(id).iterator()));
        return result;
    }

    @RequestMapping("/getAllCauses")
    @ResponseBody
    public Map getAllCauses() {
        HashMap result = new HashMap();
        result.put("causes", ArrayUtil.toList(causeDao.findAll().iterator()));
        return result;
    }

    @RequestMapping("/modify")
    @ResponseBody
    public void modify(RiskBean riskBean, final List<CauseBean> causeBean){
        riskDao.save(riskBean);
        Iterable<CauseBean> iterable=new Iterable<CauseBean>() {
            @Override
            public Iterator<CauseBean> iterator() {
                return causeBean.iterator();
            }
        };
        causeDao.save(iterable);
    }
}
