package com.example.library.Repositories;

import com.example.library.Model.Especialidad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EspecialidadRepository extends PagingAndSortingRepository<Especialidad,Long> {

    List<Especialidad> findByName(@Param("name") String name);




}