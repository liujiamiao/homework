package com.risk;

import com.risk.Repository.CauseDao;
import com.risk.Repository.ControlPointDao;
import com.risk.Repository.RiskDao;
import com.risk.Repository.UserDao;
import com.risk.bean.CauseBean;
import com.risk.bean.ControlPointBean;
import com.risk.bean.RiskBean;
import com.risk.bean.UserBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mcs on 2016/11/14.
 */
@Service
public class Init implements InitializingBean{
    @Autowired
    UserDao userDao;

    @Autowired
    RiskDao riskDao;

    @Autowired
    ControlPointDao controlPointDao;

    @Autowired
    CauseDao causeDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        initData();
    }
    private void initData(){
        if (userDao.findOne(1L) == null)
            return;
        initUser();
        initControl();
        initRisk();
        initCause();
    }
    private void initUser(){
        UserBean user=new UserBean();
        user.setAccount("control");
        user.setPassword("control");
        user.setRole(2);
        userDao.save(user);

        user=new UserBean();
        user.setAccount("control1");
        user.setPassword("control1");
        user.setRole(2);
        userDao.save(user);

        user=new UserBean();
        user.setAccount("control2");
        user.setPassword("control2");
        user.setRole(2);
        userDao.save(user);

        user=new UserBean();
        user.setAccount("risk");
        user.setPassword("risk");
        user.setRole(1);
        userDao.save(user);

        user=new UserBean();
        user.setAccount("risk1");
        user.setPassword("risk1");
        user.setRole(1);
        userDao.save(user);

        user=new UserBean();
        user.setAccount("risk2");
        user.setPassword("risk2");
        user.setRole(1);
        userDao.save(user);

    }
    private void initControl(){
        ControlPointBean control = new ControlPointBean();
        control.setControl_point("control point");
        control.setOwnerId(1);
        controlPointDao.save(control);

        control = new ControlPointBean();
        control.setControl_point("control point1");
        control.setOwnerId(1);
        controlPointDao.save(control);

        control = new ControlPointBean();
        control.setControl_point("control point2");
        control.setOwnerId(1);
        controlPointDao.save(control);
    }
    private void initRisk(){
        RiskBean riskBean = new RiskBean();
        riskBean.setTitle("risk");
        riskBean.setControlId(1);
        riskBean.setDescription("risk");
        riskBean.setLevel(1);
        riskBean.setPossibility(1);
        riskBean.setState(0);
        riskBean.setSubmitter_id(4);
        riskBean.setThreshold(1);
        riskBean.setTimestamp(1479028464447L);
        riskDao.save(riskBean);

        riskBean = new RiskBean();
        riskBean.setTitle("risk1");
        riskBean.setControlId(1);
        riskBean.setDescription("risk1");
        riskBean.setLevel(2);
        riskBean.setPossibility(2);
        riskBean.setState(0);
        riskBean.setSubmitter_id(4);
        riskBean.setThreshold(2);
        riskBean.setTimestamp(1479028464447L);
        riskDao.save(riskBean);

        riskBean = new RiskBean();
        riskBean.setTitle("risk2");
        riskBean.setControlId(1);
        riskBean.setDescription("risk2");
        riskBean.setLevel(1);
        riskBean.setPossibility(4);
        riskBean.setState(0);
        riskBean.setSubmitter_id(4);
        riskBean.setThreshold(4);
        riskBean.setTimestamp(1479028464447L);
        riskDao.save(riskBean);

    }
    private void initCause(){
        CauseBean causeBean = new CauseBean();
        causeBean.setDescription("cause");
        causeBean.setName("cause");
        causeBean.setRisk_id(1);
        causeDao.save(causeBean);

        causeBean = new CauseBean();
        causeBean.setDescription("cause1");
        causeBean.setName("cause1");
        causeBean.setRisk_id(1);
        causeDao.save(causeBean);

        causeBean = new CauseBean();
        causeBean.setDescription("cause2");
        causeBean.setName("cause2");
        causeBean.setRisk_id(1);
        causeDao.save(causeBean);
    }
}
