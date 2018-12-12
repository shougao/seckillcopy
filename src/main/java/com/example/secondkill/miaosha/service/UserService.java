package com.example.secondkill.miaosha.service;

import com.example.secondkill.miaosha.dao.UserDao;
import com.example.secondkill.miaosha.dao.UserMapper;
import com.example.secondkill.miaosha.domain.MiaoshaUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

    /**
     * 验证Mybatis的事物功能支持
     * dao中的mybatis 对应的sql 要么全做、要么不做
     *
     * id为1或者2的user，在插入时，会因为冲突，导致事务失败。回滚。
     */
    @Transactional
    public boolean  tx() {
        MiaoshaUser user1 = new MiaoshaUser();
        user1.setId(1);
        user1.setName("first people");
        userDao.insert(user1);

        MiaoshaUser user2 = new MiaoshaUser();
        user1.setId(1);
        user1.setName("second people");
        userDao.insert(user2);
        return true;
    }
}
