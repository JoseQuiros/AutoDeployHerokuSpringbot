package com.example.labspringboot.controller;


import com.example.labspringboot.domain.Times;
import com.example.labspringboot.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/time")
@CrossOrigin
public class TimeController {

    @Autowired
    private TimeService service;

    @GetMapping("/getTimes")
    public List<Times> getTimes() { return service.getTimes();
    }
}
