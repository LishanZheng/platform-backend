package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.AnchorMapper;
import edu.hfut.across.backend.dao.UserMapper;
import edu.hfut.across.backend.entity.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnchorServiceImp implements AnchorService {

    final
    AnchorMapper anchorMapper;

    final
    UserMapper userMapper;

    @Autowired
    public AnchorServiceImp(AnchorMapper anchorMapper, UserMapper userMapper) {
        this.anchorMapper = anchorMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Anchor getAnchor(Integer userId) {
        User user = userMapper.getUserById(userId);
        if (user.getAnchorId() == null) {
            return null;
        }
        return anchorMapper.getAnchorById(user.getAnchorId());
    }

    @Override
    public List<UserResponse> getSubscribe(Integer roomId) {
        return getUserResponses(userMapper.getSubscribeUser(roomId));
    }

    @Override
    public Integer register(Integer userId, String roomNumber) {
        User user = userMapper.getUserById(userId);
        String name = user.getNickname();
        String avatar = user.getAvatar();
        anchorMapper.register(name, avatar, roomNumber);
        Anchor anchor = anchorMapper.getAnchorByRoomNumber(roomNumber);
        userMapper.editAnchorId(anchor.getId(), userId);
        return anchor.getId();
    }

    public List<UserResponse> getUserResponses(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<UserResponse>();
        for (User user : users) {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(user, userResponse);
            Integer anchorId = user.getAnchorId();
            Anchor anchor = anchorMapper.getAnchorById(anchorId);
            userResponse.setAnchor(anchor);
            userResponses.add(userResponse);
        }
        return userResponses;
    }
}
