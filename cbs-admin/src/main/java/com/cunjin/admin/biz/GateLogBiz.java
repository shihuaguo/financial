package com.cunjin.admin.biz;

import org.springframework.stereotype.Service;

import com.cunjin.admin.entity.GateLog;
import com.cunjin.admin.mapper.GateLogMapper;
import com.cunjin.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-07-01 14:36
 */
@Service
public class GateLogBiz extends BaseBiz<GateLogMapper,GateLog> {

    @Override
    public void insert(GateLog entity) {
        mapper.insert(entity);
    }

    @Override
    public void insertSelective(GateLog entity) {
        mapper.insertSelective(entity);
    }
}
