package edu.hfut.across.backend.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscribeReqBean {

    private Integer roomId;
    private Integer userId;
    private Boolean signal;
}
