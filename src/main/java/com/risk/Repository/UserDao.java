package com.risk.Repository;

import com.risk.bean.UserBean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mcs on 2016/11/9.
 */
@Transactional
public interface UserDao extends CrudRepository<UserBean,Long> {
    UserBean findByAccount(String account);
}
