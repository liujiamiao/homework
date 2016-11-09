package com.risk.Repository;

import com.risk.bean.ControlPointBean;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mcs on 2016/11/9.
 */
public interface ControlPointDao extends CrudRepository<ControlPointBean,Long> {
}
