package com.example.library.Repositories;


import com.example.library.Model.Manager;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Warren on 14/04/2015.
 */
public interface ManagerRepository extends PagingAndSortingRepository<Manager, Long> {

    List<Manager> findByName(@Param("nombre") String name);
    List<Manager> findByDni(@Param("dni") String dni);

}
