package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer Id;
    private Integer anchorId;
    private String nickname;
    private String account;
    private String password;
    private String email;
    private String avatar;
    private String introduction;
    private Timestamp creationTime;
    private Integer gender;
    private Integer state;
}
