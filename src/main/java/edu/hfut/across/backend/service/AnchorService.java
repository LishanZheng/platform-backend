package edu.hfut.across.backend.service;

import edu.hfut.across.backend.entity.Anchor;
import org.springframework.stereotype.Service;

@Service
public interface AnchorService {

    Anchor getAnchor(Integer userId);
}
