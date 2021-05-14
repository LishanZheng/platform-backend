package edu.hfut.across.backend.dao;

import edu.hfut.across.backend.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface RoomMapper {
    Room getRoomDetail(String roomNumber);
}
