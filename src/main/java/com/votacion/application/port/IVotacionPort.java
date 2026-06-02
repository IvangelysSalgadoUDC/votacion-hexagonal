package com.votacion.application.port;

import com.votacion.domain.model.Votacion;
import java.util.List;

public interface IVotacionPort {
    List<Votacion> listarVotaciones();
    Votacion buscarPorId(Long id);
    Votacion guardar(Votacion votacion);
    Votacion actualizar(Long id, Votacion votacion);
    void eliminar(Long id);
}
