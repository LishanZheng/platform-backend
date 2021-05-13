package edu.hfut.across.backend.service;

import edu.hfut.across.backend.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PageService {

    List<Type> getSortPage();
}
