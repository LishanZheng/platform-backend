package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anchor {

    private Integer id;
    private String account;
    private String email;
    private String password;
    private String name;
    private String avatar;
    private String roomNumber;
}
