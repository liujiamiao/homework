package com.risk.Repository;

import com.risk.bean.RiskBean;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mcs on 2016/11/9.
 */
public interface RiskDao extends CrudRepository<RiskBean,Long> {
}
