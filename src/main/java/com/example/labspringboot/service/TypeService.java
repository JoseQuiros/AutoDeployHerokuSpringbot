package com.example.labspringboot.service;


import com.example.labspringboot.domain.Times;
import com.example.labspringboot.domain.Typevehicle;
import com.example.labspringboot.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TypeService {

    @Autowired
    private TypeRepository repository;

    public List<Typevehicle> getTypes() { return repository.getTypes();
    }
}
