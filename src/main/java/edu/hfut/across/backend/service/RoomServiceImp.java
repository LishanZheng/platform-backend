package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.AnchorMapper;
import edu.hfut.across.backend.dao.PageMapper;
import edu.hfut.across.backend.dao.RoomMapper;
import edu.hfut.across.backend.entity.Anchor;
import edu.hfut.across.backend.entity.Room;
import edu.hfut.across.backend.entity.RoomResponse;
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
}
