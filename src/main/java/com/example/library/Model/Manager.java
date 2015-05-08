package com.example.library.Model;

import javax.persistence.*;
import java.util.Collection;


@Entity
@PrimaryKeyJoinColumn(name="id")
public class Manager extends Empleado{

	@OneToMany(mappedBy = "manager")
	Collection<Proyecto> proyecto;

	public Manager() {
	}

	public Collection<Proyecto> getProyecto() {
		return proyecto;
	}

	public void setProyecto(Collection<Proyecto> proyecto) {
		this.proyecto = proyecto;
	}

	public Manager(Long id, String name,String dni) {
		super(id, name,dni);
	}

}
