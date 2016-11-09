package com.risk.Repository;

import com.risk.bean.CauseBean;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mcs on 2016/11/9.
 */
public interface CauseDao extends CrudRepository<CauseBean,Long> {
    Iterable<CauseBean> findByriskId (Long riskId);
}
