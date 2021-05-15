package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.AnchorMapper;
import edu.hfut.across.backend.dao.RoomMapper;
import edu.hfut.across.backend.entity.Anchor;
import edu.hfut.across.backend.entity.Room;
import edu.hfut.across.backend.entity.RoomResponse;
import edu.hfut.across.backend.entity.User_Room;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImp implements RoomService {

    final
    RoomMapper roomMapper;

    final
    AnchorMapper anchorMapper;

    @Autowired
    public RoomServiceImp(RoomMapper roomMapper, AnchorMapper anchorMapper) {
        this.roomMapper = roomMapper;
        this.anchorMapper = anchorMapper;
    }

    @Override
    public RoomResponse getRoomDetail(String roomNumber) {
        Room room = roomMapper.getRoomDetail(roomNumber);
        Integer anchorId = room.getAnchorId();
        Anchor anchor = anchorMapper.getAnchorById(anchorId);
        RoomResponse roomResponse = new RoomResponse();
        BeanUtils.copyProperties(room, roomResponse);
        roomResponse.setAnchor(anchor);
        return roomResponse;
    }

    @Override
    public void subscribe(Integer roomId, Integer userId, Boolean signal) {
        if (signal) {
            roomMapper.subscribe(roomId, userId);
        } else {
            roomMapper.cancelSub(roomId, userId);
        }
    }

    @Override
    public Boolean getSubInform(Integer roomId, Integer userId) {
        User_Room user_room = roomMapper.getSubInform(roomId, userId);
        return user_room != null;
    }
}
