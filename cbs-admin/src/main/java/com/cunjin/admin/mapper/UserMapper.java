package com.cunjin.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cunjin.admin.entity.User;

import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
    public List<User> selectMemberByGroupId(@Param("groupId") int groupId);
    public List<User> selectLeaderByGroupId(@Param("groupId") int groupId);
}