package edu.hfut.across.backend.to;

import edu.hfut.across.backend.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseBean {

    public String token;
    public User user;
}
