package edu.hfut.across.backend.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String register(String email, String password);
}
