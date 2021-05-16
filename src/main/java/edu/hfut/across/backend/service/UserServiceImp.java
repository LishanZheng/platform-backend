package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.AnchorMapper;
import edu.hfut.across.backend.dao.UserMapper;
import edu.hfut.across.backend.entity.*;
import edu.hfut.across.backend.util.PasswordUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImp implements UserService {

    final
    UserMapper userMapper;

    final
    AnchorMapper anchorMapper;

    @Autowired
    public UserServiceImp(UserMapper userMapper, AnchorMapper anchorMapper) {
        this.userMapper = userMapper;
        this.anchorMapper = anchorMapper;
    }

    @Override
    public String register(String email, String password) {
        User user = userMapper.getUserByEmail(email);
        if(user != null) {
            return null;
        }
        String account = RandomStringUtils.randomNumeric(6);
        String nickname = "用户" + account;
        String introduction = "这个人什么介绍也没留下";
        String avatar = "http://121.196.174.189:8080/static/resources/1.png";
        Timestamp creationTime =  new Timestamp(System.currentTimeMillis());
        Integer gender = 0;
        try {
            userMapper.register(nickname, account, password, email, avatar, introduction, creationTime, gender);
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
            User userByEmail = userMapper.getUserByEmail(account);
            if (userByEmail == null)
                return null;
            else
                user = userByEmail;
        }
        if (PasswordUtil.checkPassword(password, user.getPassword())) {
           return user;
        }
        return null;
    }

    public UserResponse getUserResponses(User user) {
        UserResponse userResponse = new UserResponse();
        // 复制 User 和 UserResponse 重复的部分
        BeanUtils.copyProperties(user, userResponse);
        Integer anchorId = user.getAnchorId();
        Anchor anchor = anchorMapper.getAnchorById(anchorId);
        userResponse.setAnchor(anchor);
        return userResponse;
    }
}
