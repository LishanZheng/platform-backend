package edu.hfut.across.backend.service;

import edu.hfut.across.backend.entity.RoomResponse;
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
    RoomResponse getRoomDetail(String roomNumber);
}
