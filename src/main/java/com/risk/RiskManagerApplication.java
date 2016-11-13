package com.risk;

import com.risk.Repository.CauseDao;
import com.risk.Repository.ControlPointDao;
import com.risk.Repository.RiskDao;
import com.risk.Repository.UserDao;
import com.risk.bean.CauseBean;
import com.risk.bean.ControlPointBean;
import com.risk.bean.RiskBean;
import com.risk.bean.UserBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RiskManagerApplication {
	static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(RiskManagerApplication.class, args);
		SpringApplication.run(RiskManagerApplication.class, args);
		initData();
	}
	private static void initData(){
		UserDao userDao = context.getBean(UserDao.class);
		if (userDao.findOne(1L) == null)
			return;
		initUser();
		initControl();
		initRisk();
		initCause();
	}
	private static void initUser(){
		UserDao userDao=context.getBean(UserDao.class);
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
	private static void initControl(){
		ControlPointDao controlPointDao=context.getBean(ControlPointDao.class);
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
	private static void initRisk(){
		RiskDao riskDao=context.getBean(RiskDao.class);
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
	private static void initCause(){
		CauseDao causeDao=context.getBean(CauseDao.class);
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
