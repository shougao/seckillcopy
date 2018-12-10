package com.example.secondkill.miaosha.service;

import com.example.secondkill.miaosha.dao.UserDao;
import com.example.secondkill.miaosha.dao.UserMapper;
import com.example.secondkill.miaosha.domain.MiaoshaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    /**
     * 使用注解的方式，连接mybatis，获取数据
     * @param id
     * @return
     */
    public MiaoshaUser getById(int id){
        return userDao.getById(id);
    }

    /**
     * 使用mapper的方式，使用mybatis连接数据库，获取数据。
     * @return
     */
    public MiaoshaUser getUsers() {
        if (userMapper.getUsers().size() == 0) {
            return null;
        }
        return userMapper.getUsers().get(0);
    }
}
