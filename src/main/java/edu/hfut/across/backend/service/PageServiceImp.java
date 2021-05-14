package edu.hfut.across.backend.service;

import edu.hfut.across.backend.dao.AnchorMapper;
import edu.hfut.across.backend.dao.PageMapper;
import edu.hfut.across.backend.entity.Anchor;
import edu.hfut.across.backend.entity.Room;
import edu.hfut.across.backend.entity.RoomResponse;
import edu.hfut.across.backend.entity.Type;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PageServiceImp implements PageService {

    final
    PageMapper pageMapper;

    final
    AnchorMapper anchorMapper;

    @Autowired
    public PageServiceImp(PageMapper pageMapper, AnchorMapper anchorMapper) {
        this.pageMapper = pageMapper;
        this.anchorMapper = anchorMapper;
    }

    @Override
    public List<RoomResponse> getRoomList() {

        List<Room> roomList = pageMapper.getRoomList();
        return getRoomResponses(roomList);
    }

    @Override
    public List<RoomResponse> getRoomList(String type) {
        List<Room> roomList = pageMapper.getRoomListByType(type);
        return getRoomResponses(roomList);
    }

    @Override
    public List<Type> getSortPage() {
        return pageMapper.getSortPage();
    }

    @Override
    public List<RoomResponse> getSubRoomList(Integer userId) {
        List<Room> roomList = pageMapper.getSubRoomList(userId);
        return getRoomResponses(roomList);
    }

    public List<RoomResponse> getRoomResponses(List<Room> roomList) {
        List<RoomResponse> responseList = new ArrayList<RoomResponse>();
        for (Room room : roomList) {
            RoomResponse roomResponse = new RoomResponse();
            // 复制 Room 和 RoomResponse 重复的部分
            BeanUtils.copyProperties(room, roomResponse);
            Integer anchorId = room.getAnchorId();
            Anchor anchor = anchorMapper.getAnchorById(anchorId);
            roomResponse.setAnchor(anchor);
            responseList.add(roomResponse);
        }
        return responseList;
    }
}
