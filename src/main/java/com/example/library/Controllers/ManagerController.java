package com.example.library.Controllers;

import com.example.library.Model.Manager;
import com.example.library.Repositories.ManagerRepository;
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
@RequestMapping("/managers")
public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;

    //método encargado de crear managers
    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Manager save(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }


    //método encargado de buscar un Manager mediante su ID
    @RequestMapping(value = "/{id}", method = GET)
    public Manager findById(@PathVariable Long id) {
        return managerRepository.findOne(id);
    }

    //método encargado de listar todos los Managers
    @RequestMapping( method = GET)
    public List<Manager> findAll() {
        List<Manager> managers = new ArrayList<Manager>();
        Iterator<Manager> iterator = managerRepository.findAll().iterator();

        while(iterator.hasNext()){
            Manager manager = iterator.next();
            managers.add(manager);
            System.out.println(manager);
        }
        return managers;
    }

}
