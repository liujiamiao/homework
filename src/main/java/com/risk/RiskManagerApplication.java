package com.risk;

import com.risk.Repository.UserDao;
import com.risk.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RiskManagerApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(RiskManagerApplication.class, args);

		UserDao userDao=context.getBean(UserDao.class);
		UserBean user=new UserBean();
		user.setAccount("mcs");
		user.setPassword("123");
		user.setRole(1);
		userDao.save(user);
	}
}
