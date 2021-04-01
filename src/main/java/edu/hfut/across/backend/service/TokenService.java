package edu.hfut.across.backend.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import edu.hfut.across.backend.entity.User;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String getToken(User user) {
        String token = "";
        token = JWT.create().withAudience(user.getAccount())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
