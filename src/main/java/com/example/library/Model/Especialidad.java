package com.example.library.Model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergi on 17/04/2015.
 */
@Entity

public class Especialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    protected Long id;
    @Column
    protected String name;

    @ManyToMany(mappedBy = "especialidades")
    private Set<Developer> developers = new HashSet<>();

    @ManyToMany(mappedBy = "especialidades")
    private Set<Proyecto> proyectos = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Developer> getDevelopers() {
        return developers;
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDevelopers(Set<Developer> developers) {
        this.developers = developers;
    }

    public void setProyectos(Set<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Especialidad(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    public Especialidad() {

    }
}
