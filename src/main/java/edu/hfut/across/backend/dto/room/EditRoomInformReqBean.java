package edu.hfut.across.backend.dto.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditRoomInformReqBean {

    private Integer id;
    private String title;
    private String announcement;
    private String cover;
    private Integer quantity;
    private Integer stars;
    private String type;
}
