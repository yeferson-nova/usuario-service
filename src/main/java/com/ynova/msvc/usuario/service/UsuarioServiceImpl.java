package com.ynova.msvc.usuario.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ynova.msvc.usuario.entity.Calificacion;
import com.ynova.msvc.usuario.entity.Usuario;
import com.ynova.msvc.usuario.exception.ResourceNotFoundExeption;
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
                .orElseThrow(() -> new ResourceNotFoundExeption("Usuario not found"));
    
        String url = "http://CALIFICACION-SERVICE/calificaciones/usuarios/" + usuario.getUsuarioId();
    
        ArrayList<Calificacion> calificacionesUsuario = restTemplate.getForObject(url, ArrayList.class);
        logger.info("Calificaciones: " + calificacionesUsuario);
        usuario.setCalificaciones(calificacionesUsuario);
        return usuario;
    }
    

}
