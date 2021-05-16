package edu.hfut.across.backend.service;

import edu.hfut.across.backend.entity.User;
import edu.hfut.across.backend.entity.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String register(String email, String password);

    User login(String account, String password);

    UserResponse getUserResponses(User user);
}
