package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.PageMapper;
import edu.hfut.across.backend.entity.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImp implements PageService {

    final
    PageMapper pageMapper;

    @Autowired
    public PageServiceImp(PageMapper pageMapper) {
        this.pageMapper = pageMapper;
    }

    @Override
    public List<Type> getSortPage() {
        return pageMapper.getSortPage();
    }
}
