package com.votacion.application.port;

import com.votacion.domain.model.Usuario;
import java.util.List;

public interface IUsuarioPort {
    List<Usuario> listarUsuarios();
    Usuario buscarPorId(Long id);
    Usuario guardar(Usuario usuario);
    Usuario actualizar(Long id, Usuario usuario);
    void eliminar(Long id);
}
