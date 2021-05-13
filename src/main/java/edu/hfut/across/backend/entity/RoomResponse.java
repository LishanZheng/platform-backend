package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {

    private Integer id;
    private Anchor anchor;
    private String roomNumber;
    private String title;
    private String announcement;
    private String cover;
    private Integer quantity;
    private Integer stars;
    private String type;
}
