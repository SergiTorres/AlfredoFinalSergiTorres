package com.example.library.Controllers;

import com.example.library.Model.Especialidad;
import com.example.library.Repositories.EspecialidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Sergi on 21/04/2015.
 */

@RestController
@RequestMapping("/especialidades")
public class EspecialidadController {

    @Autowired
    private EspecialidadRepository especialidadRepository;


    //método encargado de crear Especialidades
    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Especialidad save(@RequestBody Especialidad especialidad) {
     return especialidadRepository.save(especialidad);
    }

    //método encargado de buscar una Especialidad mediante su ID
    @RequestMapping(value = "/{id}", method = GET)
    public Especialidad findById(@PathVariable Long id) {
        return especialidadRepository.findOne(id);
    }


    //método encargado de listar todas las Especialidades
    @RequestMapping(method = GET)
    public List<Especialidad> findAll() {
        List<Especialidad> especialidades = new ArrayList<Especialidad>();
        Iterator<Especialidad> iterator = especialidadRepository.findAll().iterator();

        while(iterator.hasNext()){
            Especialidad especialidad = iterator.next();
            especialidades.add(especialidad);
            System.out.println(especialidad);
        }
        return especialidades;
    }

}
