package com.risk.Repository;

import com.risk.bean.RiskBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by mcs on 2016/11/9.
 */
public interface RiskDao extends CrudRepository<RiskBean,Long> {
    @Query("select distinct c from com.risk.bean.RiskBean c , com.risk.bean.ControlPointBean control where c.controlId = control.controlId and c.controlId=:ownerId")
    Iterable<RiskBean> findByOwnerId (@Param(value = "ownerId") Long ownerId);

    @Query("select distinct c.id from com.risk.bean.RiskBean c where c.controlId=:controlId")
    Iterable<Long> findByControlId (@Param(value = "controlId") Long controlId);

    @Query("select distinct c,id from com.risk.bean.RiskBean c")
    Iterable<Long> findAllrisks();
}
