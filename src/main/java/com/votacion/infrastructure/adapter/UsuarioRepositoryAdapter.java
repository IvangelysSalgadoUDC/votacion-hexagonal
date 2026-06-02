package com.votacion.infrastructure.adapter;

import com.votacion.application.port.IUsuarioPort;
import com.votacion.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component("usuarioRepositoryPort")
public class UsuarioRepositoryAdapter implements IUsuarioPort {

    @Autowired
    private IUsuarioRepository repository;

    private Usuario toModel(UsuarioEntity e) {
        Usuario u = new Usuario();
        u.setId(e.getId());
        u.setCedula(e.getCedula());
        u.setNombre(e.getNombre());
        u.setEmail(e.getEmail());
        u.setClave(e.getClave());
        u.setRol(e.getRol());
        return u;
    }

    private UsuarioEntity toEntity(Usuario u) {
        UsuarioEntity e = new UsuarioEntity();
        e.setId(u.getId());
        e.setCedula(u.getCedula());
        e.setNombre(u.getNombre());
        e.setEmail(u.getEmail());
        e.setClave(u.getClave());
        e.setRol(u.getRol());
        return e;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return repository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = toEntity(usuario);
        return toModel(repository.save(entity));
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        return toModel(repository.save(toEntity(usuario)));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
