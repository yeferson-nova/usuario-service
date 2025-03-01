package com.ynova.msvc.usuario.service;

import java.util.List;

import com.ynova.msvc.usuario.entity.Usuario;

public interface UsuarioService {

    Usuario saveUsuario(Usuario usuario);

    List<Usuario> getAllUsuarios();

    Usuario getUsuario(Long usuarioId);

}
