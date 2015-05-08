package com.example.library.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergi on 17/04/2015.
 */

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;
    protected String descripcion;
    protected Date fechaInicio;
    protected Date fechaFin;

    @ManyToOne
    @JsonIgnore
    private Manager manager;

    @ManyToMany
    @JsonIgnore
    private Set<Developer> developers = new HashSet<>();

    @ManyToMany
    @JsonIgnore
    private Set<Especialidad> especialidades = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public Manager getManager() {
        return manager;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public Set<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(Set<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public Proyecto(String descripcion, Date fechaInicio, Date fechaFin) {
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Proyecto() {

    }


}
