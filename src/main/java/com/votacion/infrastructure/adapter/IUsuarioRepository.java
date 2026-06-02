package com.votacion.infrastructure.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    UsuarioEntity findByCedula(String cedula);
    UsuarioEntity findByEmail(String email);
}
