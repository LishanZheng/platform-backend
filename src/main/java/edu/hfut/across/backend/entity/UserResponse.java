package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Integer id;
    private Anchor Anchor;
    private String nickname;
    private String account;
    private String email;
    private String avatar;
    private String introduction;
    private Timestamp creationTime;
    private Integer gender;
    private Integer state;
}
