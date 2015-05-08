package com.example.library.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name="id")
public class Developer extends Empleado{

	private String categoria;

	@ManyToMany(mappedBy = "developers")
	private Set<Proyecto> proyectos = new HashSet<>();

	@ManyToMany
	private Set<Especialidad> especialidades = new HashSet<>();

	public Developer() {
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Set<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(Set<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public Set<Especialidad> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(Set<Especialidad> especialidades) {
		this.especialidades = especialidades;
	}

	public Developer(Long id, String name,String dni, String categoria) {
		super(id, name, dni);
		this.categoria = categoria;
	}



	@Override
	public String toString() {
		return "DeveloperRepository{" +
				"categoria=" + categoria +
				'}';
	}
}
