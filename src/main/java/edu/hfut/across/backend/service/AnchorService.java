package edu.hfut.across.backend.service;

import edu.hfut.across.backend.entity.Anchor;
import edu.hfut.across.backend.entity.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnchorService {

    Anchor getAnchor(Integer userId);

    List<UserResponse> getSubscribe(Integer roomId);

    Integer register(Integer userId, String roomNumber);
}
