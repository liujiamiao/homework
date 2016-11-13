package com.risk.Repository;

import com.risk.bean.ControlPointBean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by mcs on 2016/11/9.
 */
public interface ControlPointDao extends CrudRepository<ControlPointBean,Long> {
//    @Query("select distinct c.controlId from com.risk.bean.ControlPointBean c where c.ownerId=:ownerId")
//    Iterable<Long> findIdByOwnerId (@Param(value = "ownerId") long ownerId);
    @Query("select distinct c from com.risk.bean.ControlPointBean c where c.ownerId=:ownerId")
    Iterable<ControlPointBean> findByOwnerId (@Param(value = "ownerId") long ownerId);

    @Query("select distinct c.controlId from com.risk.bean.ControlPointBean c")
    Iterable<Long> findAllControls();
}
