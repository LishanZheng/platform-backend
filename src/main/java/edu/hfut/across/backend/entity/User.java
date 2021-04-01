package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String Id;
    private String nickname;
    private String account;
    private String password;
    private String email;
    private String intro;
    private Integer state;
}
