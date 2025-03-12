package com.ynova.msvc.usuario.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {

    private Long id;
    private String information;
    private String ubication;
    private String name;
    private String phone;

}
