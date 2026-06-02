package com.votacion.infrastructure.adapter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IVotacionRepository extends JpaRepository<VotacionEntity, Long> {
}
