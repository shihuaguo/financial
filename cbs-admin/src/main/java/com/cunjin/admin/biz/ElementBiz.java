package com.cunjin.admin.biz;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cunjin.admin.entity.Element;
import com.cunjin.admin.mapper.ElementMapper;
import com.cunjin.common.biz.BaseBiz;

/**
 * ${DESCRIPTION}
 *
 * @author wanghaobin
 * @create 2017-06-23 20:27
 */
@Service
public class ElementBiz extends BaseBiz<ElementMapper,Element> {
    public List<Element> getAuthorityElementByUserId(String userId){
       return mapper.selectAuthorityElementByUserId(userId);
    }
    public List<Element> getAuthorityElementByUserId(String userId,String menuId){
        return mapper.selectAuthorityMenuElementByUserId(userId,menuId);
    }
}
