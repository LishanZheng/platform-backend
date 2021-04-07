package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.UserMapper;
import edu.hfut.across.backend.entity.User;
import edu.hfut.across.backend.util.PasswordUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public String register(String email, String password) {
        String account = RandomStringUtils.randomNumeric(6);
        String nickname = "用户" + account;
        String introduction = "这个人什么介绍也没留下";
        Timestamp creationTime =  new Timestamp(System.currentTimeMillis());
        Integer gender = 0;
        try {
            userMapper.register(nickname, account, password, email, introduction, creationTime, gender);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
        return account;
    }

    @Override
    public User login(String account, String password) {
        User user = userMapper.getUserByAccount(account);
        if (user == null) {
            return null;
        }
        if (PasswordUtil.checkPassword(password, user.getPassword())) {
           return user;
        }
        return null;
    }
}
