package com.ynova.msvc.usuario.external.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ynova.msvc.usuario.entity.Calificacion;

@FeignClient(name = "CALIFICACION-SERVICE")
public interface CalificacionService {

    @PostMapping
    public ResponseEntity<Calificacion> saveCalificacion(Calificacion calificacion);

    @PostMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<Calificacion> updateCalificacion(Long calificacionId, Calificacion calificacion);

    @DeleteMapping("/calificaciones/{calificacionId}")
    public ResponseEntity<Calificacion> deleteCalificacion(@PathVariable Long calificacionId);
}
