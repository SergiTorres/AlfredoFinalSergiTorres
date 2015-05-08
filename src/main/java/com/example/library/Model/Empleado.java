package com.example.library.Model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	protected Long id;

	@Column
	protected String name;

	@Column
	protected String dni;

	public Empleado() {
	}

	public Empleado(Long id, String name, String dni) {
		this.id = id;
		this.name = name;
		this.dni = dni;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Empleado{" +
				"id=" + id +
				", name='" + name + '\'' +
				", dni='" + dni + '\'' +
				'}';
	}
}
