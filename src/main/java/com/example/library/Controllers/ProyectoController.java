package com.example.library.Controllers;

import com.example.library.Model.Developer;
import com.example.library.Model.Especialidad;
import com.example.library.Model.Manager;
import com.example.library.Model.Proyecto;
import com.example.library.Repositories.EspecialidadRepository;
import com.example.library.Repositories.ProyectoRepository;
import com.example.library.Repositories.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Sergi on 21/04/2015.
 */

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private EspecialidadRepository especialidadRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    //método encargado de crear un proyecto
    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Proyecto save(@RequestBody Proyecto proyecto) {

        return proyectoRepository.save(proyecto);
    }

    @RequestMapping(value = "/{idProyecto}/developers/{idDeveloper}", method = POST)
    public Proyecto addDeveloper(@PathVariable Long idProyecto, @PathVariable Long idDeveloper) {

        Proyecto proyecto = proyectoRepository.findOne(idProyecto);
        Developer developer = developerRepository.findOne(idDeveloper);

        boolean accepted = false;

        //foreach que se encarga de comprobar si el developer contiene la especialidad requerida por el proyecto
        for (Especialidad especialidad : proyecto.getEspecialidades()){
            if(developer.getEspecialidades().contains(especialidad) ){
                accepted = true;
                break;
            }
        }
        if (accepted) {
            proyecto.getDevelopers().add(developer);
            proyectoRepository.save(proyecto);

        }else{
            throw new RuntimeException("The developer doesn't contain the required specialties!");
        }


        return proyecto;
    }


    //Añadimos especialidades a un proyecto
    @RequestMapping(value = "/{idProyecto}/especialidades/{idEspecialidad}", method = POST)
     public Proyecto addEspecialidad(@PathVariable Long idProyecto, @PathVariable Long idEspecialidad) {

        Proyecto proyecto = proyectoRepository.findOne(idProyecto);
        Especialidad especialidad = especialidadRepository.findOne(idEspecialidad);

        proyecto.getEspecialidades().add(especialidad);
        proyectoRepository.save(proyecto);

        return proyecto;
    }

    @RequestMapping(value = "/{idProyecto}/especialidades/{idEspecialidad}", method = GET)
    public Proyecto getEspecialidad(@PathVariable Long idProyecto, @RequestBody Long idEspecialidad) {

        Proyecto proyecto = proyectoRepository.findOne(idProyecto);
        Especialidad especialidad = especialidadRepository.findOne(idEspecialidad);

        proyecto.getEspecialidades().add(especialidad);
        proyectoRepository.save(proyecto);

        return proyecto;
    }

    //Comprobar la logica de que un developer ha de dominar como minimo una de las especialidades requeridas por el proyecto.
    @RequestMapping(value = "/{idProyecto}/developers/{idDeveloper}", method = GET)
    public Proyecto getProyectoDevelopers(@PathVariable Long idProyecto, @RequestBody Long idDeveloper) {

        Proyecto proyecto = proyectoRepository.findOne(idProyecto);
        Developer developer = developerRepository.findOne(idDeveloper);

        boolean accepted = false;

        //foreach que se encarga de comprobar si el developer contiene la especialidad requerida por el proyecto
        for (Especialidad especialidad : proyecto.getEspecialidades()){
            if(developer.getEspecialidades().contains(especialidad) ){
                accepted = true;
                break;
            }
        }
        if (accepted) {
            proyecto.getDevelopers().add(developer);
            proyectoRepository.save(proyecto);

        }else{
            throw new RuntimeException("The developer doesn't contain the required specialties!");
        }


        return proyecto;
    }

    //método que se encarga de buscar un proyecto mediante su ID
    @RequestMapping(value = "/{id}", method = GET)
    public Proyecto findById(@PathVariable Long id) {

        return proyectoRepository.findOne(id);
    }

    @RequestMapping( method = GET)
    public List<Proyecto> findAll() {
        List<Proyecto> proyectos = new ArrayList<Proyecto>();
        Iterator<Proyecto> iterator = proyectoRepository.findAll().iterator();

        while(iterator.hasNext()){
            Proyecto proyecto = iterator.next();
            proyectos.add(proyecto);
            System.out.println(proyecto);
        }
        return proyectos;
    }



}
