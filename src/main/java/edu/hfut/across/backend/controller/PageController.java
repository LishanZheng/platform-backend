package edu.hfut.across.backend.controller;

import edu.hfut.across.backend.dto.pages.RoomPageTypeReqBean;
import edu.hfut.across.backend.dto.pages.SubRoomReqBean;
import edu.hfut.across.backend.entity.Response;
import edu.hfut.across.backend.entity.RoomResponse;
import edu.hfut.across.backend.entity.Type;
import edu.hfut.across.backend.service.PageService;
import edu.hfut.across.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("page")
public class PageController {

    final
    PageService pageService;

    @Autowired
    PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @PostMapping("/room")
    @ResponseBody
    public Response getRoomListPage() {

        List<RoomResponse> roomList = pageService.getRoomList();
        return ResponseUtil.success("直播列表获取成功", roomList);
    }

    @PostMapping("/room/type")
    @ResponseBody
    public Response getRoomListPageByType(@RequestBody RoomPageTypeReqBean roomPageTypeReqBean) {

        String type = roomPageTypeReqBean.getType();
        List<RoomResponse> roomList = pageService.getRoomList(type);
        return ResponseUtil.success("按类型获取直播列表获取成功", roomList);
    }

    @PostMapping("/room/sub")
    @ResponseBody
    public Response getSubRoomList(@RequestBody SubRoomReqBean subRoomReqBean) {

        Integer userId = subRoomReqBean.getUserId();
        List<RoomResponse> roomList = pageService.getSubRoomList(userId);
        return ResponseUtil.success("获取订阅直播列表获取成功", roomList);
    }

    @PostMapping("/sort")
    @ResponseBody
    public Response getSortPage() {

        List<Type> typeList = pageService.getSortPage();
        return ResponseUtil.success("分类页获取成功", typeList);
    }
}
