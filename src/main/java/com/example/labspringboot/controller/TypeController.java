package com.example.labspringboot.controller;


import com.example.labspringboot.domain.Times;
import com.example.labspringboot.domain.Typevehicle;
import com.example.labspringboot.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/type")
@CrossOrigin
public class TypeController {

    @Autowired
    private TypeService service;

    @GetMapping("/getTypes")
    public List<Typevehicle> getTypes() { return service.getTypes();
    }
}
