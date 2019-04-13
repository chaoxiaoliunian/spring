package com.sjqi.ssm.service;

import com.sjqi.ssm.mybatis.javabean.UserData;
import com.sjqi.ssm.mybatis.mapper.UserDataMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserDaoImpl
 * @Description 单个用户dao接口操作的实现类
 * @Author sjqi
 * @Date 11:24 2019/3/22
 * @Version 1.0
 **/
@Service("userDataDao")
public class UserDaoImpl implements IUserDataDao {
    @Autowired
    private UserDataMapper userDataMapper;

    @Override
    public UserData selectByPrimaryKey(Integer id) {
        return userDataMapper.selectByPrimaryKey(id);
    }
}
