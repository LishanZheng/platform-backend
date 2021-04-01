package edu.hfut.across.backend.bean;

import edu.hfut.across.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestBean {

    public String account;
    public String password;
}
