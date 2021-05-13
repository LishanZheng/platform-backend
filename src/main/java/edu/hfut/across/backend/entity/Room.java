package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    private Integer id;
    private Integer anchorId;
    private String roomNumber;
    private String title;
    private String announcement;
    private String cover;
    private Integer spectators;
    private Integer stars;
    private String type;
}
