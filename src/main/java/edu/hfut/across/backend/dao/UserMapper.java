package edu.hfut.across.backend.dao;

import edu.hfut.across.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface UserMapper {

    void register(String nickname, String account, String password, String email,
                  String avatar, String introduction, Timestamp creationTime, Integer gender);

    User getUserByAccount(String account);
    User getUserByEmail(String email);
}
