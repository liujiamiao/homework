package com.risk;

import com.risk.Repository.UserDao;
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

    @Override
    public void afterPropertiesSet() throws Exception {
        UserBean user=userDao.findOne(new Long(1));
        user.setRole(2);
        userDao.save(user);
    }
}
