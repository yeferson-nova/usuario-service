package com.ynova.msvc.usuario.external.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ynova.msvc.usuario.entity.Hotel;

public interface HotelService {

    @GetMapping("/hoteles/{id}")
    Hotel getHotel(@PathVariable Long id);

}
