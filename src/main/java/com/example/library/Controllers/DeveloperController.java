package com.example.library.Controllers;


import com.example.library.Model.Developer;
import com.example.library.Repositories.DeveloperRepository;
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
@RequestMapping("/developers")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    //método encargado de crear Developers
    @RequestMapping(method = POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Developer save(@RequestBody Developer developer) {

        return developerRepository.save(developer);
    }

    //método encargado de buscar un Developer mediante su ID
    @RequestMapping(value = "/{id}", method = GET)
    public Developer findById(@PathVariable Long id) {
        return developerRepository.findOne(id);
    }

    //método encargado de listar todos los Developers
    @RequestMapping(method = GET)
    public List<Developer> findAll() {
        List<Developer> developers = new ArrayList<Developer>();
        Iterator<Developer> iterator = developerRepository.findAll().iterator();

        while(iterator.hasNext()){
            Developer developer = iterator.next();
            developers.add(developer);
            System.out.println(developer);
        }

        return developers;
    }



}
