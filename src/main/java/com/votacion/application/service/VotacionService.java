package com.votacion.application.service;

import com.votacion.application.port.IVotacionPort;
import com.votacion.domain.exception.VotacionNotFoundException;
import com.votacion.domain.model.Votacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VotacionService implements IVotacionPort {

    @Autowired
    private IVotacionPort votacionRepositoryPort;

    @Override
    public List<Votacion> listarVotaciones() {
        return votacionRepositoryPort.listarVotaciones();
    }

    @Override
    public Votacion buscarPorId(Long id) {
        Votacion votacion = votacionRepositoryPort.buscarPorId(id);
        if (votacion == null) {
            throw new VotacionNotFoundException("Votacion no encontrada con id: " + id);
        }
        return votacion;
    }

    @Override
    public Votacion guardar(Votacion votacion) {
        return votacionRepositoryPort.guardar(votacion);
    }

    @Override
    public Votacion actualizar(Long id, Votacion votacion) {
        Votacion existente = buscarPorId(id);
        existente.setFecha(votacion.getFecha());
        existente.setPartidoPolitico(votacion.getPartidoPolitico());
        existente.setCandidato(votacion.getCandidato());
        existente.setVotante(votacion.getVotante());
        existente.setPais(votacion.getPais());
        existente.setDepartamento(votacion.getDepartamento());
        existente.setCiudad(votacion.getCiudad());
        existente.setMesa(votacion.getMesa());
        existente.setPuestoPolitico(votacion.getPuestoPolitico());
        existente.setDuracion(votacion.getDuracion());
        existente.setNumeroTarjeton(votacion.getNumeroTarjeton());
        return votacionRepositoryPort.guardar(existente);
    }

    @Override
    public void eliminar(Long id) {
        buscarPorId(id);
        votacionRepositoryPort.eliminar(id);
    }
}
