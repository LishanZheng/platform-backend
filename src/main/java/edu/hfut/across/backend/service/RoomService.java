package edu.hfut.across.backend.service;

import edu.hfut.across.backend.entity.RoomResponse;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    RoomResponse getRoomDetail(String roomNumber);

    void subscribe(Integer roomId, Integer userId, Boolean signal);

    Boolean getSubInform(Integer roomId, Integer userId);

    void editRoomInform(Integer id, String title, String announcement, String type, String cover, Integer quantity, Integer stars);
}
