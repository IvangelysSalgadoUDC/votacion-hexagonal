package com.votacion.application.service;

import com.votacion.application.port.IUsuarioPort;
import com.votacion.domain.exception.UsuarioNotFoundException;
import com.votacion.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService implements IUsuarioPort {

    @Autowired
    private IUsuarioPort usuarioRepositoryPort;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepositoryPort.listarUsuarios();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        Usuario usuario = usuarioRepositoryPort.buscarPorId(id);
        if (usuario == null) {
            throw new UsuarioNotFoundException("Usuario no encontrado con id: " + id);
        }
        return usuario;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        usuario.setClave(passwordEncoder.encode(usuario.getClave()));
        if (usuario.getRol() == null || usuario.getRol().isEmpty()) {
            usuario.setRol("USER");
        }
        return usuarioRepositoryPort.guardar(usuario);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Usuario existente = buscarPorId(id);
        existente.setNombre(usuario.getNombre());
        existente.setEmail(usuario.getEmail());
        existente.setCedula(usuario.getCedula());
        if (usuario.getClave() != null && !usuario.getClave().isEmpty()) {
            existente.setClave(passwordEncoder.encode(usuario.getClave()));
        }
        return usuarioRepositoryPort.guardar(existente);
    }

    @Override
    public void eliminar(Long id) {
        buscarPorId(id);
        usuarioRepositoryPort.eliminar(id);
    }
}
