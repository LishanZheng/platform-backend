package edu.hfut.across.backend.dto.user;

import edu.hfut.across.backend.entity.User;
import edu.hfut.across.backend.entity.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseBean {

    public String token;
    public UserResponse user;
}
