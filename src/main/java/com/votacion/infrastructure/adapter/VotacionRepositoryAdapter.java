package com.votacion.infrastructure.adapter;

import com.votacion.application.port.IVotacionPort;
import com.votacion.domain.model.Votacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component("votacionRepositoryPort")
public class VotacionRepositoryAdapter implements IVotacionPort {

    @Autowired
    private IVotacionRepository repository;

    private Votacion toModel(VotacionEntity e) {
        Votacion v = new Votacion();
        v.setId(e.getId());
        v.setFecha(e.getFecha());
        v.setPartidoPolitico(e.getPartidoPolitico());
        v.setCandidato(e.getCandidato());
        v.setVotante(e.getVotante());
        v.setPais(e.getPais());
        v.setDepartamento(e.getDepartamento());
        v.setCiudad(e.getCiudad());
        v.setMesa(e.getMesa());
        v.setPuestoPolitico(e.getPuestoPolitico());
        v.setDuracion(e.getDuracion());
        v.setNumeroTarjeton(e.getNumeroTarjeton());
        return v;
    }

    private VotacionEntity toEntity(Votacion v) {
        VotacionEntity e = new VotacionEntity();
        e.setId(v.getId());
        e.setFecha(v.getFecha());
        e.setPartidoPolitico(v.getPartidoPolitico());
        e.setCandidato(v.getCandidato());
        e.setVotante(v.getVotante());
        e.setPais(v.getPais());
        e.setDepartamento(v.getDepartamento());
        e.setCiudad(v.getCiudad());
        e.setMesa(v.getMesa());
        e.setPuestoPolitico(v.getPuestoPolitico());
        e.setDuracion(v.getDuracion());
        e.setNumeroTarjeton(v.getNumeroTarjeton());
        return e;
    }

    @Override
    public List<Votacion> listarVotaciones() {
        return repository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Votacion buscarPorId(Long id) {
        return repository.findById(id)
                .map(this::toModel)
                .orElse(null);
    }

    @Override
    public Votacion guardar(Votacion votacion) {
        return toModel(repository.save(toEntity(votacion)));
    }

    @Override
    public Votacion actualizar(Long id, Votacion votacion) {
        votacion.setId(id);
        return toModel(repository.save(toEntity(votacion)));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
