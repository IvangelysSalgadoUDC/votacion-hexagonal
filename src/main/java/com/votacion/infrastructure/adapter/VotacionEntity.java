package com.votacion.infrastructure.adapter;

import jakarta.persistence.*;

@Entity
@Table(name = "Votacion")
public class VotacionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fecha;
    private String partidoPolitico;
    private String candidato;
    private String votante;
    private String pais;
    private String departamento;
    private String ciudad;
    private String mesa;
    private String puestoPolitico;
    private String duracion;
    private String numeroTarjeton;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
    public String getPartidoPolitico() { return partidoPolitico; }
    public void setPartidoPolitico(String p) { this.partidoPolitico = p; }
    public String getCandidato() { return candidato; }
    public void setCandidato(String candidato) { this.candidato = candidato; }
    public String getVotante() { return votante; }
    public void setVotante(String votante) { this.votante = votante; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public String getDepartamento() { return departamento; }
    public void setDepartamento(String d) { this.departamento = d; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getMesa() { return mesa; }
    public void setMesa(String mesa) { this.mesa = mesa; }
    public String getPuestoPolitico() { return puestoPolitico; }
    public void setPuestoPolitico(String p) { this.puestoPolitico = p; }
    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }
    public String getNumeroTarjeton() { return numeroTarjeton; }
    public void setNumeroTarjeton(String n) { this.numeroTarjeton = n; }
}