package edu.hfut.across.backend.controller;


import edu.hfut.across.backend.dto.room.EditRoomInformReqBean;
import edu.hfut.across.backend.dto.room.RoomByNumberReqBean;
import edu.hfut.across.backend.dto.room.SubscribeReqBean;
import edu.hfut.across.backend.entity.Response;
import edu.hfut.across.backend.entity.RoomResponse;
import edu.hfut.across.backend.service.RoomService;
import edu.hfut.across.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("room")
public class RoomController {

    final
    RoomService roomService;

    @Autowired
    RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/get")
    @ResponseBody
    public Response getRoomByNumber(@RequestBody RoomByNumberReqBean roomByNumberReqBean) {

        String roomNumber = roomByNumberReqBean.getRoomNumber();
        RoomResponse roomResponse = roomService.getRoomDetail(roomNumber);
        return ResponseUtil.success("指定房间号直播间信息获取成功", roomResponse);
    }

    @PostMapping("/subs")
    @ResponseBody
    public Response subscribeRoom(@RequestBody SubscribeReqBean subscribeReqBean) {

        Boolean signal = subscribeReqBean.getSignal();
        Integer roomId = subscribeReqBean.getRoomId();
        Integer userId = subscribeReqBean.getUserId();
        if (signal == null) {
            Boolean result = roomService.getSubInform(roomId, userId);
            return ResponseUtil.success("订阅信息获取成功", result);
        } else {
            roomService.subscribe(roomId, userId, signal);
            return ResponseUtil.success("订阅信息修改成功");
        }
    }

    @PostMapping("/edit")
    @ResponseBody
    public Response editRoomInform(@RequestBody EditRoomInformReqBean editRoomInformReqBean) {

        Integer id = editRoomInformReqBean.getId();
        String title = editRoomInformReqBean.getTitle();
        String announcement = editRoomInformReqBean.getAnnouncement();
        String type = editRoomInformReqBean.getType();
        String cover = editRoomInformReqBean.getCover();
        Integer quantity = editRoomInformReqBean.getQuantity();
        Integer stars = editRoomInformReqBean.getStars();
        roomService.editRoomInform(id, title, announcement, type, cover, quantity, stars);
        return ResponseUtil.success("房间信息修改成功");
    }
}
