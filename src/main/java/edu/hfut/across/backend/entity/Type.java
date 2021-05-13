package edu.hfut.across.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    private Integer id;
    private String name;
    private String src;
}
