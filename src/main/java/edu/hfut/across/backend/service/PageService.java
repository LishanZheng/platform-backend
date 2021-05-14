package edu.hfut.across.backend.service;

import edu.hfut.across.backend.entity.RoomResponse;
import edu.hfut.across.backend.entity.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PageService {

    List<RoomResponse> getRoomList();

    List<RoomResponse> getRoomList(String type);

    List<Type> getSortPage();

    List<RoomResponse> getSubRoomList(Integer userId);
}
