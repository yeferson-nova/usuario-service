package com.ynova.msvc.usuario.entity;

import java.time.ZonedDateTime;

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
    private ZonedDateTime fecha;
    private int calificacion;
    private String comentario;
    private Hotel hotel;
}
