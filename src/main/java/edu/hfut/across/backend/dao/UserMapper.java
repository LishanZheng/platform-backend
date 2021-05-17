package edu.hfut.across.backend.dao;

import edu.hfut.across.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Mapper
@Component
public interface UserMapper {

    void register(String nickname, String account, String password, String email,
                  String avatar, String introduction, Timestamp creationTime, Integer gender);

    User getUserByAccount(String account);

    User getUserByEmail(String email);

    User getUserById(Integer id);

    List<User> getSubscribeUser(Integer roomId);

    void editAnchorId(Integer anchorId, Integer id);
}
