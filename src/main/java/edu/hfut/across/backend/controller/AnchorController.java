package edu.hfut.across.backend.controller;

import edu.hfut.across.backend.dto.anchor.GetAnchorReqBean;
import edu.hfut.across.backend.dto.anchor.GetSubscribeReqBean;
import edu.hfut.across.backend.dto.anchor.RegisterRoomReqBean;
import edu.hfut.across.backend.entity.*;
import edu.hfut.across.backend.service.AnchorService;
import edu.hfut.across.backend.service.RoomService;
import edu.hfut.across.backend.util.ResponseUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("anchor")
public class AnchorController {

    final
    AnchorService anchorService;

    final
    RoomService roomService;

    @Autowired
    AnchorController(AnchorService anchorService, RoomService roomService) {
        this.anchorService = anchorService;
        this.roomService = roomService;
    }

    @PostMapping("/get")
    @ResponseBody
    public Response getAnchor(@RequestBody GetAnchorReqBean getAnchorReqBean) {
        Integer userId = getAnchorReqBean.getUserId();
        Anchor anchor = anchorService.getAnchor(userId);
        return ResponseUtil.success("主播信息获取成功", anchor);
    }

    @PostMapping("/sub")
    @ResponseBody
    public Response getSubscribe(@RequestBody GetSubscribeReqBean getSubscribeReqBean) {
        String roomNumber = getSubscribeReqBean.getRoomNumber();
        RoomResponse room = roomService.getRoomDetail(roomNumber);
        List<UserResponse> userList = anchorService.getSubscribe(room.getId());
        return ResponseUtil.success("订阅观众信息获取成功", userList);
    }

    @PostMapping("/register")
    @ResponseBody
    public Response registerRoom(@RequestBody RegisterRoomReqBean registerRoomReqBean) {

        String title = registerRoomReqBean.getTitle();
        String cover = registerRoomReqBean.getCover();
        String type = registerRoomReqBean.getType();
        String announcement = registerRoomReqBean.getAnnouncement();
        String roomNumber = "";
        do {
            roomNumber = RandomStringUtils.randomNumeric(5);
        } while (!roomService.checkRoomNumber(roomNumber));
        Integer anchorId = anchorService.register(registerRoomReqBean.getUserId(), roomNumber);
        roomService.register(roomNumber, title, announcement, type, cover, anchorId);
        return ResponseUtil.success("注册主播成功", roomNumber);
    }
}
