package com.ynova.msvc.usuario.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Calificacion {
    private String id;
    private Long usuarioId;
    private Long hotelId;
    private int calificacion;
    private String comentario;
}
