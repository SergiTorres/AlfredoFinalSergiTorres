package com.example.library.Repositories;


import com.example.library.Model.Especialidad;
import com.example.library.Model.Proyecto;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ProyectoRepository extends PagingAndSortingRepository<Proyecto, Long> {
	List<Proyecto> findByDescripcion(@Param("descripcion") String firstName);
	List<Proyecto> findByFechaInicio(@Param("fechaInicio") Date fechaInicio);
	List<Proyecto> findByFechaFin(@Param("fechaFin") Date fechaFin);


}
