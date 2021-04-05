package edu.hfut.across.backend.dao;

import org.apache.ibatis.annotations.Mapper;

import java.sql.Timestamp;

@Mapper
public interface UserMapper {

    void register(String nickname, String account, String password, String email,
                  String introduction, Timestamp creationTime, Integer gender);
}
