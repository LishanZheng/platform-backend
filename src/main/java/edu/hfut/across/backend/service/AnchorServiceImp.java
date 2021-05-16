package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.AnchorMapper;
import edu.hfut.across.backend.dao.UserMapper;
import edu.hfut.across.backend.entity.Anchor;
import edu.hfut.across.backend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
