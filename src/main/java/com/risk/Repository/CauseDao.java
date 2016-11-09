package com.risk.Repository;

import com.risk.bean.CauseBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Iterator;

/**
 * Created by mcs on 2016/11/9.
 */
public interface CauseDao extends CrudRepository<CauseBean,Long> {
    @Query("select distinct c.name from com.risk.bean.CauseBean c where c.risk_id=:risk_id")
    Iterable<String> findByRiskId (@Param(value = "risk_id") Long risk_id);

    @Query("select distinct c.name from com.risk.bean.CauseBean c")
    Iterable<String> findAllCauses();
}
