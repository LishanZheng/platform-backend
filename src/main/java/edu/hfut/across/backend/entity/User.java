package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String Id;
    private String nickname;
    private String account;
    private String password;
    private String email;
    private String introduction;
    private Timestamp time;
    private Integer gender;
    private Integer state;
}
