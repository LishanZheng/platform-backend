package edu.hfut.across.backend.dao;

import edu.hfut.across.backend.entity.Anchor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface AnchorMapper {

    Anchor getAnchorById(Integer anchorId);

    Anchor getAnchorByRoomNumber(String roomNumber);

    Integer register(String name, String avatar, String roomNumber);

}
