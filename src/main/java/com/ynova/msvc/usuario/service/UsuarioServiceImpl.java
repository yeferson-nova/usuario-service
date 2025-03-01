package com.ynova.msvc.usuario.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ynova.msvc.usuario.entity.Usuario;
import com.ynova.msvc.usuario.exception.ResourceNotFoundExeption;
import com.ynova.msvc.usuario.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

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
        return usuarioRepository.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundExeption("Usuario no encontrado con el ID: " + usuarioId));
    }

}
