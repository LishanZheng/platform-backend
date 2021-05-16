package edu.hfut.across.backend.dao;

import edu.hfut.across.backend.entity.Room;
import edu.hfut.across.backend.entity.Type;
import edu.hfut.across.backend.entity.User_Room;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface RoomMapper {
    Room getRoomDetail(String roomNumber);

    void subscribe(Integer roomId, Integer userId);

    void cancelSub(Integer roomId, Integer userId);

    User_Room getSubInform(Integer roomId, Integer userId);

    void editRoomInform(Integer id, String title, String announcement, String type, String cover, Integer quantity, Integer stars);
}
