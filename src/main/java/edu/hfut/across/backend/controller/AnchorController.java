package edu.hfut.across.backend.controller;

import edu.hfut.across.backend.dto.anchor.GetAnchorReqBean;
import edu.hfut.across.backend.dto.room.RoomByNumberReqBean;
import edu.hfut.across.backend.entity.Anchor;
import edu.hfut.across.backend.entity.Response;
import edu.hfut.across.backend.service.AnchorService;
import edu.hfut.across.backend.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("anchor")
public class AnchorController {

    final
    AnchorService anchorService;

    @Autowired
    AnchorController(AnchorService anchorService) {
        this.anchorService = anchorService;
    }

    @PostMapping("/get")
    @ResponseBody
    public Response getAnchor(@RequestBody GetAnchorReqBean getAnchorReqBean) {
        Integer userId = getAnchorReqBean.getUserId();
        Anchor anchor = anchorService.getAnchor(userId);
        return ResponseUtil.success("主播信息获取成功", anchor);
    }
}
