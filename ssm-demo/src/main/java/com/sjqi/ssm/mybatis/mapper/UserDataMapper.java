package com.sjqi.ssm.mybatis.mapper;

import com.sjqi.ssm.mybatis.javabean.UserData;

/**
 * @ClassName UserDataMapper
 * @Description 用户信息mapper接口
 * @Author sjqi
 * @Date 14:30 2019/4/13
 * @Version 1.0
 **/
public interface UserDataMapper {
    UserData selectByPrimaryKey(Integer id);
}
