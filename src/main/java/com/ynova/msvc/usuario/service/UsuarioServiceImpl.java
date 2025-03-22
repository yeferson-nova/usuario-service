package com.ynova.msvc.usuario.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ynova.msvc.usuario.entity.Calificacion;
import com.ynova.msvc.usuario.entity.Hotel;
import com.ynova.msvc.usuario.entity.Usuario;
import com.ynova.msvc.usuario.exception.ResourceNotFoundException;
import com.ynova.msvc.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private RestTemplate restTemplate;

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario not found: " + usuarioId));

        String urlUser = "http://CALIFICACION-SERVICE/calificaciones/usuarios/" + usuario.getUsuarioId();

        Calificacion[] calificacionesUsuario = restTemplate.getForObject(urlUser, Calificacion[].class);
        List<Calificacion> calificaciones = Arrays.stream(calificacionesUsuario).collect(Collectors.toList());

        List<Calificacion> listaCalificaciones = calificaciones.stream().map(calificacion -> {
            String urlHotel = "http://HOTEL-SERVICE/hoteles/" + calificacion.getHotelId();
            System.out.println("Calificacion: " + calificacion.getHotelId());
            ResponseEntity<Hotel> forEtity = restTemplate.getForEntity(urlHotel, Hotel.class);
            Hotel hotel = forEtity.getBody();
            logger.info("Respuesta con codigo de estado: " + forEtity.getStatusCode());

            calificacion.setHotel(hotel);
            return calificacion;
        }).collect(Collectors.toList());

        logger.info("Calificaciones: " + calificacionesUsuario);
        usuario.setCalificaciones(listaCalificaciones);
        return usuario;
    }

}
