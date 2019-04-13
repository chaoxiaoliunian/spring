package com.sjqi.ssm.service;

import com.sjqi.ssm.mybatis.javabean.UserData;

/**
 * @ClassName IUserDataDao
 * @Description 完成一个用户的增删改查功能
 * @Author sjqi
 * @Date 19:58 2019/3/21
 * @Version 1.0
 **/
public interface IUserDataDao {

    /**
     * 查询一个用户
     *
     * @param id
     * @return
     */
    UserData selectByPrimaryKey(Integer id);

}
