package edu.hfut.across.backend.dto.anchor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRoomReqBean {

    private String title;
    private String announcement;
    private String type;
    private String cover;
    private Integer userId;
}
